package com.amor.userController;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
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
	
	@RequestMapping(value="myAmor/userInfoUpdateSubmit.do", method = RequestMethod.POST)
	public ModelAndView userInfoUpdateSubmit(
			MemberDTO dto,
			HttpSession session) {
		
		int sidx=(Integer)session.getAttribute("sidx");
		int result=memberService.memberInfoUpdate(dto,sidx);
		String msg=result>0?"수정이 완료되었습니다.":"잘못된 접근입니다.";
		ModelAndView mav=new ModelAndView();
		mav.addObject("msg", msg);
		mav.addObject("goUrl","/amor/myAmor/userInfoUpdateForm.do");
		mav.setViewName("/user/msg/userMsg");
		return mav;
	}
	
}
