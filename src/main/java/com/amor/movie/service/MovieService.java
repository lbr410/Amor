package com.amor.movie.service;

import com.amor.movie.model.*;
import java.util.*;

public interface MovieService {

	public int movieAdd(MovieDTO dto);
	
	public List<MovieDTO> movieList(int cp, int listSize);
	
	public MovieDTO movieContent(int movie_idx);
	
	public int movieUpdate(MovieDTO dto);
	
	public int movieDelete(int movie_idx);
	
	public int getTotalCnt();
	
	public List<MovieDTO> movieListSearch(int cp, int listSize, String search);
	
	public int stateChange(MovieDTO dto);
	
	public List<MovieDTO> movieBest(int cp, int listSize);
	
	public List<MovieDTO> movieCome();
	
	
}
