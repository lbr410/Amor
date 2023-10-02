package com.amor.movieReview.model;

import java.util.*;

import org.mybatis.spring.SqlSessionTemplate;

public class MovieReviewDAOImple implements MovieReviewDAO {
	
	private SqlSessionTemplate sqlmap;
		
	public MovieReviewDAOImple(SqlSessionTemplate sqlmap) {
		super();
		this.sqlmap = sqlmap;
	}

	@Override
	public List<MovieReviewJoinDTO> reviewList(Map map) {
		List<MovieReviewJoinDTO> lists=sqlmap.selectList("playingMovieList", map);
		return lists;
	}
	
	@Override
	public int getTotalCnt() {
		int count=sqlmap.selectOne("totalCntReview");
		return count;
	}
	
	@Override
	public int reviewListTotalCnt() {
		int result=sqlmap.selectOne("reviewListTotalCnt");
		return result;
	}
	
	@Override
	public List<MovieReviewDTO> adminReviewList(Map map) {
		List<MovieReviewDTO> lists=sqlmap.selectList("adminReviewList", map);
		return lists;
	}
	
	@Override
	public MovieReviewDTO adminReviewPopup(int idx) {
		MovieReviewDTO dto=sqlmap.selectOne("adminReviewPopup", idx);
		return dto;
	}
	
	@Override
	public int adminReviewBlockUpdate(Map map) {
		int result=sqlmap.update("blockUpdate", map);
		return result;
	}
	
	@Override
	public int adminReviewListDelete(int idx) {
		int result=sqlmap.delete("adminReviewListDelete", idx);
		return result;
	}
	@Override
	public int adminReviewListSearchTotalCnt(String search) {
		int result=sqlmap.selectOne("adminReviewSearch", search);
		return result;
	}
	
	@Override
	public List<MovieReviewDTO> adminReviewListSearch(Map map) {
		List<MovieReviewDTO>lists=sqlmap.selectList("adminReviewListSearch", map);
		return lists;
	}
}
