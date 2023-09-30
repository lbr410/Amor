package com.amor.userController;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class TicketingPaymentController {

	@RequestMapping("ticketing/ticketingPayment.do")
	public ModelAndView ticketingPayment() {
		
		ModelAndView mav = new ModelAndView();
		
		mav.setViewName("user/ticketing/ticketingPayment");
		return mav;
		
	}
}
