package com.amor.playingMovie.service;

import java.util.*;

import org.apache.commons.collections.map.HashedMap;

import com.amor.playingMovie.model.PlayingMovieDAO;
import com.amor.playingMovie.model.PlayingMovieDTO;

public class PlayingMovieServiceImple implements PlayingMovieService {
	
	private PlayingMovieDAO playingMovieDao;
	
	public PlayingMovieServiceImple(PlayingMovieDAO playingMovieDao) {
		super();
		this.playingMovieDao = playingMovieDao;
	}

	@Override
	public List<PlayingMovieDTO> playingMovieList(int cp, int ls) {
		int start=(cp-1)*ls+1;
		int end=cp*ls;
		Map map=new HashedMap();
		map.put("start", start);
		map.put("end", end);
		List<PlayingMovieDTO> lists=playingMovieDao.playingMovieList(map);
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
}




