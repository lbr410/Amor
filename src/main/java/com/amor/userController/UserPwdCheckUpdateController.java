package com.amor.userController;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.amor.encryption.Encryption;
import com.amor.member.service.MemberService;

@Controller
public class UserPwdCheckUpdateController {
	
	@Autowired
	private MemberService memberService;
	
	@RequestMapping("myAmor/userPwdCheckForm.do")
	public String userPwdCheckForm() {
		return "/user/myAmor/userPwdCheck";
	}
	
	@RequestMapping(value="myAmor/userPwdCheckSubmit.do", method = RequestMethod.POST)
	public ModelAndView userPwdCheckSubmit(
			@RequestParam(value="pwd", defaultValue = "notpwd") String pwd2,
			HttpSession session) {
		
		String pwd = Encryption.pwdEncrypt(pwd2);
		String sid=(String)session.getAttribute("sid");
		ModelAndView mav=new ModelAndView();
		String msg;
		if(pwd.equals("notpwd") || pwd.equals("")) {
			msg="비밀번호를 입력해주세요.";
			mav.addObject("msg", msg);
			mav.addObject("goUrl", "userPwdCheckForm.do");
			mav.setViewName("/user/msg/userMsg");
			return mav;
		}
		
		int result=memberService.memberPwdCheck(sid, pwd);
		
		if(result==memberService.SUCCES) {
			msg="비밀번호 확인 성공 (바로 수정 폼으로)";
			mav.addObject("msg", msg);
			mav.addObject("goUrl", "userPwdUpdateForm.do");
			mav.setViewName("/user/msg/userMsg");
		}else {
			msg="비밀번호가 맞지 않습니다.";
			mav.addObject("msg", msg);
			mav.addObject("goUrl", "userPwdCheckForm.do");
			mav.setViewName("/user/msg/userMsg");
		}		
		return mav;
	}
	
	@RequestMapping("myAmor/userPwdUpdateForm.do")
	public String userPwdUpdateForm() {
		return "/user/myAmor/userPwdUpdate";
	}
	
	@RequestMapping(value="myAmor/userPwdUpdateSubmit.do",method = RequestMethod.POST)
	public ModelAndView userPwdUpdateSubmit(
			@RequestParam("pwd")String pwd2,
			HttpSession session) {
		String pwd = Encryption.pwdEncrypt(pwd2);
		String sid=(String)session.getAttribute("sid");
		int result=memberService.memberPwdUpdate(sid, pwd);
		String msg=result>0?"비번 업데이트 성공":"비번 업데이트 실패";

		ModelAndView mav=new ModelAndView();
		mav.addObject("msg", msg);
		mav.addObject("goUrl", "userPwdUpdateForm.do");
		mav.setViewName("/user/msg/userMsg");
		return mav;
	}

}
