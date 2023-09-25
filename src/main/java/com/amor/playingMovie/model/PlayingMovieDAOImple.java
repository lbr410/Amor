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
}
