package com.amor.userController;

import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.stereotype.Service;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.amor.encryption.Encryption;
import com.amor.member.model.MemberDTO;
import com.amor.member.service.MemberService;

@Service
@Controller
public class UserIdFindController {
	private SqlSessionTemplate sqlmap;

	@Autowired
	private MemberService memberService;
	
	//아이디 찾기 폼으로 이동
	@RequestMapping("member/userIdFindForm.do")
	public String userIdFindForm() {
		return "/user/member/userIdFind";
	}
	//아이디 찾기
	@RequestMapping(value = "member/userIdFindSubmit.do", method = RequestMethod.POST)
	public ModelAndView userIdFindSubmit(
			@RequestParam("member_name")String member_name,
			@RequestParam("member_email")String member_email) {
		//System.out.println("name+"+member_name);
		//System.out.println("email+"+member_email);
		String member_id=memberService.userIdFind(member_name, member_email);
		ModelAndView mav=new ModelAndView();
		if(member_id == null) {
			mav.addObject("msg", "아이디와 이메일을 입력해주세요.");
			mav.addObject("goUrl","/amor/member/userIdFindForm.do");
			mav.setViewName("/user/msg/userMsg");
			return mav;
		}
		mav.addObject("member_id", member_id);
		mav.setViewName("/user/member/userIdFindResult");
		return mav;
	}

	//비밀번호 찾기 폼으로 이동
	@RequestMapping("member/userPwdFindForm.do")
	public String userPwdFindForm() {
		return "/user/member/userPwdFind";
	}
	
	//비밀번호 아이디 입력하고 체크
	@RequestMapping(value = "member/userPwdFind.do", method = RequestMethod.POST)
	public ModelAndView userPwdSubmit(
			@RequestParam(value="member_id", defaultValue = "noid")String member_id,
			HttpSession session) {
		
		String id = memberService.userPwdIdck(member_id);

	    ModelAndView mav = new ModelAndView();

	    if (id == null) {
	    	  mav.addObject("msg", "일치하는 아이디가 없습니다.");
		      mav.addObject("goUrl","/amor/member/userPwdFindForm.do");
		      mav.setViewName("/user/msg/userMsg");
		        return mav;
	    } else {
	        // 아이디가 일치하는 경우 세션에 아이디를 저장
			System.out.println("member_id+"+member_id+id);
	        session.setAttribute("sId", id);
	        mav.addObject("member_id", id);
		    mav.setViewName("/user/member/userPwdFindAuth");
	        return mav;
	    }
	   
	}
	
	//이메일 인증 폼으로 이동
	@RequestMapping("member/userPwdFindAuth.do")
	public String userPwdFindAuth() {
		return "/user/member/userPwdFindAuth";
	}
	
	//비밀번호 업데이트 폼으로 이동
	@RequestMapping("member/userPwdFindUpdate.do")
	public String userPwdFindUpdateForm() {
		return "/user/member/userPwdFindUpdate";
	}
	
	//비밀번호 업데이트
	@RequestMapping("member/userPwdFindUpdateSubmit.do")
	public ModelAndView userPwdFindUpdateSubmit(
		@RequestParam("member_pwd")String member_pwd,
		HttpSession session) {
	String npwd = Encryption.pwdEncrypt(member_pwd);
	String sid=(String)session.getAttribute("sid");
	int result=memberService.userPwdFindUpdate(sid, npwd);
	String msg=result>0?"비밀번호 업데이트 성공":"비밀번호 업데이트 실패";

	ModelAndView mav=new ModelAndView();
	mav.addObject("msg", msg);
	mav.addObject("goUrl", "login.do");
	mav.setViewName("/user/msg/userMsg");
	return mav;
	}

}
