package com.amor.userController;

import java.util.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.amor.notice.model.NoticeDTO;
import com.amor.notice.service.NoticeService;

@Controller
public class UserNoticeController {

	@Autowired
	private NoticeService noticeService;
	
	@RequestMapping("customer/noticeList.do")
	public ModelAndView noticeList(
			@RequestParam(value="cp", defaultValue = "1")int cp) {
		int totalCnt=noticeService.noticeTotalCnt();
		int listSize=10;
		int pageSize=5;
		String pageStr=com.amor.page.PageModule.makePage("/amor/customer/noticeList.do", totalCnt, listSize, pageSize, cp);
		
		ModelAndView mav=new ModelAndView();
		List<NoticeDTO>lists=noticeService.noticeList(cp,listSize);
		mav.addObject("lists", lists);
		mav.addObject("pageStr", pageStr);
		mav.setViewName("/user/customer/noticeList");
		return mav;
	}
	
	@RequestMapping("customer/noticeContent.do")
	public ModelAndView noticeContent(
		@RequestParam(value="notice_idx", defaultValue = "0")int notice_idx) {
		
		NoticeDTO dto=noticeService.noticeContnet(notice_idx);
		ModelAndView mav=new ModelAndView();
		int readNum=noticeService.noticeReadNumUpdate(notice_idx);
		mav.addObject("dto", dto);
		mav.addObject("notice_read", readNum);
		mav.setViewName("/user/customer/noticeContent");
		return mav;
	}
	
}
