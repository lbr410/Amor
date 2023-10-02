package com.amor.userController;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.amor.movie.model.MovieDTO;
import com.amor.movie.service.MovieService;

@Controller
public class MovieSearchController {
	
	@Autowired
	private MovieService movieservice;

	@RequestMapping("/movie/movieSearch.do")
	public ModelAndView movieSearch(@RequestParam("search")String search,
			@RequestParam(value = "cp", defaultValue = "1")int cp) {
		
		int totalCnt = movieservice.getUserSearchTotalCnt(search);
		System.out.println(totalCnt);
		int listSize = 5;
		int pageSize = 5;
		
		ModelAndView mav = new ModelAndView();
		if(search != null || search.equals("")) {
			String pageTag = com.amor.page.PageModuleSearch.makePage("/amor/movie/movieSearch.do", totalCnt, listSize, pageSize, cp, search);
			List<MovieDTO> lists = movieservice.userMovieSearch(search, cp, listSize);
			mav.addObject("lists",lists);
			mav.addObject("pageTag", pageTag);
			mav.setViewName("/user/headerSearch");
			return mav;
		}else {
			mav.addObject("lists",null);
			mav.addObject("pageTag",null);
			mav.setViewName("/user/headerSearch");
			return mav;
		}
	}
}
