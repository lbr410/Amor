package com.amor.adminController;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;
import java.util.*;
import com.amor.playingMovie.model.*;
import com.amor.playingMovie.service.PlayingMovieService;

@Controller
public class PlayingMovieController {
	
	@Autowired
	private PlayingMovieService playingMovieService;

	@RequestMapping("admin/playMovie/playingMovieList.do")
	public ModelAndView playingMovieList(
			@RequestParam(value = "cp", defaultValue = "1") int cp) {
		int totalCnt=playingMovieService.getTotalCnt();
		int listSize=5;
		int pageSize=5;
		
		List<PlayingMovieDTO> lists=playingMovieService.playingMovieList(cp, listSize);
		
		String playpageStr=com.amor.page.PageModule.makePage("playingMovieList.do", totalCnt, listSize, pageSize, cp);
		
		ModelAndView mav = new ModelAndView();
		mav.addObject("playpageStr", playpageStr);
		mav.addObject("lists", lists);
		mav.setViewName("/admin/playMovie/playingMovieList");
		return mav;
	}
	
	@RequestMapping("admin/playMovie/playMovieAdd.do")
	public ModelAndView playingMoiveAdd () {
		return null;
	}
	
	
}
