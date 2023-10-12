package com.amor.movie.model;

import java.util.*;

import org.mybatis.spring.SqlSessionTemplate;

import com.amor.movieReview.model.MovieReviewDTO;

public class MovieDAOImple implements MovieDAO {
	
	private SqlSessionTemplate sqlmap;
	
	public MovieDAOImple(SqlSessionTemplate sqlmap) {
		super();
		this.sqlmap = sqlmap;
	}

	@Override
	public int movieAdd(MovieDTO dto) {
		int result = sqlmap.insert("movieAdd",dto);
		return result;
	}
	
	@Override
	public List<MovieDTO> movieList(Map map) {
		List<MovieDTO> lists = sqlmap.selectList("movieList",map);
		return lists;
	}
	
	@Override
	public List<MovieDTO> movieListSearch(Map map) {
		List<MovieDTO> lists = sqlmap.selectList("movieListSearch",map);
		return lists;
	}
	
	@Override
	public MovieDTO movieContent(int movie_idx) {
		MovieDTO dto = sqlmap.selectOne("movieContent",movie_idx);
		return dto;
	}
	
	@Override
	public int movieUpdate(MovieDTO dto) {
		int result = sqlmap.update("movieUpdate",dto);
		return result;
	}
	
	@Override
	public int movieDelete(int movie_idx) {
		int result = sqlmap.delete("movieDelete", movie_idx);
		return result;
	}
	
	@Override
	public int getTotalCnt() {
		int result = sqlmap.selectOne("totalCnt");
		return result;
	}
	
	@Override
	public int getTotalSearchCnt(String search) {
		int result = sqlmap.selectOne("totalSearchCnt",search);
		return result;
	}
	
	@Override
	public int stateChange(MovieDTO dto) {
		int result = sqlmap.update("stateChange",dto);
		return result;
	}
	
	@Override
	public List<MovieDTO> movieBest() {
		List<MovieDTO> mlists = sqlmap.selectList("movieBest");
		return mlists;
	}
	
	@Override
	public List<MovieDTO> movieBestReview() {
		List<MovieDTO> rlists = sqlmap.selectList("movieBestReview");
		return rlists;
	}
	
	@Override
	public int movieBestCnt() {
		int result = sqlmap.selectOne("movieBestCnt");
		return 0;
	}
	@Override
	public List<MovieDTO> movieCome() {
		List<MovieDTO> lists = sqlmap.selectList("movieCome");
		return lists;
	}
	@Override
	public List<MovieDTO> movieName() {
		List<MovieDTO> lists = sqlmap.selectList("movieName");
		return lists;
	}
	@Override
	public int movieComeCnt() {
		int result = sqlmap.selectOne("movieComeCnt");
		return 0;
	}
	@Override
	public int getUserSearchTotalCnt(String userSearch) {
		int result = sqlmap.selectOne("userSearchTotalCnt", userSearch); 
		return result;
	}
	
	@Override
	public List<MovieDTO> userMovieListSearch(Map map) {
		List<MovieDTO> lists = sqlmap.selectList("userMovieListSearch", map);
		return lists;
	}
	
	@Override
	public List<MovieReviewDTO> movieReviewInfo(Map map) {
		List<MovieReviewDTO> lists = sqlmap.selectList("movieReviewInfo", map);
		return lists;
	}
	
	@Override
	public int movieReviewContentCnt(int movie_idx) {
		int cnt = sqlmap.selectOne("movieReviewContentCnt", movie_idx);
		return cnt;
	}
	
	@Override
	public List<MovieDTO> indexMovieBest(Map map) {
		List<MovieDTO> mlists = sqlmap.selectList("indexMovieBest", map);
		return mlists;
	}
}
