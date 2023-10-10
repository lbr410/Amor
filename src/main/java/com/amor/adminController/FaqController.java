package com.amor.adminController;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CookieValue;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.amor.faq.service.FaqService;
import com.amor.faq.model.*;
import java.util.*;

@Controller
public class FaqController {

	@Autowired
	private FaqService faqService;
	
	@RequestMapping("admin/faq/faqList.do")
	public ModelAndView faqListForm(
			HttpSession session,
			@RequestParam(value="cp", defaultValue = "1")int cp,
			@CookieValue(value = "autologin", required = false)String autologin) {
		int totalCnt=faqService.faqTotalCnt();
		int listSize=10;
		int pageSize=5;
		String pageStr=com.amor.page.PageModule.makePage("/amor/admin/faq/faqList.do", totalCnt, listSize, pageSize, cp);
				
		ModelAndView mav=new ModelAndView();
		if(autologin == null && session.getAttribute("data") == null) {
			mav.addObject("msg", "로그인 후 이용가능힙니다.");
			mav.addObject("href", "/amor/admin/adminLogin.do");
			mav.setViewName("/admin/msg/adminMsg");
		}else{
			List<FaqDTO> lists=faqService.faqList(cp, listSize);
			mav.addObject("pageStr", pageStr);
			mav.addObject("lists", lists);                 
			mav.setViewName("/admin/faq/faqList");
		}
		return mav;
	}
	
	@RequestMapping(value="admin/faq/faqWrite.do",method = RequestMethod.GET)
	public ModelAndView faqWriteForm(
			@CookieValue(value = "autologin", required = false)String autologin,
			HttpSession session) {
		ModelAndView mav=new ModelAndView();
		if(autologin == null && session.getAttribute("data") == null) {
			mav.addObject("msg", "로그인 후 이용가능힙니다.");
			mav.addObject("href", "/amor/admin/adminLogin.do");
			mav.setViewName("/admin/msg/adminMsg");
		}else{
			mav.setViewName("/admin/faq/faqWrite");
		}
		return mav;
	}
	
	@RequestMapping(value="admin/faq/faqWrite.do",method = RequestMethod.POST)
	public ModelAndView faqWriteAdd(FaqDTO dto) {
		
		int result=faqService.faqWriteAdd(dto);
		String msg=result>0?"FAQ 등록이 완료되었습니다.":"FAQ 등록이 실패하였습니다.";
		
		ModelAndView mav=new ModelAndView();
		mav.addObject("msg", msg);
		mav.addObject("href", "/amor/admin/faq/faqList.do");
		mav.setViewName("/admin/msg/adminMsg");
		return mav;
	}
	
	@RequestMapping("admin/faq/faqContent.do")
	public ModelAndView faqContent(
			@RequestParam(value="faq_idx",defaultValue = "0")int idx,
			@CookieValue(value = "autologin", required = false)String autologin,
			HttpSession session) {
		
		FaqDTO dto=faqService.faqContent(idx);
		ModelAndView mav=new ModelAndView();
		if(autologin == null && session.getAttribute("data") == null) {
			mav.addObject("msg", "로그인 후 이용가능힙니다.");
			mav.addObject("href", "/amor/admin/adminLogin.do");
			mav.setViewName("/admin/msg/adminMsg");
		}else {
			if(dto==null) {
				mav.addObject("msg", "잘못된 접근입니다.");
				mav.addObject("href", "/amor/admin/faq/faqList.do");
				mav.setViewName("/admin/msg/adminMsg");
			}else {
				mav.addObject("dto", dto);
				mav.setViewName("/admin/faq/faqContent");
			}
		}	
		return mav;
	}
	
	@RequestMapping("admin/faq/faqUpdateForm.do")
	public ModelAndView faqUpdateForm(
			@RequestParam(value="idx",defaultValue = "0")int idx,
			@CookieValue(value = "autologin", required = false)String autologin,
			HttpSession session) {
		
		FaqDTO dto=faqService.faqUpdateForm(idx);
		ModelAndView mav=new ModelAndView();
		if(autologin == null && session.getAttribute("data") == null) {
			mav.addObject("msg", "로그인 후 이용가능힙니다.");
			mav.addObject("href", "/amor/admin/adminLogin.do");
			mav.setViewName("/admin/msg/adminMsg");
		}else {
			if(dto==null) {
				mav.addObject("msg", "잘못된 접근입니다.");
				mav.addObject("href", "/amor/admin/faq/faqList.do");
				mav.setViewName("/admin/msg/adminMsg");
			}else {			
				mav.addObject("dto", dto);
				mav.setViewName("/admin/faq/faqUpdate");
			}
		}
		return mav;
	}
	
	@RequestMapping("admin/faq/faqUpdate.do")
	public ModelAndView faqUpdate(FaqDTO dto) {
		
		int result=faqService.faqUpdate(dto);
		String msg=result>0?"수정 완료되었습니다.":"수정 실패하였습니다.";
		ModelAndView mav=new ModelAndView();
		mav.addObject("msg", msg);
		mav.addObject("href", "/amor/admin/faq/faqList.do");
		mav.setViewName("/admin/msg/adminMsg");
		return mav;
	}
	
	@RequestMapping("admin/faq/faqDelete.do")
	public ModelAndView faqDelete(
			@RequestParam(value="idx",defaultValue = "0")int idx) {
		int result=faqService.faqDelete(idx);
		String msg=result>0?"삭제 완료되었습니다.":"삭제 실패하였습니다.";
		ModelAndView mav=new ModelAndView();
		mav.addObject("msg", msg);
		mav.addObject("href", "/amor/admin/faq/faqList.do");
		mav.setViewName("/admin/msg/adminMsg");
		return mav;
	}
	
}
