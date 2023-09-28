package com.amor.adminController;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.amor.member.service.MemberService;
import java.util.*;
import com.amor.member.model.*;

@Controller
public class MemberListController {
	
	@Autowired
	private MemberService memberService;
	
	@RequestMapping("admin/member/memberList.do")
	public ModelAndView memberListForm(
			HttpSession session,
			@RequestParam(value="cp", defaultValue = "1")int cp) {
		int totalCnt=memberService.memberTotalCnt();
		int listSize=5;
		int pageSize=5;
		
		String pageStr=com.amor.page.PageModule.makePage("/amor/admin/member/memberList.do", totalCnt, listSize, pageSize, cp);
		
		ModelAndView mav=new ModelAndView();
		if(session.getAttribute("data") ==null) {
			mav.addObject("msg", "로그인 후 이용가능합니다.");
			mav.addObject("href", "/amor/admin/adminLogin.do");
			mav.setViewName("/admin/msg/adminMsg");
		}else {
			List<MemberDTO> lists=memberService.memberList(cp,listSize);
			mav.addObject("pageStr", pageStr);
			mav.addObject("lists", lists);
			mav.setViewName("/admin/member/memberList");
		}
		return mav;
	}
	
	@RequestMapping("admin/member/memberSearch.do")
	public ModelAndView memberSearch(
			@RequestParam(value="cp",defaultValue = "1")int cp,
			@RequestParam("search")String search) {
		int totalCnt = memberService.memberSearchTotalCnt(search);
		int listSize = 5;
		int pageSize = 5;
		String pageStr=com.amor.page.PageModule.makePage("/amor/admin/member/memberList.do", totalCnt, listSize, pageSize, cp);
		
		List<MemberDTO> lists=memberService.memberSearch(cp, listSize, search);
		ModelAndView mav=new ModelAndView();
		mav.addObject("pageStr", pageStr);
		mav.addObject("lists", lists);
		mav.setViewName("admin/member/memberList");
		return mav;
	}

}
