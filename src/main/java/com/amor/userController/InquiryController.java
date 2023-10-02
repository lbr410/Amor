package com.amor.userController;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.style.DefaultValueStyler;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.amor.inquiry.model.InquiryDTO;
import com.amor.inquiry.service.InquiryService;
import com.amor.notice.model.NoticeDTO;

@Controller
public class InquiryController {
	
	@Autowired
	private InquiryService inquiryService;
	
	//사용자 1:1문의 리스트
	@RequestMapping("myAmor/memberInquiryList.do")
	public ModelAndView inquiryList(
			HttpSession session,
			@RequestParam(value="cp", defaultValue="1")int cp) {
		int totalCnt=inquiryService.inquiryTotalCnt();
		int listSize=5;
		int pageSize=5;
		String pageStr=com.amor.page.PageModule.makePage("/amor/user/myAmor/memberInquiryList.do", totalCnt, listSize, pageSize, cp);
		
		ModelAndView mav=new ModelAndView();
		
			List<InquiryDTO>lists=inquiryService.memberInquiryList(cp, listSize);
			mav.addObject("lists", lists);
			mav.addObject("pageStr", pageStr);
			mav.setViewName("/user/myAmor/inquiryList");

		return mav;
	}
	//사용자 1:1문의 작성 폼으로 이동
	@RequestMapping("myAmor/inquiryWrite.do")
	public String inquiryWriteForm() {
		return "/user/myAmor/inquiryWrite";
	}
	//사용자 1:1문의 작성
	@RequestMapping(value="myAmor/inquiryWrite.do", method = RequestMethod.POST)
	public ModelAndView inquiryWrite(
			@RequestParam("inquiry_subject")String inquiry_subject,
			@RequestParam("inquiry_content")String inquiry_content,
			@RequestParam(value="inquiry_filename", defaultValue = "")String inquiry_filename) {
		InquiryDTO dto=new InquiryDTO(0, inquiry_subject, inquiry_content, inquiry_filename, null, inquiry_content, inquiry_filename);
		int result=inquiryService.inquiryWrite(dto);
		String msg=result>0?"문의가 등록되었습니다.":"문의 등록 실패했습니다.";
		
		ModelAndView mav=new ModelAndView();
		mav.addObject("msg", msg);
		mav.addObject("href","user/myAmor/inquiryWrite.do"); 
		mav.setViewName("/user/msg/userMsg");
		return mav;
	}
	
}
