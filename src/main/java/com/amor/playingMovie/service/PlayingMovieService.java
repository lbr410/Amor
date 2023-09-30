package com.amor.playingMovie.service;

import java.util.*;

import com.amor.playingMovie.model.*;

public interface PlayingMovieService {
	
	public List<PlayingMovieJoinDTO> playingMovieList(int cp, int ls);
	public int getTotalCnt();
	public List<Map> playingMovieAddScreen();
	public List<Map> playingMovieAddMovie();
	public int playingMovieAdd(PlayingMovieDTO dto);
	public PlayingMovieJoinDTO playingMovieUpdateList(int idx_u);
	public int playingMovieUpdate(PlayingMovieDTO dto);
	public int playingMovieDelete(int idx);
	public Map movieRunning(int idx_m);
}
