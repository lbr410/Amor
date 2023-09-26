package com.amor.userController;


import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.amor.ticketing.service.TicketingService;

@Controller
public class TicketingHistoryController {

	@Autowired
	TicketingService ticketingHistoryService;
	
	@RequestMapping("/myAmor/ticketingHistory.do")
	public String goTiketingHistory(HttpSession session) {
		String id = (String)session.getAttribute("sid");
		System.out.println(id);
		if(id != null) {			
			
			return "user/myAmor/tiketingHistory";
		}else {
			return "user/member/login";
		}
	}
	
}
