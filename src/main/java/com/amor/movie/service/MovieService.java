package com.amor.movie.service;

import com.amor.movie.model.*;
import java.util.*;

public interface MovieService {

	public int movieAdd(MovieDTO dto);
	
	public List<MovieDTO> movieList();
	
	public MovieDTO movieContent(int movie_idx);
	
}
