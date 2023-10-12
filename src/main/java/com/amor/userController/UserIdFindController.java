package com.amor.userController;

import java.util.HashMap;
import java.util.List;
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
	
	@RequestMapping("member/userIdFindForm.do")
	public String userIdFindForm() {
		return "/user/member/userIdFind";
	}

	@RequestMapping(value = "member/userIdFindSubmit.do", method = RequestMethod.POST)
	public ModelAndView userIdFindSubmit(
			@RequestParam("member_name")String member_name,
			@RequestParam("member_email")String member_email) {
		
		List<MemberDTO> member_id=memberService.userIdFind(member_name, member_email);
		ModelAndView mav=new ModelAndView();
		if(member_id == null) {
			mav.addObject("msg", "일치하는 회원정보를 찾을 수 없습니다..");
			mav.addObject("goUrl","/amor/member/userIdFindForm.do");
			mav.setViewName("/user/msg/userMsg");
			return mav;
		}
		mav.addObject("member_id", member_id);
		mav.setViewName("/user/member/userIdFindResult");
		return mav;
	}

	@RequestMapping("member/userPwdFindForm.do")
	public String userPwdFindForm() {
		return "/user/member/userPwdFind";
	}
	
	@RequestMapping(value = "member/userPwdFind.do", method = RequestMethod.POST)
	public ModelAndView userPwdSubmit(
			@RequestParam(value="member_id", defaultValue = "noid")String member_id,
			HttpSession session) {
		
		String fid = memberService.userPwdIdck(member_id);
	    ModelAndView mav = new ModelAndView();

	    if (fid == null) {
	    	  mav.addObject("msg", "일치하는 아이디가 없습니다.");
		      mav.addObject("goUrl","/amor/member/userPwdFindForm.do");
		      mav.setViewName("/user/msg/userMsg");
		        return mav;
	    } else {
	        session.setAttribute("id", fid);
	        mav.addObject("member_id", fid);
		    mav.setViewName("/user/member/userPwdFindAuth");
	        return mav;
	    }
	   
	}
	
	@RequestMapping("member/userPwdFindAuth.do")
	public String userPwdFindAuth() {
		return "/user/member/userPwdFindAuth";
	}
	
	@RequestMapping(value="member/emailSameChk.do", method=RequestMethod.POST)
	public ModelAndView userEmailCheck(
			HttpSession session,
			@RequestParam("email")String email,
			@RequestParam("member_id")String id) {
		
		ModelAndView mav=new ModelAndView();
		
		String getEmail=memberService.userEmailCheck(id);
		if(email.equals(getEmail)) {
			mav.addObject("msg", "");
			mav.addObject("Url","/amor/member/sendMail.do");
			mav.addObject("email", "email="+email);
			mav.setViewName("amorJson");
		} else if(!email.equals(getEmail)) {
			mav.addObject("msg", "아이디와 이메일이 일치하지 않습니다.");
			mav.setViewName("amorJson");
			//mav.setViewName("/user/member/userPwdFindAuth");
		}
		return mav;
	}

	@RequestMapping("member/userPwdFindUpdate.do")
	public String userPwdFindUpdateForm() {
		return "/user/member/userPwdFindUpdate";
	}

	@RequestMapping(value="member/userPwdFindUpdateSubmit.do", method = RequestMethod.POST)
	public ModelAndView userPwdFindUpdateSubmit(
		@RequestParam("member_pwd")String member_pwd,
		HttpSession session) {
		
		String fid=(String)session.getAttribute("id");
		String npwd = Encryption.pwdEncrypt(member_pwd);

		int result=memberService.userPwdFindUpdate(fid, npwd);
		String msg=result>0?"비밀번호 업데이트 성공":"비밀번호 업데이트 실패";

		ModelAndView mav=new ModelAndView();
		mav.addObject("msg", msg);
		mav.addObject("goUrl","/amor/member/login.do");
		mav.setViewName("/user/msg/userMsg");
		return mav;
	}

}
