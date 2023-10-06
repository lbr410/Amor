package com.amor.userController;


import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.amor.playingMovie.model.PlayingMovieDTO;
import com.amor.ticketing.model.JoinTicketingHistoryDTO;
import com.amor.ticketing.service.TicketingService;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.util.*;
@Controller
public class TicketingHistoryController {

	@Autowired
	private TicketingService ticketingService;
	
	@RequestMapping("/myAmor/ticketingHistory.do")
	public ModelAndView goTiketingHistory(HttpSession session) {
		String id = (String)session.getAttribute("sid");
		ModelAndView mav = new ModelAndView();
		if(id != null) {			
			int useridx = (int)session.getAttribute("sidx");
			List<JoinTicketingHistoryDTO>lists = ticketingService.getReserveList(useridx);
			if(lists != null) {		
				for(int i=0;i<lists.size();i++) {
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
	public ModelAndView cancellationTicket(@RequestParam("ticketingidx")int ticketidx ,
			@RequestParam("playingMovieidx")int playingMovieidx) {
		
		ModelAndView mav = new ModelAndView();
		
		PlayingMovieDTO getPlayingMovie = ticketingService.getPlayMovie(playingMovieidx);
		
		int totalSeatesNum = getPlayingMovie.getPlaying_movie_remain_seats();
		String seates = getPlayingMovie.getPlaying_movie_seat();
		String[] s = seates.split(",");
		for(int i = 0 ; i < s.length; i++) {
			System.out.println(s[i]);
		}
		System.out.println(totalSeatesNum);
		
		
		
		boolean checkDate = ticketingService.checkDate(ticketidx);			
	//	if(checkDate) {				
	//		int result = ticketingService.cancellationTicket(ticketidx);
	//		if(result > 0) {
	//		mav.addObject("msg", "예매가 취소되었습니다.");
	//			mav.addObject("goUrl", "/amor/myAmor/ticketingHistory.do");
	//			mav.setViewName("user/msg/userMsg");
	//		}else {
	//			mav.addObject("msg", "예매취소 불가(관리자 문의 바랍니다.)");
	//			mav.addObject("goUrl", "/amor/myAmor/ticketingHistory.do");
	//			mav.setViewName("user/msg/userMsg");
	//		}
	//	}else {				
	//		mav.addObject("msg", "영화시작 30분전만 취소가 가능합니다.");
	//		mav.addObject("goUrl", "/amor/myAmor/ticketingHistory.do");				
	//		mav.setViewName("user/msg/userMsg");
	//	}
		return mav;
	}
	
}
