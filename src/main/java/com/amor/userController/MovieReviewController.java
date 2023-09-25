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
import com.amor.movieReview.service.MovieReviewService;
import com.amor.movieReview.service.MovieReviewServiceImple;

@Controller
public class MovieReviewController {

	@Autowired
	private MovieReviewService movieReviewService;
	
	@RequestMapping("user/myAmor/reviewTemp.do")
	public String reviewWrite() {
		return "/user/myAmor/tempReview";
	}	
	
	@RequestMapping("user/myAmor/reviewList.do")
	public ModelAndView reviewList(
			@RequestParam(value = "cp", defaultValue = "1")int cp,
			@RequestParam(value = "member_idx", defaultValue = "4")int member_idx
			) {
		
		int totalCnt=movieReviewService.getTotalCnt();
		int listSize=5;
		int pageSize=5;
		
		List<MovieReviewDTO> lists=movieReviewService.lists(cp, listSize, member_idx);
		
		String reviewpageStr = com.amor.page.PageModule.makePage("myAmor/reviewList.do", totalCnt, listSize, pageSize, cp);
	
		ModelAndView mav = new ModelAndView();
		mav.addObject("reviewpageStr",reviewpageStr);
		mav.addObject("lists",lists);
		mav.setViewName("/user/myAmor/reviewList");
		return mav;
	}
	
	
	
}


