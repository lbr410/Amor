package com.amor.movie.service;

import java.util.List;

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
	public List<MovieDTO> movieList() {
		List<MovieDTO> lists = moviedao.movieList();
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


	
	
}
