package com.amor.adminController;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class TicketingController {

	@RequestMapping("ticketing/ticketingPayment.do")
	public String ticketingPayment() {
		return "/user/ticketing/ticketingPayment";
	}
}
