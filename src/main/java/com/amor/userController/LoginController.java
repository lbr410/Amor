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

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.amor.member.model.*;
import com.amor.encryption.*;

@Controller
public class LoginController {
	
	@Autowired
	private MemberService memberService;
	
	@RequestMapping(value="member/login.do", method = RequestMethod.GET)
	public String loginForm() {
		return "/user/member/login";
	}
	
	@RequestMapping(value="member/login.do", method =RequestMethod.POST)
	public ModelAndView loginSubmit(
			@RequestParam(value="id", defaultValue = "notid")String id,
			@RequestParam(value="pwd", defaultValue = "notpwd")String pwd2,
			@RequestParam(value="saveid" ,required = false) String saveid,
			HttpServletResponse resp,
			HttpSession session) {
		
		String pwd = Encryption.pwdEncrypt(pwd2);
		ModelAndView mav=new ModelAndView();
		
		if(id.equals("") || pwd.equals("")) {
			mav.addObject("msg", "아이디와 비밀번호를 입력해주세요.");
			mav.addObject("goUrl", "login.do");
			mav.setViewName("/user/msg/loginMsg");
			return mav;
		}
		
		MemberDTO dto=new MemberDTO(0, id, pwd, null);
		int result=memberService.memberLogin(dto);

		if(result==memberService.SUCCES) {
			if(saveid==null) {
				Cookie ck=new Cookie("saveid",id);
				ck.setMaxAge(0);
				resp.addCookie(ck);
			}else {
				Cookie ck=new Cookie("saveid",id);
				ck.setMaxAge(60*60*24*30);
				resp.addCookie(ck);
			}
			mav.addObject("msg", "성공(나중에 경고창없이 바로 메인)");
			mav.addObject("goUrl","/amor/index.do");
			mav.setViewName("/user/msg/userMsg");
			
			dto=memberService.memberSession(dto);
			session.setAttribute("sidx", dto.getMember_idx());
			session.setAttribute("sname", dto.getMember_name());
			session.setAttribute("sid", id);
			
		}else if(result==memberService.NOT_ID_PWD) {
			mav.addObject("msg", "아이디 또는 비밀번호가 맞지 않습니다.");
			mav.addObject("goUrl","/amor/member/login.do");
			mav.setViewName("/user/msg/userMsg");
		}else if(result==memberService.Join) {
			mav.addObject("msg", "회원가입이 필요합니다.(회원가입 폼으로)");
			mav.addObject("goUrl","/amor/member/signUp.do");
			mav.setViewName("/user/msg/userMsg");
		}else if(result==memberService.BLOK) {
			mav.addObject("msg", "접근이 제한된 아이디 입니다. 고객센터로 문의 바랍니다.");
			mav.addObject("goUrl","/amor/index.do");
			mav.setViewName("/user/msg/userMsg");
		}else if(result==memberService.ERROR) {
			mav.addObject("msg", "아이디와 비밀번호를 입력해주세요.");
			mav.addObject("goUrl","/amor/member/login.do");
			mav.setViewName("/user/msg/userMsg");
		}
		
		return mav;
	}
	
	@RequestMapping("member/logout.do")
	public ModelAndView logout(HttpServletRequest req) {
		HttpSession session=req.getSession();
		session.invalidate();
		ModelAndView mav=new ModelAndView();
		mav.setViewName("redirect:/index.do");
		return mav;
	}
	

}
