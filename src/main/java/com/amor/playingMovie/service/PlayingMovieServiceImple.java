package com.amor.playingMovie.service;

import java.util.*;

import org.apache.commons.collections.map.HashedMap;

import com.amor.playingMovie.model.PlayingMovieDAO;
import com.amor.playingMovie.model.PlayingMovieDTO;
import com.amor.playingMovie.model.PlayingMovieJoinDTO;

public class PlayingMovieServiceImple implements PlayingMovieService {
	
	private PlayingMovieDAO playingMovieDao;
	
	public PlayingMovieServiceImple(PlayingMovieDAO playingMovieDao) {
		super();
		this.playingMovieDao = playingMovieDao;
	}

	@Override
	public List<PlayingMovieJoinDTO> playingMovieList(int cp, int ls) {
		int start=(cp-1)*ls+1;
		int end=cp*ls;
		Map map=new HashedMap();
		map.put("start", start);
		map.put("end", end);
		List<PlayingMovieJoinDTO> lists=playingMovieDao.playingMovieList(map);
		return lists;
	}
	
	@Override
	public int getTotalCnt() {
		int count=playingMovieDao.getTotalCnt();
		return count;
	}
	
	@Override
	public List<Map> playingMovieAddMovie() {
		List<Map> movieLists=playingMovieDao.playingMovieAddMovie(); 
		return movieLists;
	}
	
	@Override
	public List<Map> playingMovieAddScreen() {
		List<Map> screenLists=playingMovieDao.playingMovieAddScreen();
		return screenLists;
	}
	
	@Override
	public int playingMovieSeat(int theater_idx) {
		int seat = playingMovieDao.playingMovieSeat(theater_idx);
		return seat;
	}

	@Override
	public int playingMovieAdd(PlayingMovieDTO dto) {
		int result = playingMovieDao.playingMovieAdd(dto);
		return result;
	}
	
	@Override
	public PlayingMovieJoinDTO playingMovieUpdateList(int idx_u) {
		PlayingMovieJoinDTO updatedto=playingMovieDao.playingMovieUpdateList(idx_u);
		return updatedto;
	}
	
	@Override
	public int playingMovieUpdate(PlayingMovieDTO dto) {
		int result = playingMovieDao.playingMovieUpdate(dto);
		return result;
	}
	
	@Override
	public int playingMovieDelete(int idx) {
		int result = playingMovieDao.playingMovieDelete(idx);
		return result;
	}
	
	@Override
	public Map movieRunning(int idx_m) {
		Map running = playingMovieDao.movieRunning(idx_m);
		return running;
	}
	
	
	@Override
	public PlayingMovieDTO playingMovieContent(int playing_moive_idx) {
		PlayingMovieDTO dto = playingMovieDao.playingMovieContent(playing_moive_idx);
		return dto;
	}
	
	@Override
	public List<PlayingMovieJoinDTO> playingMovieListSelect(int cp, int ls, int movie_idx) {
		int start=(cp-1)*ls+1;
		int end=cp*ls;
		Map map=new HashedMap();
		map.put("start", start);
		map.put("end", end);
		map.put("movie_idx", movie_idx);
		List<PlayingMovieJoinDTO> lists = playingMovieDao.playingMovieListSelect(map);
		return lists;
	}
	
	@Override
	public int totalCntSelect(int movie_idx) {
		int count = playingMovieDao.totalCntSelect(movie_idx);
		return count;
	}
	
	@Override
	public int playingTicketingCnt(int playing_movie_idx) {
		int count = playingMovieDao.playingTicketingCnt(playing_movie_idx);
		return count;
	}
	
	@Override
	public int playingTicketingUpdate(int theater_idx, String ticketing_screeningtime, int playing_movie_idx) {
		Map map = new HashMap();
		map.put("theater_idx", theater_idx);
		map.put("ticketing_screeningtime", ticketing_screeningtime);
		map.put("playing_movie_idx", playing_movie_idx);
		int count = playingMovieDao.playingTicketingUpdate(map);
		return count;
	}
	
}




