package com.amor.userController;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.amor.movie.model.MovieDTO;
import com.amor.movie.service.MovieService;
import com.amor.movieReview.model.MovieReviewDTO;

@Controller
public class MovieContentController {

	@Autowired
	private MovieService movieservice; 
	
		//현재 상영작 출력
		@RequestMapping("movie/movie.do")
		public ModelAndView movieList() {
			
			int movieBestCnt=movieservice.movieBestCnt();
		
			ModelAndView mav=new ModelAndView();
			
			List<MovieDTO> mlists = movieservice.movieBest();
			List<MovieDTO> rlists = movieservice.movieBestReview();
			mav.addObject("mlists", mlists);
			mav.addObject("rlists", rlists);
			mav.addObject("movieBestCnt", movieBestCnt);
			mav.setViewName("/user/movie/movie");
			return mav;
		}

		//상영 예정작 출력
		@RequestMapping("movie/movieCome.do")
		public ModelAndView movieCome(){
			
			int totalCnt=movieservice.movieComeCnt();
			
			ModelAndView mav=new ModelAndView();
			List<MovieDTO> clists = movieservice.movieCome();
			List<MovieDTO> nlists = movieservice.movieName();
			mav.addObject("clists", clists);
			mav.addObject("nlists", nlists);
			mav.setViewName("/user/movie/movieCome");
			return mav;
		}
		
		//영화 상세 페이지 이동
		@RequestMapping("movie/movieContentForm.do")
		public ModelAndView movieContent (
				@RequestParam(value="movie_idx", defaultValue = "0")int movie_idx
				) {
			
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
		
		//영화 상세 페이지 JSON 데이터
		@RequestMapping("movie/movieContentForm2.do")
		public ModelAndView movieContentJSON (
				@RequestParam(value="movie_idx", defaultValue = "0")int movie_idx,
				@RequestParam(value="cp", defaultValue = "1")int cp
				) {
			
			int totalCnt=movieservice.movieReviewContentCnt(movie_idx);
			int listSize=5;
			int pageSize=5;
			
			List<MovieReviewDTO> rlists = movieservice.movieReviewInfo(movie_idx, cp, listSize);
			
			String reviewPage = com.amor.page.PageModuleAjax.makePage(totalCnt, listSize, pageSize, cp);
			
			ModelAndView mav=new ModelAndView();
			
			mav.addObject("reviewPage", reviewPage);
			mav.addObject("rlists",rlists);
			mav.setViewName("amorJson");
			
			return mav;
	 	}
		
}
