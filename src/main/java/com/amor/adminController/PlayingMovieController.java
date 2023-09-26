package com.amor.adminController;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import java.sql.Date;
import java.util.*;
import com.amor.playingMovie.model.*;
import com.amor.playingMovie.service.PlayingMovieService;

@Controller
public class PlayingMovieController {
	
	@Autowired
	private PlayingMovieService playingMovieService;

	@RequestMapping("admin/playMovie/playingMovieList.do")
	public ModelAndView playingMovieList(
			@RequestParam(value = "cp", defaultValue = "1") int cp) {
		int totalCnt=playingMovieService.getTotalCnt();
		int listSize=5;
		int pageSize=5;
		
		List<PlayingMovieDTO> lists=playingMovieService.playingMovieList(cp, listSize);
		
		System.out.println("test="+lists.size());
		System.out.println("totalCnt="+totalCnt);
		
		String playpageStr=com.amor.page.PageModule.makePage("admin/playMovie/playingMovieList.do", totalCnt, listSize, pageSize, cp);
		
		ModelAndView mav = new ModelAndView();
		mav.addObject("playpageStr", playpageStr);
		mav.addObject("lists", lists);
		mav.setViewName("/admin/playMovie/playingMovieList");
		return mav;
	}
	

	@RequestMapping(value = "admin/playMovie/playingMovieAdd.do", method = RequestMethod.GET)
	public ModelAndView playingMoiveAddList () {
		
		List<Map> movieLists = playingMovieService.playingMovieAddMovie();
		List<Map> screenLists = playingMovieService.playingMovieAddScreen();
		
		System.out.println("test1="+movieLists.size());
		System.out.println("test2="+screenLists.size());
		System.out.println("test3="+movieLists.get(0).get("MOVIE_NAME"));
		
		ModelAndView mav = new ModelAndView();
		mav.addObject("movieLists", movieLists);
		mav.addObject("screenLists", screenLists);
		mav.setViewName("/admin/playMovie/playingMovieAdd");
		return mav;
	}
	
	@RequestMapping(value = "admin/playMovie/playingMovieAdd.do", method = RequestMethod.POST)
	public ModelAndView playingMovieAdd (
			@RequestParam("movie_idx")int movie_idx,
			@RequestParam("theater_idx")int theater_idx,
			@RequestParam("playing_movie_date")String playing_movie_date,
			@RequestParam("playing_movie_start")String playing_movie_start,
			@RequestParam("playing_movie_end")String playing_movie_end) {

		
//		int result = playingMovieService.playingMovieAdd(dto);
//		System.out.println(dto.getPlaying_movie_date());
//		System.out.println(dto.getPlaying_movie_start());
		
//		String msg = result>0?"상영 시간이 등록되었습니다.":"등록에 실패하였습니다.";
//		ModelAndView mav = new ModelAndView();
//		mav.addObject("msg",msg);
//		mav.addObject("href","/amor/admin/playMovie/playingMovieAdd.do");
//		mav.setViewName("admin/msg/adminMsg");
		return null;
	}
	
}
