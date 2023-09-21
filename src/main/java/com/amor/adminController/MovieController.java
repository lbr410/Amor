package com.amor.adminController;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class MovieController {

	@RequestMapping("movieList.do")
	public String movieList() {
		
		return "admin/movie/movieList";
	}
	
	@RequestMapping("movieAdd.do")
	public String movieAdd() {
		
		return "admin/movie/movieAdd";
	}
	
	@RequestMapping("movieUpdate.do")
	public String movieUpdate() {
		
		return "admin/movie/movieUpdate";
	}
	
	@RequestMapping("moviePopUp.do")
	public String moviePopUp() {
		
		return "admin/movie/moviePopUp";
	}
	
}
