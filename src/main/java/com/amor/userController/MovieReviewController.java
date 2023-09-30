package com.amor.userController;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.style.DefaultValueStyler;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartHttpServletRequest;
import org.springframework.web.servlet.ModelAndView;

import com.amor.movieReview.model.MovieReviewDTO;
import com.amor.movieReview.model.MovieReviewJoinDTO;
import com.amor.movieReview.service.MovieReviewService;
import com.amor.movieReview.service.MovieReviewServiceImple;

@Controller
public class MovieReviewController {

	@Autowired
	private MovieReviewService movieReviewService;
	
	@RequestMapping("/user/myAmor/tempReview.do")
	public String reviewTemp() {
		return "/user/myAmor/tempReview";
	}
	
	@RequestMapping(value = "/user/myAmor/movieReviewAdd.do", method = RequestMethod.POST)
	public ModelAndView reviewWrite(MovieReviewJoinDTO dto, MultipartHttpServletRequest req) {
			
		ModelAndView mav = new ModelAndView();
		mav.setViewName("/user/myAmor/movieReviewAdd");
		return mav;
	}	
	
	@RequestMapping("/user/myAmor/movieReviewList.do")
	public ModelAndView reviewList(
			@RequestParam(value = "cp", defaultValue = "1")int cp,
			@RequestParam(value = "member_idx", defaultValue = "4")int member_idx
			) {
		
		int totalCnt=movieReviewService.getTotalCnt();
		int listSize=5;
		int pageSize=5;
		
		List<MovieReviewJoinDTO> reviewLists=movieReviewService.lists(cp, listSize, member_idx);
		
		String reviewpageStr = com.amor.page.PageModule.makePage("movieReviewList.do", totalCnt, listSize, pageSize, cp);
	
		ModelAndView mav = new ModelAndView();
		mav.addObject("reviewpageStr",reviewpageStr);
		mav.addObject("reviewLists", reviewLists);
		mav.setViewName("/user/myAmor/movieReviewList");
		return mav;
	}
	
	
	
}


