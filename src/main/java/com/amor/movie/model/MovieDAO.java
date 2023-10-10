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
	public List<MovieDTO> movieBest(Map map);
	public List<MovieDTO> movieBestReview(Map map);
	public int movieBestCnt();
	public List<MovieDTO> movieCome(Map map);
	public List<MovieDTO> movieName(Map map);
	public int movieComeCnt();
	public int getUserSearchTotalCnt(String userSearch);
	public List<MovieDTO> userMovieListSearch(Map map);
	public List<MovieReviewDTO> movieReviewInfo(Map map);
	public int movieReviewContentCnt(int movie_idx);
}
