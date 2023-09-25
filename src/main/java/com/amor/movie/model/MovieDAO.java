package com.amor.movie.model;
import java.util.*;

public interface MovieDAO {
	public int movieAdd(MovieDTO dto);
	public List<MovieDTO> movieList();
	public MovieDTO movieContent(int movie_idx);
}
