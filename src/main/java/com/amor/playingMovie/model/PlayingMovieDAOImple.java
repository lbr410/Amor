package com.amor.playingMovie.model;

import java.util.*;

import org.mybatis.spring.SqlSessionTemplate;

public class PlayingMovieDAOImple implements PlayingMovieDAO {

	private SqlSessionTemplate sqlmap;
	
	public PlayingMovieDAOImple(SqlSessionTemplate sqlmap) {
		super();
		this.sqlmap = sqlmap;
	}

	@Override
	public List<PlayingMovieDTO> playingMovieList(Map map) {
		List<PlayingMovieDTO> lists=sqlmap.selectList("playingMovieList", map);
		return lists;
	}
	
	@Override
	public int getTotalCnt() {
		int count=sqlmap.selectOne("totalCntPlaying");
		return count;
	}
	
	@Override
	public List<Map> playingMovieAddMovie() {
		List<Map> movieLists=sqlmap.selectList("playingMovieAddMovie");
		return movieLists;
	}
	
	@Override
	public List<Map> playingMovieAddScreen() {
		List<Map> screenLists=sqlmap.selectList("playingMovieAddScreen");
		return screenLists;
	}
	
	@Override
	public int playingMovieAdd(PlayingMovieDTO dto) {
		int count = sqlmap.insert("playingMovieAdd", dto);
		return count;
	}
}
