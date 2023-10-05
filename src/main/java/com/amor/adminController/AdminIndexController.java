package com.amor.adminController;

import java.util.*;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.amor.dual.model.DualDTO;
import com.amor.dual.service.DualService;
import com.amor.inquiry.model.InquiryDTO;
import com.amor.inquiry.service.InquiryService;

@Controller
public class AdminIndexController {
	
	@Autowired
	private DualService dualService;
	
	@Autowired
	private InquiryService inquiryService;
	
	@RequestMapping("/admin/adminIndex.do")
	public ModelAndView adminIndex(HttpSession session) {
		List<DualDTO> chartData = dualService.chartData();
		List<DualDTO> tableData = dualService.threeTableResult(); // 3개의 테이블(member, movie, notice)의 결과
		List<DualDTO> memberResult = new ArrayList<DualDTO>();
		List<DualDTO> movieResult = new ArrayList<DualDTO>();
		List<DualDTO> noticeResult = new ArrayList<DualDTO>();
		for(int i=0; i<tableData.size(); i++) {
			if(tableData.get(i).getOrders() == 0) {
				memberResult.add(tableData.get(i));
			} else if(tableData.get(i).getOrders() == 1) {
				movieResult.add(tableData.get(i));
			} else if(tableData.get(i).getOrders() == 2) {
				noticeResult.add(tableData.get(i));
			}
		}
		List<InquiryDTO> inquiryResult = inquiryService.adminMainInquiryList(); 
		
		ModelAndView mav = new ModelAndView();
		if(session.getAttribute("data") == null) {
			mav.addObject("msg", "로그인 후 이용 가능합니다.");
			mav.addObject("href", "/amor/admin/adminLogin.do");
			mav.setViewName("/admin/msg/adminMsg");
		} else {
			mav.addObject("chartData", chartData);
			mav.addObject("memberResult", memberResult);
			mav.addObject("movieResult", movieResult);
			mav.addObject("noticeResult", noticeResult);
			mav.addObject("inquiryResult", inquiryResult);
			mav.setViewName("admin/adminIndex");
		}
		return mav;
	}
}