package com.amor.userController;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.amor.movie.service.MovieService;

@Controller
public class IndexController {
	
	@Autowired
	private MovieService movieService;
	
	@RequestMapping("/index.do")
	public String index() {
		
		return "index";   
	}
	
	
	//현재 상영작 폼으로 이동
	@RequestMapping(value = "/movie/movie.do", method = RequestMethod.GET)
	public String movieList() {
		return "user/movie/movie";
	}
	
}