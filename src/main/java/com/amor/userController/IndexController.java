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
import com.amor.ads.model.AdsDTO;
import com.amor.ads.service.AdsService;
import com.amor.banner.model.BannerDTO;
import com.amor.banner.service.BannerService;

@Controller
public class IndexController {
	
	@Autowired
	private MovieService movieservice;
	@Autowired
	private ProductService productService;
	@Autowired
	private BannerService bannerService;
	@Autowired
	private AdsService adsService;
	
	@RequestMapping("/index.do")
	public ModelAndView index() {
		
		//banner
		List<BannerDTO> blists = bannerService.bannerList();
		
		//Movie
		List<MovieDTO> mlists = movieservice.movieBest();
		
		//ads
		List<AdsDTO> alists = adsService.adsList();

		//Store
		List<ProductDTO> slists = productService.storeSnackList();
		List<ProductDTO> tlists = productService.storeTicketList();

		ModelAndView mav=new ModelAndView();
		mav.addObject("blists", blists);
		mav.addObject("mlists", mlists);
		mav.addObject("alists", alists);
		mav.addObject("slists", slists);
		mav.addObject("tlists", tlists);
		
		mav.setViewName("index");
		return mav;   
	}
	
	
	//영화 상세내용 페이지로 이동
	@RequestMapping("movieContentForm.do")
	public ModelAndView movieContent(
			@RequestParam(value="movie_idx", defaultValue = "0")int movie_idx) {
		
		MovieDTO dto = movieservice.movieContent(movie_idx);
		ModelAndView mav=new ModelAndView();
		if(dto == null) {
			mav.addObject("msg","삭제된 게시물 잘못된 접근입니다.");
			mav.setViewName("user/msg/userMsg");
		}else {
			String movieContent = dto.getMovie_content().replaceAll("\n", "<br>");
			mav.addObject("movieContent",movieContent);
			mav.addObject("dto",dto);
			mav.setViewName("/user/movie/movieContent");
		}
		return mav;
 	}
	
	
	
}