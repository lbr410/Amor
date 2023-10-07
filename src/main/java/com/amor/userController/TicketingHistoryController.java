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
	public ModelAndView goTiketingHistory(HttpSession session,
			@RequestParam(value = "cp", defaultValue = "1")int cp) {
		String id = (String)session.getAttribute("sid");
		ModelAndView mav = new ModelAndView();
		if(id != null) {			
			int useridx = (int)session.getAttribute("sidx");
			String pagename = "/amor/myAmor/ticketingHistory.do";
			int totalCnt = ticketingService.getticketingHistoryTotalCnt(useridx);
			int listSize = 3;
			int pageSize = 5;
			List<JoinTicketingHistoryDTO>lists = ticketingService.ticketingHistoryList(useridx,cp,listSize);
			if(lists != null) {		
				String page = com.amor.page.PageModule.makePage(pagename, totalCnt, listSize, pageSize, cp);
				mav.addObject("list", lists);
				mav.addObject("page", page);
				mav.setViewName("user/myAmor/tiketingHistory");
				return mav;
			}else {
				mav.addObject("lists", null);
				mav.addObject("page", null);
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
	public ModelAndView cancellHistory(HttpSession session,
			@RequestParam(value = "cp", defaultValue = "1")int cp) {
		
		ModelAndView mav = new ModelAndView();
		
		String id = (String)session.getAttribute("sid");
		
		if(id != null) {
			
			int useridx = (int)session.getAttribute("sidx");
			String pagename = "/amor/myAmor/cancellHistory.do";
			int totalCnt = ticketingService.getTicketingCancellListTotalCnt(useridx);
			int listSize = 3;
			int pageSize = 5;
			
			List<JoinTicketingHistoryDTO>lists = ticketingService.ticketingcancellList(useridx,cp,listSize);
			
			if(lists != null) {	
				String page = com.amor.page.PageModule.makePage(pagename, totalCnt, listSize, pageSize, cp);
				mav.addObject("list", lists);
				mav.addObject("page", page);
				mav.setViewName("user/myAmor/tiketingCancellHistory");
				
			}else {
				mav.addObject("lists", null);
				mav.addObject("page", null);
				mav.setViewName("user/myAmor/tiketingCancellHistory");				
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
			@RequestParam("seateNum")String seateNum) {
		
		ModelAndView mav = new ModelAndView();
		
		boolean checkDate = ticketingService.checkDate(ticketidx);
		
		if(checkDate) {	
			
			int result = ticketingService.cancellationTicket(ticketidx);
			
			if(result > 0) {
				
				PlayingMovieDTO getPlayingMovie = ticketingService.getPlayMovie(playingMovieidx);
				
				String[] movieSeate = getPlayingMovie.getPlaying_movie_seat().split(",");
				
				String[] ticketSeate = seateNum.split(",");
				
				//사용자가 예매한 좌석(상영영화 좌석에 동일한 좌석 데이터가 있는지 유효성검사)
				StringBuffer temp = new StringBuffer();
				
				for(int i = 0 ; i < ticketSeate.length; i++){
					for(int j = 0 ; j < movieSeate.length; j++) {
						if(!movieSeate[j].equals(ticketSeate[i])) {
							String temp1 = null; 
									temp1 += movieSeate[j];
									System.out.println(temp1);
						}
					}
				}
				
				int totalSeatesNum = getPlayingMovie.getPlaying_movie_remain_seats();
				

								
				String realignmentSeateData = temp.toString();
				
				Map<String, Object> parameter = new HashMap<String, Object>();
				parameter.put("playingMovieTotalSeateNum", totalSeatesNum);
				parameter.put("playingMovieSeates", realignmentSeateData);
				parameter.put("playingMovieIdx", playingMovieidx);
				
				int playingMovieUpdateResult = ticketingService.playingMovieSeateUpdate(parameter);
		
				if(playingMovieUpdateResult > 0) {					
					mav.addObject("msg", "예매가 취소되었습니다.");
					mav.addObject("goUrl", "/amor/myAmor/ticketingHistory.do");
					mav.setViewName("user/msg/userMsg");
				}else {
					mav.addObject("msg", "예매취소 실패(관리자 문의 바랍니다.)");
					mav.addObject("goUrl", "/amor/myAmor/ticketingHistory.do");
					mav.setViewName("user/msg/userMsg");
				}				
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
