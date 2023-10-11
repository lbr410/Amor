package com.amor.userController;

import java.net.http.HttpRequest;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.amor.member.service.MemberService;

@Controller
public class WithdrawController {
	
	@Autowired
	private MemberService memberService;
	
	@RequestMapping("myAmor/withdrawForm.do")
	public ModelAndView withdrawForm(HttpSession session) {
		ModelAndView mav=new ModelAndView();
		if(session.getAttribute("sid")==null) {
			mav.addObject("msg", "잘못된 접근입니다.");
			mav.addObject("goUrl", "/amor/member/login.do");
			mav.setViewName("user/msg/userMsg");			
		}else {
			mav.setViewName("/user/myAmor/withdraw");
		}
		return mav;
	}
	
	@RequestMapping("myAmor/withdrawSubmit.do")
	public ModelAndView withdrawSubmit(
			HttpSession session,
			HttpServletResponse resp) {
		
		String id=(String)session.getAttribute("sid");
		
		int result=memberService.memberWithDraw(id);	
		
		if(result>0) {
			Cookie ck=new Cookie("ckid",id);
			ck.setMaxAge(0);
			ck.setPath("/amor/member");
			resp.addCookie(ck);
			session.invalidate();
		}
		ModelAndView mav= new ModelAndView();
		mav.setViewName("redirect:/index.do");
		
		return mav;
	}

}
