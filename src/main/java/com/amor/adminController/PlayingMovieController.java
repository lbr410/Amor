	package com.amor.adminController;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.CookieValue;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import java.sql.Date;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;

import javax.servlet.http.HttpSession;

import com.amor.playingMovie.model.*;
import com.amor.playingMovie.service.PlayingMovieService;

@Controller
public class PlayingMovieController {
	
	@Autowired
	private PlayingMovieService playingMovieService;

	
	@RequestMapping("admin/playMovie/playingMovieList.do")
	public ModelAndView playingMovieList(
			@CookieValue(value = "autologin", required = false) String autologin,
			HttpSession session) {
		
		List<Map> movieList = playingMovieService.playingMovieAddMovie();
		ModelAndView mav = new ModelAndView();
		
		if (session.getAttribute("data")==null && autologin == null) {
			mav.addObject("msg", "로그인 후 이용가능합니다.");
			mav.addObject("href", "/amor/admin/adminLogin.do");
			mav.setViewName("/admin/msg/adminMsg");	
		} else {
			mav.addObject("movieList", movieList);
			mav.setViewName("/admin/playMovie/playingMovieList");
		}
		return mav;
	}
	
	@RequestMapping("admin/playMovie/playingMovieList2.do")
	public ModelAndView playingMovieList(
			@RequestParam(value = "cp", defaultValue = "1") int cp,
			@CookieValue(value = "autologin", required = false) String autologin,
			@RequestParam(value = "movie_idx", required = false) String movie_idx,
			HttpSession session) {
		
		ModelAndView mav = new ModelAndView();
		
		if (movie_idx == null || movie_idx.equals("aa")) {
			
			int totalCnt=playingMovieService.getTotalCnt();
			int listSize=10;
			int pageSize=5;
		
			List<PlayingMovieJoinDTO> lists=playingMovieService.playingMovieList(cp, listSize);
			
			String playingMoviepageStr=com.amor.page.PageModuleAjax.makePage(totalCnt, listSize, pageSize, cp);
			
			if (session.getAttribute("data")==null && autologin == null) {
				mav.addObject("msg", "로그인 후 이용가능합니다.");
				mav.addObject("href", "/amor/admin/adminLogin.do");
				mav.setViewName("/admin/msg/adminMsg");	
			} else {
				mav.addObject("playingMoviepageStr", playingMoviepageStr);
				mav.addObject("lists", lists);
				mav.setViewName("amorJson");
			}
			
		} else {
			
			int movie_idx2 = Integer.parseInt(movie_idx);
			
			int totalCnt=playingMovieService.totalCntSelect(movie_idx2);
			int listSize=10;
			int pageSize=5;
			
			List<PlayingMovieJoinDTO> lists = playingMovieService.playingMovieListSelect(cp, listSize, movie_idx2);
			
			String playingMoviepageStr=com.amor.page.PageModuleAjax.makePage(totalCnt, listSize, pageSize, cp);
			
			mav.addObject("playingMoviepageStr", playingMoviepageStr);
			mav.addObject("lists", lists);
			mav.setViewName("amorJson");
		}
	
		return mav;
		
	}
	

	@RequestMapping(value = "admin/playMovie/playingMovieAdd.do", method = RequestMethod.GET)
	public ModelAndView playingMoiveAddList (
			@CookieValue(value = "autologin", required = false) String autologin,
			HttpSession session
			) {
		
		List<Map> movieLists = playingMovieService.playingMovieAddMovie();
		List<Map> screenLists = playingMovieService.playingMovieAddScreen();
		
		ModelAndView mav = new ModelAndView();
		
		if (session.getAttribute("data")==null && autologin == null) {
			mav.addObject("msg", "로그인 후 이용가능합니다.");
			mav.addObject("href", "/amor/admin/adminLogin.do");
			mav.setViewName("/admin/msg/adminMsg");	
		} else {
			mav.addObject("movieLists", movieLists);
			mav.addObject("screenLists", screenLists);
			mav.setViewName("/admin/playMovie/playingMovieAdd");
		}
		return mav;
	}
	
	@RequestMapping(value = "admin/playMovie/playingMovieAdd.do", method = RequestMethod.POST)
	public ModelAndView playingMovieAdd (
			@RequestParam("movie_idx")int movie_idx,
			@RequestParam("theater_idx")int theater_idx,
			@RequestParam("playing_movie_date")String playing_movie_date,
			@RequestParam("playing_movie_start")String playing_movie_start_s,
			@RequestParam("playing_movie_end")String playing_movie_end_e
			) {
		
		String playing_movie_start = playing_movie_date+" "+playing_movie_start_s;
		String playing_movie_end = playing_movie_date+" "+playing_movie_end_e;
		
		int theater_totalseat = playingMovieService.playingMovieSeat(theater_idx);
		
		PlayingMovieDTO dto = new PlayingMovieDTO(movie_idx, theater_idx, playing_movie_date, playing_movie_start, playing_movie_end, theater_totalseat);
		
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
			@RequestParam("playing_movie_idx")int idx_u,
			@CookieValue(value = "autologin", required = false) String autologin,
			HttpSession session) {
		
		PlayingMovieJoinDTO updatedto=playingMovieService.playingMovieUpdateList(idx_u);
		List<Map> movieLists = playingMovieService.playingMovieAddMovie();
		List<Map> screenLists = playingMovieService.playingMovieAddScreen();
		
		ModelAndView mav = new ModelAndView();
		
		if (session.getAttribute("data")==null && autologin == null) {
			mav.addObject("msg", "로그인 후 이용가능합니다.");
			mav.addObject("href", "/amor/admin/adminLogin.do");
			mav.setViewName("/admin/msg/adminMsg");	
		} else {
			mav.addObject("updatedto", updatedto);
			mav.addObject("movieLists", movieLists);
			mav.addObject("screenLists", screenLists);
			mav.setViewName("admin/playMovie/playingMovieUpdate");
		}
		return mav;
	}
	
	@RequestMapping(value = "admin/playMovie/playingMovieUpdate.do", method = RequestMethod.POST)
	public ModelAndView playingMovieUpdate (	
			@RequestParam("movie_idx")int movie_idx,
			@RequestParam("theater_idx")int theater_idx,
			@RequestParam("playing_movie_date")String playing_movie_date,
			@RequestParam("playing_movie_start")String playing_movie_start_s,
			@RequestParam("playing_movie_end")String playing_movie_end_e,
			@RequestParam("playing_movie_idx")int playing_movie_idx) {
		
		String playing_movie_start = playing_movie_date+" "+playing_movie_start_s;
		String playing_movie_end = playing_movie_date+" "+playing_movie_end_e;
		
		System.out.println(playing_movie_start);
		System.out.println(playing_movie_idx);
		System.out.println(theater_idx);
		System.out.println(movie_idx);
		
		PlayingMovieDTO dto = new PlayingMovieDTO(playing_movie_idx , movie_idx, theater_idx, playing_movie_date, playing_movie_start, playing_movie_end);
		
		int result3 = playingMovieService.playingTicketingCnt(playing_movie_idx);

		String msg = null;
		if (result3 == 0) {
			int result1 = playingMovieService.playingMovieUpdate(dto);
			
			msg = result1>0?"수정에 성공했습니다.":"수정에 실패했습니다.";
			
		} else {
			int result1 = playingMovieService.playingMovieUpdate(dto);
			int result2 = playingMovieService.playingTicketingUpdate(theater_idx, playing_movie_start, playing_movie_idx);
			int result = result1+result2;
			
			msg = result>1?"수정에 성공했습니다.":"수정에 실패했습니다.";
		}
		
		ModelAndView mav = new ModelAndView();
		mav.addObject("msg", msg);
		mav.addObject("href", "/amor/admin/playMovie/playingMovieList.do");
		mav.setViewName("admin/msg/adminMsg");
		return mav;
	}
	
	@RequestMapping("admin/playMovie/playingMovieDelete.do")
	public ModelAndView playingMovieDelete (
			@RequestParam("playing_movie_idx")int idx) {
		
		int result = playingMovieService.playingMovieDelete(idx);
		String msg = result>0?"삭제가 완료되었습니다.":"삭제에 실패했습니다.";
		
		ModelAndView mav = new ModelAndView();
		
		mav.addObject("msg", msg);
		mav.addObject("href","/amor/admin/playMovie/playingMovieList.do");
		mav.setViewName("admin/msg/adminMsg");
		return mav;
	}
	
	@RequestMapping("admin/playMovie/movieRunning.do")
	public ModelAndView movieRunning (
			@RequestParam("movie_idx")int movie_idx
			) {
		
		Map running = playingMovieService.movieRunning(movie_idx);
		
		ModelAndView mav = new ModelAndView();
		mav.addObject("running", running);
		mav.setViewName("amorJson");
		return mav;
	}
}
