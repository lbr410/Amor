package com.amor.userController;

import java.sql.*;
import java.util.*;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
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
		mav.setViewName("/user/ticketing/ticketing");
		return mav;
	}
	
	@RequestMapping("ticketing/ticketingSelectMovie.do")
	public String ticketingSelectMovie(String movie_name, int movie_maxage, Model model) {
		model.addAttribute("movie_name",movie_name);
		model.addAttribute("movie_maxage",movie_maxage);
		model.addAttribute("msg","날짜를 선택해주세요");
		
		return "amorJson";
	}
	
	@RequestMapping("ticketing/ticketingSelectDate.do")
	public String ticketingSelectDate(HttpSession session, String movie_name, int year, int month, int date, Model model) {
		String date_d = "";
		if(date < 10) {date_d = "0"+date;}
		else {date_d = ""+date;}
		String sumdate = year+"-"+month+"-"+date_d;
		java.sql.Date sumdate_s = java.sql.Date.valueOf(sumdate);
		
		List<TicketingSelectMovieDTO> movieTimeLists = ticketingservice.ticketingPlayingMovieTimeList(movie_name,sumdate_s);
		
		model.addAttribute("movieTimeLists",movieTimeLists);
		
		return "amorJson";
	}
	
	@RequestMapping("ticketing/ticketingSchedule.do")
	public ModelAndView ticketingSchedule() {
		ModelAndView mav = new ModelAndView();
		mav.setViewName("/user/ticketing/ticketingSchedule");
		return mav;
	}
	
	@RequestMapping("ticketing/ticketingScheduleSelectDate.do")
	public String ticketingScheduleSelectDate() {
		
		
		
		return "amorJson";
	}
	
	
	
}
