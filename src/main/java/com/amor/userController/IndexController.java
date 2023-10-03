package com.amor.userController;

import java.util.*;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.amor.movie.model.MovieDTO;
import com.amor.movie.service.MovieService;
import com.amor.product.model.ProductDTO;
import com.amor.product.service.ProductService;

@Controller
public class IndexController {
	
	@Autowired
	private MovieService movieservice;
	@Autowired
	private ProductService productService;
	
	@RequestMapping("/index.do")
	public ModelAndView index() {
		
		//banner
		//List<BannerDTO> blists = bannerService.bannerList();
		
		//Movie
		List<MovieDTO> mlists = movieservice.movieBest(0, 0);
		
		//ads
		//List<AdsDTO> alists = adsService.adsList();
		//Store
		List<ProductDTO> slists = productService.storeSnackList();
		List<ProductDTO> tlists = productService.storeTicketList();

		ModelAndView mav=new ModelAndView();
		mav.addObject("mlists", mlists);
		//mav.addObject("alists", alists);
		mav.addObject("slists", slists);
		mav.addObject("tlists", tlists);
		
		mav.setViewName("index");
		return mav;   
	}
	
	
	
}