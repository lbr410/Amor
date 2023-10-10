package com.amor.adminController;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.amor.ticketing.service.TicketingService;
import com.amor.ticketing.model.TicketingListDTO;
import java.util.*;

import javax.servlet.http.HttpSession;

@Controller
public class TicketingListController {
	
	@Autowired
	private TicketingService ticketingservice;

	@RequestMapping("admin/ticketing/ticketingList.do")
	public ModelAndView ticketingList(@RequestParam(value="cp", defaultValue = "1") int cp, @RequestParam(value="search", defaultValue = "") String search, HttpSession session) {
		ModelAndView mav = new ModelAndView();
		int listSize=5;
		int pageSize=5;
		
		if(session.getAttribute("data") == null) {
			mav.addObject("msg", "로그인 후 이용 가능합니다.");
			mav.addObject("href", "/amor/admin/adminLogin.do");
			mav.setViewName("/admin/msg/adminMsg");
		} else {
			if(search == null || search.equals("")) {
				int totalCnt=ticketingservice.getTotalCnt();
				String pageStr = com.amor.page.PageModule.makePage("/amor/admin/ticketing/ticketingList.do", totalCnt, listSize, pageSize, cp);
				List<TicketingListDTO> lists = ticketingservice.ticketingList(cp, listSize);
				int pagsize = lists.size();
				
				mav.addObject("lists",lists);
				mav.addObject("pagsize", pagsize);
				mav.addObject("pageStr", pageStr);
				mav.setViewName("admin/ticketing/ticketingList");
				
			}else {
				int totalCnt=ticketingservice.getTotalSearchCnt(search);
				String pageStr = com.amor.page.PageModuleSearch.makePage("/amor/admin/ticketing/ticketingList.do", totalCnt, listSize, pageSize, cp, search);
				List<TicketingListDTO> lists = ticketingservice.ticketingListSearch(cp, listSize,search);
				int pagsize = lists.size();
				mav.addObject("lists",lists);
				mav.addObject("pagsize", pagsize);
				mav.addObject("pageStr", pageStr);
				mav.setViewName("admin/ticketing/ticketingList");
			}
		}
		return mav;
	}
	
	@RequestMapping("admin/ticketing/ticketingstateChk.do")
	public ModelAndView ticketingstateChange(int ticketing_idx,int playing_movie_idx,int movie_idx,int ticketing_personnel,String ticketing_seat) {
		String state = "n";
		TicketingListDTO dto = new TicketingListDTO(ticketing_idx,state);
		dto.setTicketing_idx(ticketing_idx);
		dto.setTicketing_state(state);
		ticketingservice.ticketingstateChange(dto);
		ticketingservice.cancellationTicket(ticketing_seat,playing_movie_idx,ticketing_idx,movie_idx);
		
		
		ModelAndView mav = new ModelAndView();
		mav.setViewName("admin/ticketing/ticketingList");
		return mav;
	}
	
}
