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
	public List<MovieDTO> movieList() {
		List<MovieDTO> lists = sqlmap.selectList("movieList");
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
}
