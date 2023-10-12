package com.amor.movie.model;
import java.util.*;

import com.amor.movieReview.model.MovieReviewDTO;

public interface MovieDAO {
	public int movieAdd(MovieDTO dto);
	public List<MovieDTO> movieList(Map map);
	public List<MovieDTO> movieListSearch(Map map);
	public MovieDTO movieContent(int movie_idx);
	public int movieUpdate(MovieDTO dto);
	public int movieDelete(int movie_idx);
	public int getTotalCnt();
	public int getTotalSearchCnt(String search);
	public int stateChange(MovieDTO dto);
	public List<MovieDTO> movieBest();
	public List<MovieDTO> movieBestReview();
	public int movieBestCnt();
	public List<MovieDTO> movieCome();
	public List<MovieDTO> movieName();
	public int movieComeCnt();
	public int getUserSearchTotalCnt(String userSearch);
	public List<MovieDTO> userMovieListSearch(Map map);
	public List<MovieReviewDTO> movieReviewInfo(Map map);
	public int movieReviewContentCnt(int movie_idx);
	public List<MovieDTO> indexMovieBest(Map map);
}
