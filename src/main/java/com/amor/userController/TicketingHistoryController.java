package com.amor.userController;


import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.amor.ticketing.model.JoinTicketingHistoryDTO;
import com.amor.ticketing.service.TicketingService;
import java.util.*;
@Controller
public class TicketingHistoryController {

	@Autowired
	private TicketingService ticketingHistoryService;
	
	@RequestMapping("/myAmor/ticketingHistory.do")
	public ModelAndView goTiketingHistory(HttpSession session) {
		String id = (String)session.getAttribute("sid");
		System.out.println(id);
		ModelAndView mav = new ModelAndView();
		if(id != null) {			
			int useridx = (int)session.getAttribute("sidx");
			System.out.println(useridx);
			List<JoinTicketingHistoryDTO>lists = ticketingHistoryService.getReserveList(useridx);
			if(lists != null) {				
				System.out.println(lists.get(0));
				mav.addObject("list", lists);
				mav.setViewName("user/myAmor/tiketingHistory");
				return mav;
			}else {
				mav.addObject("lists", null);
				mav.setViewName("user/myAmor/tiketingHistory");
				return mav;
			}
		}else {
			mav.addObject("msg", "로그인 후 이용가능합니다.");
			mav.addObject("href", "/amor/member/login.do");
			mav.setViewName("user/msg/userMsg");
			return mav;
		}
	}
	
	@RequestMapping("/myAmor/cancellHistory.do")
	public ModelAndView cancellHistory(HttpSession session) {
		ModelAndView mav = new ModelAndView();
		if(session.getAttribute("sidx") != null) {
			int useridx = (int)session.getAttribute("sidx");
			List<JoinTicketingHistoryDTO>lists = ticketingHistoryService.getcancellList(useridx);
			if(lists != null) {				
				System.out.println(lists.get(0));
				mav.addObject("list", lists);
				mav.setViewName("user/myAmor/tiketingCancellHistory");
				return mav;
			}else {
				mav.addObject("lists", null);
				mav.setViewName("user/myAmor/tiketingCancellHistory");
				return mav;
			}
		}else {
			mav.addObject("msg", "로그인 후 이용가능합니다.");
			mav.addObject("href", "/amor/member/login.do");
			mav.setViewName("user/msg/userMsg");
			return mav;
		}
	}
	
	
	@RequestMapping("/myAmor/cancellation.do")
	public ModelAndView cancellationTicket(@RequestParam("ticketnum")String ticketnum) {
		int result = ticketingHistoryService.cancellationTicket(ticketnum);
		ModelAndView mav = new ModelAndView();
		if(result > 0) {
			mav.addObject("msg", "예매가 취소되었습니다.");
			mav.addObject("href", "/amor/myAmor/ticketingHistory.do");
			mav.setViewName("user/msg/userMsg");
			return mav;
		}else {
			mav.addObject("msg", "예매취소 불가(관리자 문의 바랍니다.)");
			mav.addObject("href", "/amor/myAmor/ticketingHistory.do");
			mav.setViewName("user/msg/userMsg");
			return mav;
		}
	}
//	@RequestMapping("/myAmor/ticketingHistory.do")
//	public ModelAndView goTiketingHistory(HttpSession session) {
//		String id = (String)session.getAttribute("sid");
//		System.out.println(id);
//		ModelAndView mav = new ModelAndView();
//		if(id != null) {			
//			int useridx = (int)session.getAttribute("sidx");
//			System.out.println(useridx);
//			List<Map<String, Object>> lists = ticketingHistoryService.getReserveList(useridx);
//			System.out.println(lists.get(0).get("price"));
//			mav.addObject("list", lists);
//			mav.setViewName("user/myAmor/tiketingHistory");
//			return mav;
//		}else {
//			mav.setViewName("user/member/login");
//			return mav;
//		}
//	}
	
}
