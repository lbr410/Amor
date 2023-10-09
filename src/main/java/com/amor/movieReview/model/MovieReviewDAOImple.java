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
		List<MovieReviewJoinDTO> lists=sqlmap.selectList("reviewList", map);
		return lists;
	}
	
	@Override
	public int getTotalCnt(int member_idx) {
		int count=sqlmap.selectOne("totalCntReview", member_idx);
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
		int result=sqlmap.update("reviewListBlock", map);
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
	
	@Override
	public int movieReviewAdd(MovieReviewJoinDTO dto) {
		int result = sqlmap.insert("movieReviewAdd",dto);
		return result;
	}
	
	@Override
	public int reviewListIdx(String member_id) {
		int member_idx = sqlmap.selectOne("reviewListIdx", member_id);
		return member_idx;
	}
	
	@Override
	public int reviewDelete(int movie_review_idx) {
		int result = sqlmap.delete("reviewDelete", movie_review_idx);
		return result;
	}
	
	@Override
	public int reivewUpdate(MovieReviewJoinDTO dto) {
		int result = sqlmap.update("reviewUpdate", dto);
		return result;
	}
	
	@Override
	public int reviewTicketingState(int ticketing_idx) {
		int result = sqlmap.update("reviewTicketingState", ticketing_idx);
		return result;
	}
	
	@Override
	public int reviewTicketingDelState(int ticketing_idx) {
		int result = sqlmap.update("reviewTicketingDelState", ticketing_idx);
		return result;
	}
	
	@Override
	public int reviewTicketingIDX(int movie_review_idx) {
		int ticketing_idx = sqlmap.selectOne("reviewTicketingIDX", movie_review_idx);
		return ticketing_idx;
	}
}
