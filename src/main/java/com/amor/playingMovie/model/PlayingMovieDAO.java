package com.amor.playingMovie.model;

import java.util.*;

public interface PlayingMovieDAO {
	
	public List<PlayingMovieDTO> playingMovieList(Map map);
	public int getTotalCnt();
	public List<Map> playingMovieAddScreen();
	public List<Map> playingMovieAddMovie();
	public int playingMovieAdd(PlayingMovieDTO dto);
}
