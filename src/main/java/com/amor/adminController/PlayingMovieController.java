package com.amor.adminController;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import java.sql.Date;
import java.text.SimpleDateFormat;
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
		
		String playpageStr=com.amor.page.PageModule.makePage("playingMovieList.do", totalCnt, listSize, pageSize, cp);
		
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
		
		System.out.println(playing_movie_start);
		System.out.println(playing_movie_end);
		System.out.println(playing_movie_date);
		
		PlayingMovieDTO dto = new PlayingMovieDTO(movie_idx, theater_idx, playing_movie_date, playing_movie_start, playing_movie_end);
		
		int result = playingMovieService.playingMovieAdd(dto);
		
		String msg = result>0?"상영 시간이 등록되었습니다.":"등록에 실패하였습니다.";
		ModelAndView mav = new ModelAndView();
		mav.addObject("msg",msg);
		mav.addObject("href","/amor/admin/playMovie/playingMovieAdd.do");
		mav.setViewName("admin/msg/adminMsg");
		return mav;
	}
	
	@RequestMapping(value = "admin/playMovie/playingMovieUpdate.do", method = RequestMethod.GET)
	public ModelAndView playingMovieUpdateList (
			@RequestParam("playing_movie_idx")int idx_u) {
		
		PlayingMovieDTO updatedto=playingMovieService.playingMovieUpdateList(idx_u);
		List<Map> movieLists = playingMovieService.playingMovieAddMovie();
		List<Map> screenLists = playingMovieService.playingMovieAddScreen();
		
		ModelAndView mav = new ModelAndView();
		mav.addObject("updatedto", updatedto);
		mav.addObject("movieLists", movieLists);
		mav.addObject("screenLists", screenLists);
		mav.setViewName("admin/playMovie/playingMovieUpdate");
		return mav;
	}
	
	@RequestMapping(value = "admin/playMovie/playingMovieUpdate.do", method = RequestMethod.POST)
	public ModelAndView playingMovieUpdate (	
			@RequestParam("movie_idx")int movie_idx,
			@RequestParam("theater_idx")int theater_idx,
			@RequestParam("playing_movie_date")String playing_movie_date,
			@RequestParam("playing_movie_start")String playing_movie_start,
			@RequestParam("playing_movie_end")String playing_movie_end,
			@RequestParam("playing_movie_idx")int playing_movie_idx) {
		
		System.out.println("playing_movie_idx="+playing_movie_idx);
		
		PlayingMovieDTO dto = new PlayingMovieDTO(playing_movie_idx , movie_idx, theater_idx, playing_movie_date, playing_movie_start, playing_movie_end);
		int result = playingMovieService.playingMovieUpdate(dto);
		String msg = result>0?"수정에 성공했습니다.":"수정에 실패했습니다.";
		
		ModelAndView mav = new ModelAndView();
		mav.addObject("msg", msg);
		mav.addObject("href", "/amor/admin/playMovie/playingMovieList.do");
		mav.setViewName("admin/msg/adminMsg");
		return mav;
	}
	
	@RequestMapping("admin/playMovie/playingMovieDelete.do")
	public ModelAndView playingMovieDelete (
			@RequestParam("playing_movie_idx")int idx) {
		
		System.out.println("delete page");
		
		int result = playingMovieService.playingMovieDelete(idx);
		String msg = result>0?"삭제가 완료되었습니다.":"삭제에 실패했습니다.";
		
		ModelAndView mav = new ModelAndView();
		
		mav.addObject("msg", msg);
		mav.addObject("href","/amor/admin/playMovie/playingMovieList.do");
		mav.setViewName("admin/msg/adminMsg");
		return mav;
	}
	
	@RequestMapping("admin/playMovie/movieRunning.do")
	public String movieRunning (
			@RequestParam("movie_idx")int movie_idx) {
		
		System.out.println("movie_idx="+movie_idx);
		
		Map running = playingMovieService.movieRunning(movie_idx);
		String result = "{\"runningTime\",\""+running.get("MOVIE_RUNNINGTIME")+"\"}";
		System.out.println(result);
		return result;
	}
	
}
