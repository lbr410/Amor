package com.amor.userController;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.amor.member.service.MemberService;
import com.amor.member.model.*;

@Controller
public class UserInfoUpdateController {
	
	@Autowired
	private MemberService memberService;

	@RequestMapping("myAmor/userInfoUpdateForm.do")
	public ModelAndView userInfoUpdateForm(HttpSession session) {
		
		int sidx=(Integer)session.getAttribute("sidx");
		
		MemberDTO dto=memberService.memberInfo(sidx);
		
		ModelAndView mav=new ModelAndView();
		mav.addObject("dto", dto);
		mav.setViewName("/user/myAmor/userInfoUpdate");
		return mav;
	}
	
}
