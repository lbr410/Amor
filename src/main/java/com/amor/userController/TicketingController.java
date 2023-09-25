package com.amor.userController;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class TicketingController {
	
	@RequestMapping("ticketing/ticketing.do")
	public ModelAndView ticketing() {
		ModelAndView mav = new ModelAndView();
		
		
		
		mav.setViewName("user/ticketing/ticketing");
		return mav;
	}
	
}
