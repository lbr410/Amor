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
		System.out.println("DAOImple="+movieLists.get(0));
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
	
	@Override
	public PlayingMovieDTO playingMovieUpdateList(int idx_u) {
		PlayingMovieDTO updatedto = sqlmap.selectOne("playingMovieUpdateList", idx_u);
		return updatedto;
	}
	
	@Override
	public int playingMovieUpdate(PlayingMovieDTO dto) {
		int count = sqlmap.update("playingMovieUpdate", dto);
		return count;
	}
	
	@Override
	public int playingMovieDelete(int idx) {
		int count = sqlmap.delete("playingMovieDelete", idx);
		return count;
	}
	
	@Override
	public Map movieRunning(int idx_m) {
		Map running=sqlmap.selectOne("movieRunning", idx_m);
		return running;
	}
}
