package com.amor.userController;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

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
	public String withdrawSubmit(HttpSession session) {
		
		String id=(String)session.getAttribute("sid");
		int result=memberService.memberWithDraw(id);
		
		return "index";
	}

}
