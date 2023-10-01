package com.amor.userController;

import java.util.*;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.amor.faq.model.FaqDTO;
import com.amor.faq.service.FaqService;

@Controller
public class FaqListController {

	@Autowired
	private FaqService faqService;
	
	@RequestMapping("customer/faqList.do")
	public ModelAndView faqList(
			HttpSession session,
			@RequestParam(value="cp", defaultValue="1")int cp) {
		int totalCnt=faqService.faqTotalCnt();
		int listSize=5;
		int pageSize=5;
		String pageStr=com.amor.page.PageModule.makePage("/amor/user/customer/faqList.do", totalCnt, listSize, pageSize, cp);
		
		ModelAndView mav=new ModelAndView();
		List<FaqDTO>lists=faqService.faqList(cp,listSize);
		mav.addObject("lists", lists);
		mav.addObject("pageStr", pageStr);
		mav.setViewName("/user/customer/faqList");
		return mav;
	}
	
	@RequestMapping("customer/faqContent.do")
	public ModelAndView faqContent(
		@RequestParam(value="faq_idx", defaultValue = "0")int faq_idx) {
		
		FaqDTO dto=faqService.faqContent(faq_idx);
		ModelAndView mav=new ModelAndView();
		mav.addObject("dto", dto);
		mav.setViewName("/user/customer/faqContent");
		
		return mav;
	}
}
