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
	public ModelAndView userFaqList(
			HttpSession session) {

		ModelAndView mav=new ModelAndView();
		List<FaqDTO>lists=faqService.userFaqList();
		mav.addObject("lists", lists);
		mav.setViewName("/user/customer/faqList");
		return mav;
	}
	
}
