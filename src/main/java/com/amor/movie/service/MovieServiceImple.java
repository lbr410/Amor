package com.amor.movie.service;

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
	
	
}
