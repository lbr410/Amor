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
	
}




