package com.amor.adminController;

import java.util.*;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.amor.inquiry.model.InquiryDTO;
import com.amor.inquiry.service.InquiryService;

@Controller
public class InquiryListController {

	@Autowired
	private InquiryService inquiryService;
	
	@RequestMapping("admin/inquiry/inquiryList.do")
	public ModelAndView inquiryListForm(
			HttpSession session,
			@RequestParam(value="cp", defaultValue = "1")int cp) {
		int totalCnt=inquiryService.inquiryTotalCnt();
		int listSize=5;
		int pageSize=5;
		String pageStr=com.amor.page.PageModule.makePage("/amor/admin/inquiry/inquiryList.do", totalCnt, listSize, pageSize, cp);
	
		ModelAndView mav=new ModelAndView();
//		if(session.getAttribute("date")==null) {
//			mav.addObject("msg", "로그인 후 이용가능합니다.");
//			mav.addObject("href", "/amor/admin/adminLogin.do");
//			mav.setViewName("/admin/msg/adminMsg");
//		}else {
			List<InquiryDTO> lists=inquiryService.inquiryList(cp, listSize);
			mav.addObject("pageStr", pageStr);
			mav.addObject("lists", lists);
			mav.setViewName("/admin/inquiry/inquiryList");
//		}
		return mav;
	}
	
	@RequestMapping(value="admin/inquiry/inquiryWrite.do",method = RequestMethod.GET)
	public String inquiryAnswerForm() {
		return "/admin/inquiry/inquiryWrite";
	}
	
	@RequestMapping(value="admin/inquiry/inquiryWrite.do",method = RequestMethod.POST)
	public ModelAndView inquiryAnswerAdd(InquiryDTO dto) {
		
		int result=inquiryService.inquiryAnswer(dto);
		String msg=result>0?"답변이 등록되었습니다.":"답변 등록이 실패했습니다.";
		ModelAndView mav=new ModelAndView();
		mav.addObject("msg", msg);
		mav.addObject("href", "/amor/admin/inquiry/inquiryList.do");
		mav.setViewName("/admin/msg/adminMsg");
		return mav;
	}
	
	@RequestMapping(value="admin/inquiry/inquiryDelete.do")
	public ModelAndView inquiryDelete(
			@RequestParam(value="inquiry_idx", defaultValue = "0")int inquiry_idx) {
		int result=inquiryService.inquiryDelete(inquiry_idx);
		String msg=result>0?"삭제 완료되었습니다.":"삭제 실패하였습니다.";
		ModelAndView mav=new ModelAndView();
		mav.addObject("msg", msg);
		mav.addObject("href", "/amor/admin/inquiry/inquiryList.do");
		mav.setViewName("/admin/msg/adminMsg");
		return mav;
	}
	
}
