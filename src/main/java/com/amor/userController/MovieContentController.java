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
		public ModelAndView movieList(
				@RequestParam(value="cp", defaultValue = "1") int cp) {
			
			int totalCnt=movieservice.getTotalCnt();
			int listSize=5;
			int pageSize=5;
			String pageStr=com.amor.page.PageModule.makePage("/amor/user/movie/movie.do", totalCnt, listSize, pageSize, cp);

			List<MovieDTO> mlists = movieservice.movieBest(cp, listSize);
			ModelAndView mav=new ModelAndView();
			mav.addObject("mlists", mlists);
			mav.addObject("pageStr", pageStr);
			mav.setViewName("/user/movie/movie");
			return mav;
		}

		
		//영화 상세내용
		@RequestMapping("movie/movieContentForm.do")
		public ModelAndView movieContent(
				@RequestParam(value="movie_idx", defaultValue = "0")int movie_idx,
				@RequestParam(value="cp", defaultValue = "1")int cp
				) {
			
			int totalCnt=movieservice.movieReviewContentCnt(movie_idx);
			int listSize=5;
			int pageSize=5;
			
			MovieDTO dto = movieservice.movieContent(movie_idx);
			List<MovieReviewDTO> rlists = movieservice.movieReviewInfo(movie_idx, cp, listSize);
			ModelAndView mav=new ModelAndView();
			if(dto == null || rlists == null) {
				mav.addObject("msg","삭제된 게시물 잘못된 접근입니다.");
				mav.setViewName("user/msg/userMsg");
			}else {
				String movieContent = dto.getMovie_content().replaceAll("\n", "<br>");
				mav.addObject("movieContent",movieContent);
				mav.addObject("rlists",rlists);
				mav.addObject("dto",dto);
				mav.setViewName("/user/movie/movieContent");
			}
			return mav;
	 	}
		
}
