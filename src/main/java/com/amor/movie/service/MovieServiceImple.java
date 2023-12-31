package com.amor.movie.service;

import java.util.*;

import org.apache.commons.collections.map.HashedMap;

import com.amor.movie.model.*;
import com.amor.movieReview.model.MovieReviewDTO;

public class MovieServiceImple implements MovieService {

	private MovieDAO moviedao;

	public MovieServiceImple(MovieDAO moviedao) {
		super();
		this.moviedao = moviedao;
	}
	
	@Override
	public int movieAdd(MovieDTO dto) {
		int result = moviedao.movieAdd(dto);
		return result;
	}
	
	@Override
	public List<MovieDTO> movieList(int cp, int listSize) {
		int start=(cp-1)*listSize+1;
		int end=cp*listSize;
		Map map = new HashMap();
		map.put("start", start);
		map.put("end", end);
		List<MovieDTO> lists = moviedao.movieList(map);
		return lists;
	}
	
	@Override
	public List<MovieDTO> movieListSearch(int cp, int listSize, String search) {
		int start=(cp-1)*listSize+1;
		int end=cp*listSize;
		Map map = new HashMap();
		map.put("start", start);
		map.put("end", end);
		map.put("search",search);
		
		List<MovieDTO> lists = moviedao.movieListSearch(map);
		return lists;
	}
	
	@Override
	public MovieDTO movieContent(int movie_idx) {
		MovieDTO dto = moviedao.movieContent(movie_idx);
		return dto;
	}
	
	@Override
	public int movieUpdate(MovieDTO dto) {
		int result = moviedao.movieUpdate(dto);
		return result;
	}
	
	@Override
	public int movieDelete(int movie_idx) {
		int result = moviedao.movieDelete(movie_idx);
		return result;
	}

	@Override
	public int getTotalCnt() {
		int result = moviedao.getTotalCnt();
		return result;
	}
	
	@Override
	public int getTotalSearchCnt(String search) {
		int result = moviedao.getTotalSearchCnt(search);
		return result;
	}
	
	@Override
	public int stateChange(MovieDTO dto) {
		int result = moviedao.stateChange(dto);
		return result;
	}
	
	@Override
	public List<MovieDTO> movieBest() {
		List <MovieDTO> mlists = moviedao.movieBest();
		 for (MovieDTO movieDTO : mlists) {
			 	String originalTitle = movieDTO.getMovie_name();
		        String truncatedTitle = originalTitle.length() > 10 ? originalTitle.substring(0, 10) + "..." : originalTitle;
		        movieDTO.setTruncatedTitle(truncatedTitle);
		    }
		return mlists;
	}
	
	@Override
	public List<MovieDTO> movieBestReview() {
		List <MovieDTO> rlists = moviedao.movieBestReview();
		 for (MovieDTO movieDTO : rlists) {
			 	String originalTitle = movieDTO.getMovie_name();
		        String truncatedTitle = originalTitle.length() > 10 ? originalTitle.substring(0, 10) + "..." : originalTitle;
		        movieDTO.setTruncatedTitle(truncatedTitle);
		    }
		return rlists;
	}
	
	@Override
	public int movieBestCnt() {
		int result=moviedao.movieBestCnt();
		return result;
	}
	
	@Override
	public List<MovieDTO> movieCome() {
		List <MovieDTO> lists = moviedao.movieCome();
		 for (MovieDTO movieDTO : lists) {
		        String originalTitle = movieDTO.getMovie_name();
		        String truncatedTitle = originalTitle.length() > 10 ? originalTitle.substring(0, 10) + "..." : originalTitle;
		        movieDTO.setTruncatedTitle(truncatedTitle);
		    }
		return lists;
	}
	
	@Override
	public List<MovieDTO> movieName() {
		List <MovieDTO> lists = moviedao.movieName();
		 for (MovieDTO movieDTO : lists) {
			 	String originalTitle = movieDTO.getMovie_name();
		        String truncatedTitle = originalTitle.length() > 10 ? originalTitle.substring(0, 10) + "..." : originalTitle;
		        movieDTO.setTruncatedTitle(truncatedTitle);
		 }
		return lists;
	}
	
	@Override
	public int movieComeCnt() {
		int result=moviedao.movieComeCnt();
		return result;
	}
	
	@Override
	public int getUserSearchTotalCnt(String userSearch) {
		int result = moviedao.getUserSearchTotalCnt(userSearch);
		return result;
	}
	
	@Override
	public List<MovieDTO> userMovieSearch(String userSearch, int cp, int listSize) {
		int start=(cp-1)*listSize+1;
		int end=cp*listSize;
		Map<String,Object> map = new HashMap<String,Object>();
		map.put("start", start);
		map.put("end", end);
		map.put("search",userSearch);
		List<MovieDTO> lists = moviedao.userMovieListSearch(map);
		if(lists != null || lists.size() > 0) {
			return lists;
		}else {
			return null;
		}
	}
	
	@Override
	public List<MovieReviewDTO> movieReviewInfo(int movie_idx, int cp, int listSize) {
		int start=(cp-1)*listSize+1;
		int end=cp*listSize;
		Map map = new HashedMap();
		map.put("start", start);
		map.put("end", end);
		map.put("movie_idx", movie_idx);
		List<MovieReviewDTO> lists = moviedao.movieReviewInfo(map);
		
		return lists;
	}
	
	@Override
	public int movieReviewContentCnt(int movie_idx) {
		int cnt = moviedao.movieReviewContentCnt(movie_idx);
		return cnt;
	}
	
	@Override
	public List<MovieDTO> indexMovieBest() {
		Map map=new HashedMap();
		List <MovieDTO> mlists = moviedao.indexMovieBest(map);
		 for (MovieDTO movieDTO : mlists) {
			 	String originalTitle = movieDTO.getMovie_name();
		        String truncatedTitle = originalTitle.length() > 10 ? originalTitle.substring(0, 10) + "..." : originalTitle;
		        movieDTO.setTruncatedTitle(truncatedTitle);
		    }
		return mlists;
	}
}
