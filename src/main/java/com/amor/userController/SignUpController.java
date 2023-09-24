package com.amor.userController;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.amor.member.model.MemberDTO;
import com.amor.member.service.MemberService;
import com.amor.encryption.Encryption;

@Controller
public class SignUpController {
	
	@Autowired
	private MemberService memberService;
	
	// 이용약관 페이지로 이동
	@RequestMapping("member/terms.do")
	public String termsForm() {
		return "user/member/terms";
	}
	
	// 회원가입 페이지로 이동
	@RequestMapping(value = "member/signUp.do", method = RequestMethod.GET)
	public String signUpForm() {
		return "user/member/signUp";
	}
	
	// 아이디 중복검사
	@RequestMapping("member/idCheck.do")
	public ModelAndView idCheck(@RequestParam("id") String id) {
		String member_id = memberService.idCheck(id);

		ModelAndView mav = new ModelAndView();
		mav.addObject("member_id", member_id);
		mav.setViewName("user/member/idCheck");
		
		return mav;
	}
	
	// 회원가입
	@RequestMapping(value = "member/signUp.do", method = RequestMethod.POST)
	public ModelAndView signUp(MemberDTO dto) {
		dto.setMember_pwd(Encryption.pwdEncrypt(dto.getMember_pwd()));
		int result = memberService.signUp(dto);
		String msg = result > 0 ? "회원가입이 완료되었습니다." : "회원가입 실패!";
		
		ModelAndView mav = new ModelAndView();
		mav.addObject("msg", msg);
		mav.addObject("goUrl", "login.do");
		mav.setViewName("user/msg/userMsg");
		
		return mav;
	}
}