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
	private TicketingService ticketingService;
	
	@RequestMapping("/myAmor/ticketingHistory.do")
	public ModelAndView goTiketingHistory(HttpSession session) {
		String id = (String)session.getAttribute("sid");
		System.out.println(id);
		ModelAndView mav = new ModelAndView();
		if(id != null) {			
			int useridx = (int)session.getAttribute("sidx");
			System.out.println(useridx);
			List<JoinTicketingHistoryDTO>lists = ticketingService.getReserveList(useridx);
			if(lists != null) {		
				System.out.println("aaaa="+lists.size());
				for(int i=0;i<lists.size();i++) {
				System.out.println("test="+lists.get(i).getMoviename()+"/"+lists.get(i).getScreeningdate()+"/"+lists.get(i).getTimelimit());
				}
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
			mav.addObject("goUrl", "/amor/member/login.do");
			mav.setViewName("user/msg/userMsg");
			return mav;
		}
	}
	
	@RequestMapping("/myAmor/cancellHistory.do")
	public ModelAndView cancellHistory(HttpSession session) {
		ModelAndView mav = new ModelAndView();
		if(session.getAttribute("sidx") != null) {
			int useridx = (int)session.getAttribute("sidx");
			List<JoinTicketingHistoryDTO>lists = ticketingService.getcancellList(useridx);
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
			mav.addObject("goUrl", "/amor/member/login.do");
			mav.setViewName("user/msg/userMsg");
			return mav;
		}
	}
	
	
	@RequestMapping("/myAmor/cancellation.do")
	public ModelAndView cancellationTicket(@RequestParam("ticketnum")String ticketnum , @RequestParam("timelimit") int timelimit) {
		
		ModelAndView mav = new ModelAndView();
		if(timelimit >= 30) {	
			int result = ticketingService.cancellationTicket(ticketnum);
			if(result > 0) {
				mav.addObject("msg", "예매가 취소되었습니다.");
				mav.addObject("goUrl", "/amor/myAmor/ticketingHistory.do");
				mav.setViewName("user/msg/userMsg");
				return mav;
			}else {
				mav.addObject("msg", "예매취소 불가(관리자 문의 바랍니다.)");
				mav.addObject("goUrl", "/amor/myAmor/ticketingHistory.do");
				mav.setViewName("user/msg/userMsg");
				return mav;
			}
		}else {
			mav.addObject("msg", "영화시작 30분 전부터는 취소가 불가능합니다.");
			mav.addObject("goUrl", "/amor/myAmor/ticketingHistory.do");
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
