package com.amor.playingMovie.service;

import java.util.*;

import com.amor.playingMovie.model.*;

public interface PlayingMovieService {
	
	public List<PlayingMovieJoinDTO> playingMovieList(int cp, int ls);
	public int getTotalCnt();
	public List<Map> playingMovieAddScreen();
	public List<Map> playingMovieAddMovie();
	public int playingMovieSeat(int theater_idx);
	public int playingMovieAdd(PlayingMovieDTO dto);
	public PlayingMovieJoinDTO playingMovieUpdateList(int idx_u);
	public int playingMovieUpdate(PlayingMovieDTO dto);
	public int playingMovieDelete(int idx);
	public Map movieRunning(int idx_m);
	public List<PlayingMovieJoinDTO> playingMovieListSelect(int cp, int ls, int movie_idx);
	public int totalCntSelect(int movie_idx);
	
	public PlayingMovieDTO playingMovieContent(int playing_moive_idx);
}
