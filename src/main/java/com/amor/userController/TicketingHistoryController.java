package com.amor.userController;


import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
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
			System.out.println(lists.get(0));
			mav.addObject("list", lists);
			mav.setViewName("user/myAmor/tiketingHistory");
			return mav;
		}else {
			mav.setViewName("user/member/login");
			return mav;
		}
	}
	
}
