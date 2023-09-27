package com.amor.movie.model;
import java.util.*;

public interface MovieDAO {
	public int movieAdd(MovieDTO dto);
	public List<MovieDTO> movieList(Map map);
	public List<MovieDTO> movieListSearch(Map map);
	public MovieDTO movieContent(int movie_idx);
	public int movieUpdate(MovieDTO dto);
	public int movieDelete(int movie_idx);
	public int getTotalCnt();
	public int stateChange(MovieDTO dto);
	public List<MovieDTO> movieBest(Map map);
	public List<MovieDTO> movieCome(Map map);
	
}
