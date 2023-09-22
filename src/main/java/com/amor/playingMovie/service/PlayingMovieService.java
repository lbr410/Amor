package com.amor.playingMovie.service;

import java.util.*;

import com.amor.playingMovie.model.*;

public interface PlayingMovieService {
	
	public List<PlayingMovieDTO> playingMovieList(int cp, int ls);
	public int getTotalCnt();

}
