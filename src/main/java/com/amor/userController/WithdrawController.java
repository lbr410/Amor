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
	public String withdrawForm() {
		return "/user/myAmor/withdraw";
	}
	
	@RequestMapping("myAmor/withdrawSubmit.do")
	public ModelAndView withdrawSubmit(
			HttpSession session,
			HttpServletRequest req,
			HttpServletResponse resp) {
		
		String id=(String)session.getAttribute("sid");
		int result=memberService.memberWithDraw(id);	
		
		Cookie ck=new Cookie("saveid",id);
		ck.setMaxAge(0);
		resp.addCookie(ck);
		
		session.invalidate();

		ModelAndView mav= new ModelAndView();
		mav.setViewName("redirect:/index.do");
		
		return mav;
	}

}
