package com.amor.userController;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Required;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.amor.member.service.MemberService;
import java.util.*;
import com.amor.member.model.*;

@Controller
public class LoginController {
	
	@Autowired
	private MemberService memberService;
	
	@RequestMapping(value="member/login.do", method = RequestMethod.GET)
	public String loginForm() {
		return "/user/member/login";
	}
	
	@RequestMapping(value="member/loginSubmit.do", method = RequestMethod.POST)
	public ModelAndView login(
			@RequestParam(value="id", defaultValue = "notid")String id,
			@RequestParam(value="pwd", defaultValue = "notpwd")String pwd,
			@RequestParam(value="saveid" ,required = false) String saveid) {
		
//		System.out.println("id = "+id);
//		System.out.println("pwd = "+pwd);
//		id="";
//		pwd="";
//		saveid="";
//		if(id==""|| pwd=="") {
//			id="notid";
//			pwd="notpwd";
//		}
		System.out.println("id = "+id);
		System.out.println("pwd = "+pwd);
		
		MemberDTO dto=new MemberDTO(id, pwd);
		String msg=memberService.memberLogin(dto,saveid);
		
		ModelAndView mav=new ModelAndView();
		mav.addObject("msg", msg);
		mav.setViewName("/user/msg/loginMsg");
		return mav;
	}

}
