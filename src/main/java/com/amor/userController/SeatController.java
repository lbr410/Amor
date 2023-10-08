package com.amor.userController;

import java.time.*;
import java.time.format.TextStyle;
import java.util.*;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.amor.movie.model.MovieDTO;
import com.amor.movie.service.MovieService;
import com.amor.playingMovie.model.PlayingMovieDTO;
import com.amor.playingMovie.service.PlayingMovieService;
import com.amor.theater.model.TheaterDTO;
import com.amor.theater.service.TheaterService;

@Controller
public class SeatController {
	
	@Autowired
	private MovieService movieService;
	
	@Autowired
	private PlayingMovieService playingMovieService;
	
	@Autowired
	private TheaterService theaterService;
	
	@RequestMapping("ticketing/seat.do")
	public ModelAndView seatForm(HttpSession session,
								 @RequestParam("movie_idx") int movie_idx,
								 @RequestParam("theater_idx") int theater_idx,
								 @RequestParam("playing_movie_idx") int playing_movie_idx) {
		// 영화 정보 조회
		MovieDTO movieInfo = movieService.movieContent(movie_idx);
		// 상영 영화 정보 조회
		PlayingMovieDTO playingMovieInfo = playingMovieService.playingMovieContent(playing_movie_idx);
		// 상영관 정보
		TheaterDTO theaterInfo = theaterService.theaterInfo(theater_idx);
		
		// 상영 영화 날짜의 요일 구하기
		int movieDateY = Integer.parseInt(playingMovieInfo.getPlaying_movie_date().substring(0, 4));
		int movieDateM = Integer.parseInt(playingMovieInfo.getPlaying_movie_date().substring(5, 7));
		int movieDateD = Integer.parseInt(playingMovieInfo.getPlaying_movie_date().substring(8, 10));
		LocalDate movieDate = LocalDate.of(movieDateY, movieDateM, movieDateD);
		DayOfWeek dayOfWeek = movieDate.getDayOfWeek();
		String yoil = dayOfWeek.getDisplayName(TextStyle.NARROW, Locale.KOREAN);
		String fullMovieDate = playingMovieInfo.getPlaying_movie_date().substring(0, 10)+"("+yoil+")";
		
		// 영화 시작 시간과 끝나는 시간만 짜르기
		int lastIndex = playingMovieInfo.getPlaying_movie_start().lastIndexOf(":");
		String StartTimeInfo = playingMovieInfo.getPlaying_movie_start().substring(lastIndex - 5, lastIndex);
		String EndtimeInfo = playingMovieInfo.getPlaying_movie_end().substring(lastIndex - 5, lastIndex);
		
		playingMovieInfo.setPlaying_movie_date(fullMovieDate);
		playingMovieInfo.setPlaying_movie_start(StartTimeInfo);
		playingMovieInfo.setPlaying_movie_end(EndtimeInfo);
		
		ModelAndView mav = new ModelAndView();
		
		/*if(session.getAttribute("sidx") == null) {
			mav.addObject("msg", "로그인 후 이용 가능합니다.");
			mav.addObject("goUrl", "/amor/member/login.do");
			mav.setViewName("/user/msg/userMsg");
		} else {*/
			mav.addObject("movieInfo", movieInfo);
			mav.addObject("playingMovieInfo", playingMovieInfo);
			mav.addObject("theaterInfo", theaterInfo);
			mav.setViewName("user/ticketing/seat");
		//}
		return mav;
	}
}