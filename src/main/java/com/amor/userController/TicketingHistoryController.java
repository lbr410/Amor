package com.amor.userController;


import javax.servlet.http.HttpSession;

import org.apache.commons.collections.map.HashedMap;
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
	public ModelAndView TiketingHistory(HttpSession session,
			@RequestParam(value = "cp", defaultValue = "1")int cp) {
		
		String id = (String)session.getAttribute("sid");
		
		ModelAndView mav = new ModelAndView();
		
		if(id != null) {			
			int useridx = (int)session.getAttribute("sidx");
			String pagename = "/amor/myAmor/ticketingHistory.do";
			int totalCnt = ticketingService.getticketingHistoryTotalCnt(useridx);
			int listSize = 5;
			int pageSize = 5;
			List<JoinTicketingHistoryDTO>lists = ticketingService.ticketingHistoryList(useridx,cp,listSize);
			if(lists != null) {		
				String page = com.amor.page.PageModule.makePage(pagename, totalCnt, listSize, pageSize, cp);
				mav.addObject("list", lists);
				mav.addObject("page", page);
				mav.setViewName("user/myAmor/tiketingHistory");
			}else {
				mav.addObject("lists", null);
				mav.addObject("page", null);
				mav.setViewName("user/myAmor/tiketingHistory");
			}
		}else {
			mav.addObject("msg", "로그인 후 이용가능합니다.");
			mav.addObject("goUrl", "/amor/member/login.do");
			mav.setViewName("user/msg/userMsg");
		}
		return mav;
	}
	
	@RequestMapping("/myAmor/cancelHistory.do")
	public ModelAndView cancelHistory(HttpSession session,
			@RequestParam(value = "cp", defaultValue = "1")int cp) {
		
		ModelAndView mav = new ModelAndView();
		
		String id = (String)session.getAttribute("sid");
		
		if(id != null) {
			
			int useridx = (int)session.getAttribute("sidx");
			String pagename = "cancelHistory.do";
			int totalCnt = ticketingService.getTicketingCancelListTotalCnt(useridx);
			int listSize = 5;
			int pageSize = 5;
			
			List<JoinTicketingHistoryDTO>lists = ticketingService.ticketingcancelList(useridx,cp,listSize);
			
			if(lists != null) {	
				String page = com.amor.page.PageModule.makePage(pagename, totalCnt, listSize, pageSize, cp);
				mav.addObject("list", lists);
				mav.addObject("page", page);
				mav.setViewName("user/myAmor/tiketingCancelHistory");
				
			}else {
				mav.addObject("lists", null);
				mav.addObject("page", null);
				mav.setViewName("user/myAmor/tiketingCancelHistory");				
			}
	}else{
		mav.addObject("msg", "로그인 후 이용가능합니다.");
		mav.addObject("goUrl", "/amor/member/login.do");
		mav.setViewName("user/msg/userMsg");
	}
		return mav;
}
	
	
	@RequestMapping("/myAmor/cancellation.do")
	public ModelAndView cancellationTicket(@RequestParam("ticketingidx")int ticketidx ,
			@RequestParam("playingMovieidx")int playingMovieidx,
			@RequestParam("seateNum")String seateNum,
			@RequestParam("movieidx")int movieidx) {
		
		ModelAndView mav = new ModelAndView();
		
		boolean checkDate = ticketingService.checkDate(ticketidx);
		
		if(checkDate) {	
			
			boolean result = ticketingService.cancellationTicket(seateNum,playingMovieidx,ticketidx,movieidx);
			
			if(result) {
					mav.addObject("msg", "예매가 취소되었습니다.");
					mav.addObject("goUrl", "/amor/myAmor/ticketingHistory.do");
					mav.setViewName("user/msg/userMsg");
			}else {
				mav.addObject("msg", "예매취소 실패(관리자 문의 바랍니다.)");
				mav.addObject("goUrl", "/amor/myAmor/ticketingHistory.do");
				mav.setViewName("user/msg/userMsg");
			}
		}else {				
			mav.addObject("msg", "영화시작 30분전만 취소가 가능합니다.");
			mav.addObject("goUrl", "/amor/myAmor/ticketingHistory.do");				
			mav.setViewName("user/msg/userMsg");
		}
		return mav;
	}
	
}
