package com.amor.adminController;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.CookieValue;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.amor.theater.model.TheaterDTO;
import com.amor.theater.service.TheaterService;
import com.amor.etc.*;

@Controller
public class TheaterController {

	@Autowired
	TheaterService theaterService;
	
	@RequestMapping("/admin/theater/theaterList.do")
	public ModelAndView TheaterList(@CookieValue(value = "autologin", required = false)String autologin,
			HttpSession session) {

		ModelAndView mav = new ModelAndView();
		String id = (String)session.getAttribute("data");
		if(autologin != null || id != null) {
			
		List<TheaterDTO> lists = theaterService.theaterSelect();
		if(lists != null) {
			mav.addObject("lists", lists);
			mav.setViewName("admin/theater/theaterList");
		}else{
			mav.addObject("lists", null);
			mav.setViewName("admin/theater/theaterList");
		}
		
		}else {
			mav.addObject("msg", "로그인 후 이용가능합니다.");
			mav.addObject("href", "/amor/admin/adminLogin.do");
			mav.setViewName("admin/msg/adminMsg");
		}
		return mav;
	}
	
	@RequestMapping("/admin/theater/createTheater.do")
	public String createTheater(Model model) {
		int totalTheater = theaterService.totalTheater();
		if(totalTheater == 6) {
			model.addAttribute("alert", "상영관을 6개이상 생성하실수 없습니다.");
		}else{
			int result = theaterService.theaterAdd();
			if(result > 0) {
				model.addAttribute("alert", null);
			}else {
				model.addAttribute("alert", "생성중 오류가 발생했습니다 관리자 문의 바랍니다.");
			}
			
		}
		return "amorJson";
	}
	
	@RequestMapping("/admin/theater/addSeate.do")
	public String showSeate(@RequestParam("row")int row,
			@RequestParam(name = "col",required = false)int col,
			@RequestParam("theateridx")int tidx,
			Model model) {
		TheaterDTO tdto = theaterService.theaterInfo(tidx);
		Seats item = new Seats();
		String seats = item.createSeats(tdto.getTheater_seat(), row, col);
		model.addAttribute("seats",seats);
		return "amorJson";
	}
	
	@RequestMapping("/admin/theater/seateInitialization.do")
	public String seateInitialization(@RequestParam("row")int row,
			@RequestParam(name = "col",required = false)int col,
			Model model) {
		Seats item = new Seats();
		String seats = item.createSeats(null, row, col);
		model.addAttribute("seats",seats);
		return "amorJson";
	}
	
	@RequestMapping("/admin/theater/updateSeate.do")
	public String updateSeate(@RequestParam("seatsData")String seats,
			@RequestParam("totalseat")int totalseat,
			@RequestParam("row")int row,
			@RequestParam("col")int col,
			@RequestParam("tidx")int tidx,
			@RequestParam("theatername")String name,
			Model model) {
		int result = theaterService.updateSeate(name, seats, tidx, totalseat, row, col);
		if(result > 0) {
			model.addAttribute("alert","저장했습니다.");
		}else {
			model.addAttribute("alert","저장이 실패했습니다.(관리자 문의)");
		}
		return "amorJson";
		
	}
	
	@RequestMapping("/admin/theater/seateSelect.do")
	public ModelAndView seateSelect(@RequestParam("theateridx")int tidx,
			@RequestParam("row")int row_s,
			@RequestParam("col")int col_s,
			@CookieValue(value = "autologin", required = false)String autologin,
			HttpSession session) {
		String id = (String)session.getAttribute("data");

		ModelAndView mav = new ModelAndView();
		
		if(autologin != null || id != null) {			
			TheaterDTO tdto = theaterService.theaterInfo(tidx);
			Seats item = new Seats();
			int row = 0;
			int col = 0;
			if(tdto.getTheater_row() > row_s) {
				row = tdto.getTheater_row();
			}else {
				row = row_s;
			}
			if(tdto.getTheater_column() > col_s) {
				col = tdto.getTheater_column();
			}else {
				col = col_s;
			}
			String seats = item.createSeats(tdto.getTheater_seat(), row, col);
			mav.addObject("tidx", tidx);
			mav.addObject("row",row);
			mav.addObject("col",col);
			mav.addObject("theatername", tdto.getTheater_name());
			mav.addObject("seats", seats);
			mav.setViewName("/admin/theater/theaterAdd");
		}else {
			mav.addObject("msg", "로그인 후 이용가능합니다.");
			mav.addObject("href", "/amor/admin/adminLogin.do");
			mav.setViewName("admin/msg/adminMsg");
		}
		return mav;
	}
	
	@RequestMapping("/admin/theater/theaterDelete.do")
	public String theaterDelete(@RequestParam("tidx")int tidx,Model model) {
		
		int result = theaterService.theaterDelete(tidx);
		if(result > 0) {
			model.addAttribute("tidx", tidx);
		}else {
			model.addAttribute("alert", "삭제 실패 관리자 문의바랍니다.");
		}
		return "amorJson";
	}
	
}
