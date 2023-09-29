package com.amor.adminController;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.amor.notice.service.NoticeService;
import com.amor.notice.model.*;

@Controller
public class NoticeController {

	@Autowired
	private NoticeService noticeService;
	
	@RequestMapping("admin/notice/noticeList.do")
	public ModelAndView noticeListForm(
			HttpSession session,
			@RequestParam(value="cp", defaultValue = "1")int cp) {
		int totalCnt=noticeService.noticeTotalCnt();
		int listSize=5;
		int pageSize=5;
		String pageStr=com.amor.page.PageModule.makePage("/amor/admin/notice/noticeList.do", totalCnt, listSize, pageSize, cp);
		
		
		ModelAndView mav=new ModelAndView();
		if(session.getAttribute("data")==null) {
			mav.addObject("msg", "로그인 후 이용가능합니다.");
			mav.addObject("href", "/amor/admin/adminLogin.do");
			mav.setViewName("/admin/msg/adminMsg");
		}else {
			List<NoticeDTO>lists=noticeService.noticeList(cp, listSize);
			mav.addObject("lists", lists);
			mav.addObject("pageStr", pageStr);
			mav.setViewName("/admin/notice/noticeList");
		}
		
		return mav;
	}
	
	@RequestMapping("admin/notice/noticeWrite.do")
	public String noticeWriteForm() {
		return "/admin/notice/noticeWrite";
	}
	
	@RequestMapping(value="admin/notice/noticeWriteAdd.do", method = RequestMethod.POST)
	public ModelAndView noticeAdd(
			@RequestParam("notice_subject")String subject,
			@RequestParam("notice_content")String content) {
		NoticeDTO dto=new NoticeDTO(0, subject, content, null, 0);
		int result=noticeService.noticeAdd(dto);
		String msg=result>0?"공지상항 등록이 완료되었습니다.":"공지사항 등록이 실패했습니다.";
		
		ModelAndView mav=new ModelAndView();
		mav.addObject("msg", msg);
		mav.addObject("href", "/amor/admin/notice/noticeList.do");
		mav.setViewName("/admin/msg/adminMsg");
		return mav;
	}
	
	@RequestMapping("admin/notice/noticeContent.do")
	public ModelAndView noticeContent(
			@RequestParam(value="notice_idx", defaultValue = "0")int idx) {
		
		NoticeDTO dto=noticeService.noticeContnet(idx);
		ModelAndView mav=new ModelAndView();
		
		if(dto==null) {
			mav.addObject("msg", "잘못된 접근입니다.");
			mav.addObject("href", "/amor/admin/notice/noticeList.do");
			mav.setViewName("/admin/msg/adminMsg");
		}else {
			mav.addObject("dto", dto);
			mav.setViewName("/admin/notice/noticeContent");
		}

		return mav;
	}
	
	
	@RequestMapping("admin/notice/noticeUpdateForm.do")
	public ModelAndView noticeUpdateForm(
			@RequestParam("idx")int idx) {
		
		NoticeDTO dto=noticeService.noticeUpdateForm(idx);
		ModelAndView mav=new ModelAndView();
		mav.addObject("dto", dto);
		mav.setViewName("/admin/notice/noticeUpdate");
		return mav;
	}
	
	@RequestMapping("admin/notice/noticeUpdate.do")
	public ModelAndView noticeUpdate(
			@RequestParam("idx")int idx,
			@RequestParam("notice_subject")String subject,
			@RequestParam("notice_content")String content) {
		NoticeDTO dto=new NoticeDTO(idx, subject, content, null, 0);
		int result=noticeService.noticeUpdate(dto);
		String msg=result>0?"수정 완료되었습니다.":"수정 실패하였습니다.";

		ModelAndView mav=new ModelAndView();
		mav.addObject("msg", msg);
		mav.addObject("href","/amor/admin/notice/noticeList.do");
		mav.setViewName("/admin/msg/adminMsg");
		return mav;
	}
	
	@RequestMapping("admin/notice/noticeDelete.do")
	public ModelAndView noticeDelete(
			@RequestParam("idx")int idx) {
		int result=noticeService.noticeDelete(idx);

		String msg=result>0?"삭제 완료되었습니다.":"삭제 실패하였습니다.";
		ModelAndView mav=new ModelAndView();
		mav.addObject("msg", msg);
		mav.addObject("href","/amor/admin/notice/noticeList.do");
		mav.setViewName("/admin/msg/adminMsg");
		return mav;
	}
}
