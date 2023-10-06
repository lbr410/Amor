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
import com.amor.inquiry.model.InquiryJoinDTO;
import com.amor.inquiry.service.InquiryService;

@Controller
public class InquiryListController {

	@Autowired
	private InquiryService inquiryService;
	
	//관리자 1:1문의 리스트 폼
	@RequestMapping("admin/inquiry/inquiryList.do")
	public ModelAndView adminInquiryListForm(
			HttpSession session,
			@RequestParam(value="cp", defaultValue = "1")int cp) {

		int totalCnt=inquiryService.inquiryTotalCnt();
		int listSize=10;
		int pageSize=5;
		String pageStr=com.amor.page.PageModule.makePage("/amor/admin/inquiry/inquiryList.do", totalCnt, listSize, pageSize, cp);
	
		ModelAndView mav=new ModelAndView();
		if(session.getAttribute("data")==null) {
			mav.addObject("msg", "로그인 후 이용가능합니다.");
			mav.addObject("href", "/amor/admin/adminLogin.do");
			mav.setViewName("/admin/msg/adminMsg");
		}else {
			List<InquiryJoinDTO> lists=inquiryService.adminInquiryList(cp, listSize);
			mav.addObject("pageStr", pageStr);
			mav.addObject("lists", lists);
			mav.setViewName("/admin/inquiry/inquiryList");
		}
		return mav;
	}
	//사용자 block
	public ModelAndView inquiryBlock(
			@RequestParam(value="inquiry_idx", defaultValue = "0")int inquiry_idx,
			@RequestParam("value")String value) {
		ModelAndView mav=new ModelAndView();
		InquiryJoinDTO dto=new InquiryJoinDTO();
		int result=inquiryService.inquiryBlock(inquiry_idx, value);
		
		if(value.equals("y")) {
			dto.setMember_block("y");
		}else if(value.equals("n")) {
			dto.setMember_block("n");
		}
		return mav;
		
	}
	//관리자 1:1문의 내용으로 이동
	@RequestMapping("admin/inquiry/inquiryContent.do")
	public ModelAndView inquiriyContentForm(
			@RequestParam(value="idx", defaultValue = "0")int idx) {
		
		InquiryJoinDTO dto=inquiryService.inquiryContent(idx);
		ModelAndView mav=new ModelAndView();
			mav.addObject("dto", dto);
			mav.setViewName("/admin/inquiry/inquiryContent");

		return mav;
	}
	//관리자 답변 등록
	@RequestMapping(value="admin/inquiry/inquiryContent.do", method = RequestMethod.POST)
	public ModelAndView inquiryAnswer(
			@RequestParam("inquiry_answer") String inquiry_answer, @RequestParam("inquiry_idx") int inquiry_idx) {
		
		InquiryJoinDTO dto=new InquiryJoinDTO();
		dto.setInquiry_answer(inquiry_answer);
		dto.setInquiry_idx(inquiry_idx);
		int result=inquiryService.inquiryAnswer(dto);
		String msg=result>0?"문의에 대한 답변이 등록되었습니다.":"문의에 대한 답변이 등록되지 않았습니다.";
		ModelAndView mav=new ModelAndView();
		
		mav.addObject("msg", msg);
		mav.addObject("href", "/amor/admin/inquiry/inquiryList.do");
		mav.setViewName("/admin/msg/adminMsg");
		return mav;
	}
}
