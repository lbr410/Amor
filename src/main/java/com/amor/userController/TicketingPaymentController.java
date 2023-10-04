package com.amor.userController;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class TicketingPaymentController {

	@RequestMapping("ticketing/ticketingPayment.do")
	public ModelAndView ticketingPayment(
			@RequestParam("movie_idx") int movie_idx,
			@RequestParam("theater_idx") int theater_idx,
			@RequestParam("playing_movie_idx") int playing_movie_idx,
			@RequestParam("playing_movie_seat") String playing_movie_seat[],
			@RequestParam("adultC") int adultC,
			@RequestParam("teenagerC") int teenagerC,
			@RequestParam("seniorC") int seniorC,
			@RequestParam("disabledC") int disabledC,
			@RequestParam("ticketing_personnel") int ticketing_personnel,
			@RequestParam("ticketing_price") int ticketing_price
			) {
		
		
		
		ModelAndView mav = new ModelAndView();
		mav.addObject("movie_idx", movie_idx);
		mav.addObject("theater_idx", theater_idx);
		mav.addObject("playing_movie_idx", playing_movie_idx);
		mav.addObject("playing_movie_seat", playing_movie_seat);
		mav.addObject("adultC", adultC);
		mav.addObject("teenagerC", teenagerC);
		mav.addObject("seniorC", seniorC);
		mav.addObject("disabledC", disabledC);
		mav.addObject("ticketing_personnel", ticketing_personnel);
		mav.addObject("ticketing_price", ticketing_price);
		mav.setViewName("user/ticketing/ticketingPayment");
		return mav;
		
	}
}
