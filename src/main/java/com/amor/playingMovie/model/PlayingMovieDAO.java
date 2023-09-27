package com.amor.playingMovie.model;

import java.util.*;

public interface PlayingMovieDAO {
	
	public List<PlayingMovieDTO> playingMovieList(Map map);
	public int getTotalCnt();
	public List<Map> playingMovieAddScreen();
	public List<Map> playingMovieAddMovie();
	public int playingMovieAdd(PlayingMovieDTO dto);
	public PlayingMovieDTO playingMovieUpdateList(int idx_u);
	public int playingMovieUpdate(PlayingMovieDTO dto);
	public int playingMovieDelete(int idx);
	public Map movieRunning(int idx_m);
}
