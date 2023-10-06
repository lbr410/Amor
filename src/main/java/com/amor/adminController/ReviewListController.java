package com.amor.adminController;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.amor.movieReview.service.MovieReviewService;
import com.amor.movieReview.model.*;

@Controller
public class ReviewListController {

	@Autowired
	private MovieReviewService movieReviewService;
	
	@RequestMapping("admin/review/reviewList.do")
	public ModelAndView reviewListForm(
			HttpSession session,
			@RequestParam(value="cp",defaultValue = "1")int cp) {
		
		int totalCnt=movieReviewService.reviewListTotalCnt();
		int listSize=10;
		int pageSize=5;
		
		String pageStr=com.amor.page.PageModule.makePage("/amor/admin/review/reviewList.do", totalCnt, listSize, pageSize, cp);

		ModelAndView mav=new ModelAndView();
		if(session.getAttribute("data")==null) {
			mav.addObject("msg", "로그인 후 이용가능합니다.");
			mav.addObject("href", "/amor/admin/adminLogin.do");
			mav.setViewName("/admin/msg/adminMsg");			
		}else {
			List<MovieReviewDTO>lists=movieReviewService.adminReviewList(cp, listSize);
			mav.addObject("pageStr", pageStr);
			mav.addObject("lists", lists);
			mav.setViewName("/admin/review/reviewList");
		}
		return mav;
	}
	
	@RequestMapping("admin/review/reviewListSearch.do")
	public ModelAndView reviewListSearch(
			@RequestParam(value="cp",defaultValue = "1")int cp,
			@RequestParam("search")String search) {
		int totalCnt=movieReviewService.adminReviewListSearchTotalCnt(search);
		int listSize = 10;
		int pageSize = 5;
		String pageStr=com.amor.page.PageModule.makePage("/amor/admin/review/reviewList.do", totalCnt, listSize, pageSize, cp);

		List<MovieReviewDTO> lists=movieReviewService.adminReviewListSearch(cp, listSize, search);
		ModelAndView mav =new ModelAndView();
		mav.addObject("pageStr", pageStr);
		mav.addObject("lists", lists);
		mav.setViewName("/admin/review/reviewList");
		return mav;
	}
	
	@RequestMapping("admin/review/reviewPopup.do")
	public ModelAndView reviewPopup(
			@RequestParam("idx")int idx) {
		ModelAndView mav=new ModelAndView();
		MovieReviewDTO dto=movieReviewService.adminReviewPopup(idx);
		mav.addObject("dto", dto);
		mav.setViewName("/admin/review/reviewPopup");
		return mav;
	}
	
	@RequestMapping("admin/review/reviewListBlock.do")
	public ModelAndView reviewListBlock(
			@RequestParam(value="idx",defaultValue = "0") int idx,
			@RequestParam("value")String value) {
		ModelAndView mav=new ModelAndView();
		MovieReviewDTO dto=new MovieReviewDTO();
		int result=movieReviewService.adminReviewBlockUpdate(idx,value);
		mav.setViewName("/admin/review/reviewList");
		
		return mav;
	}
	
	@RequestMapping("admin/review/reviewListDelete.do")
	public ModelAndView reviewListDelete(
			@RequestParam(value="idx",defaultValue = "0") int idx) {
		
		ModelAndView mav=new ModelAndView();
		int result=movieReviewService.adminReviewListDelete(idx);
		return mav;
	}
}
