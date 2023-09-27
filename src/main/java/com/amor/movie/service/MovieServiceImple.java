package com.amor.movie.service;

import java.util.*;

import org.apache.commons.collections.map.HashedMap;

import com.amor.movie.model.*;

public class MovieServiceImple implements MovieService {

	private MovieDAO moviedao;

	public MovieServiceImple(MovieDAO moviedao) {
		super();
		this.moviedao = moviedao;
	}
	
	@Override
	public int movieAdd(MovieDTO dto) {
		int result = moviedao.movieAdd(dto);
		return result;
	}
	
	@Override
	public List<MovieDTO> movieList(int cp, int listSize) {
		int start=(cp-1)*listSize+1;
		int end=cp*listSize;
		Map map = new HashMap();
		map.put("start", start);
		map.put("end", end);
		List<MovieDTO> lists = moviedao.movieList(map);
		return lists;
	}
	
	@Override
	public List<MovieDTO> movieListSearch(int cp, int listSize, String search) {
		int start=(cp-1)*listSize+1;
		int end=cp*listSize;
		Map map = new HashMap();
		map.put("start", start);
		map.put("end", end);
		map.put("search",search);
		
		List<MovieDTO> lists = moviedao.movieListSearch(map);
		return lists;
	}
	
	@Override
	public MovieDTO movieContent(int movie_idx) {
		MovieDTO dto = moviedao.movieContent(movie_idx);
		return dto;
	}
	
	@Override
	public int movieUpdate(MovieDTO dto) {
		int result = moviedao.movieUpdate(dto);
		return result;
	}
	
	@Override
	public int movieDelete(int movie_idx) {
		int result = moviedao.movieDelete(movie_idx);
		return result;
	}

	@Override
	public int getTotalCnt() {
		int result = moviedao.getTotalCnt();
		return result;
	}
	
	@Override
	public int stateChange(MovieDTO dto) {
		int result = moviedao.stateChange(dto);
		return result;
	}
	
	@Override
	public List<MovieDTO> movieBest() {
		Map map=new HashedMap();
		List <MovieDTO> lists = moviedao.movieBest(map);
		System.out.println(lists);
		return lists;
	}
	
	@Override
	public List<MovieDTO> movieCome() {
		Map map=new HashedMap();
		List <MovieDTO> lists = moviedao.movieCome(map);
		System.out.println(lists);
		return lists;
	}
	
}
