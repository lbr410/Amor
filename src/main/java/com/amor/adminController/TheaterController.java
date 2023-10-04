package com.amor.adminController;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.amor.theater.model.TheaterDTO;
import com.amor.theater.service.TheaterService;
import com.amor.etc.*;

@Controller
public class TheaterController {

	@Autowired
	TheaterService theaterService;
	
	@RequestMapping("/admin/theater/theaterList.do")
	public ModelAndView goTheater() {
		List<TheaterDTO> lists = theaterService.theaterSelect();
		ModelAndView mav = new ModelAndView();
		if(lists != null) {
			mav.addObject("lists", lists);
			mav.setViewName("admin/theater/theaterList");
			return mav;
		}else{
			mav.addObject("lists", null);
			mav.setViewName("admin/theater/theaterList");
			return mav;
		}
	}
	
	@RequestMapping("/admin/theater/createTheater.do")
	public void createTheater() {
		theaterService.theaterAdd();
	}
	
	@RequestMapping("/admin/theater/seateSelect.do")
	public void seateSelect() {
		seat item = new seat();
		String seats = item.addTheater(null, 0, 0);
	}
	
}
