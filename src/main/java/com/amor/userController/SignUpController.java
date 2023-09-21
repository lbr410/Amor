package com.amor.userController;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class SignUpController {
	// 이용약관 페이지로 이동
	@RequestMapping("member/terms.do")
	public String termsForm() {
		return "user/member/terms";
	}
	
	// 회원가입 페이지로 이동
	@RequestMapping("member/signUp.do")
	public String signUpForm() {
		return "user/member/signUp";
	}
}