package com.amor.userController;

import java.util.*;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.amor.ticketing.model.TicketingSelectMovieDTO;
import com.amor.ticketing.service.TicketingService;

@Controller
public class TicketingController {
	
	@Autowired
	private TicketingService ticketingservice;
	
	@RequestMapping("ticketing/ticketing.do")
	public ModelAndView ticketing() {
		
		List<TicketingSelectMovieDTO> lists = ticketingservice.ticketingPlayingMovieList();
		
		ModelAndView mav = new ModelAndView();
		mav.addObject("lists", lists);
		mav.setViewName("user/ticketing/ticketing");
		return mav;
	}
	
	@RequestMapping("ticketing/ticktingSelectMovie.do")
	public ModelAndView ticktingSelectMovie(@RequestParam(value="movie_name", defaultValue = "1") String movie_name) {
		
		
		ModelAndView mav = new ModelAndView();
		mav.setViewName("user/ticketing/ticketing");
		return mav;
	}
	
}
