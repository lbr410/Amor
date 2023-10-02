package com.amor.movie.model;

import java.util.*;

import org.mybatis.spring.SqlSessionTemplate;

public class MovieDAOImple implements MovieDAO {
	
	private SqlSessionTemplate sqlmap;
	
	public MovieDAOImple(SqlSessionTemplate sqlmap) {
		super();
		this.sqlmap = sqlmap;
	}

	@Override
	public int movieAdd(MovieDTO dto) {
		int result = sqlmap.insert("movieAdd",dto);
		return result;
	}
	
	@Override
	public List<MovieDTO> movieList(Map map) {
		List<MovieDTO> lists = sqlmap.selectList("movieList",map);
		return lists;
	}
	
	@Override
	public List<MovieDTO> movieListSearch(Map map) {
		List<MovieDTO> lists = sqlmap.selectList("movieListSearch",map);
		return lists;
	}
	
	@Override
	public MovieDTO movieContent(int movie_idx) {
		MovieDTO dto = sqlmap.selectOne("movieContent",movie_idx);
		return dto;
	}
	
	@Override
	public int movieUpdate(MovieDTO dto) {
		int result = sqlmap.update("movieUpdate",dto);
		return result;
	}
	
	@Override
	public int movieDelete(int movie_idx) {
		int result = sqlmap.delete("movieDelete", movie_idx);
		return result;
	}
	
	@Override
	public int getTotalCnt() {
		int result = sqlmap.selectOne("totalCnt");
		return result;
	}
	
	@Override
	public int stateChange(MovieDTO dto) {
		int result = sqlmap.update("stateChange",dto);
		return result;
	}
	
	@Override
	public List<MovieDTO> movieBest(Map map) {
		List<MovieDTO> lists = sqlmap.selectList("movieBest", map);
		return lists;
	}
	
	@Override
	public List<MovieDTO> movieCome(Map map) {
		List<MovieDTO> lists = sqlmap.selectList("movieCome", map);
		return lists;
	}
	
	@Override
	public int getUserSearchTotalCnt(String userSearch) {
		int result = sqlmap.selectOne("userSearchTotalCnt", userSearch); 
		return result;
	}
	
	@Override
	public List<MovieDTO> userMovieListSearch(Map map) {
		List<MovieDTO> lists = sqlmap.selectList("movieListSearch", map);
		return lists;
	}
	
	
}
