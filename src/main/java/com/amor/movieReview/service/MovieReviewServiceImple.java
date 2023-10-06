package com.amor.movieReview.service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.commons.collections.map.HashedMap;

import com.amor.movieReview.model.MovieReviewDAO;
import com.amor.movieReview.model.MovieReviewDTO;
import com.amor.movieReview.model.MovieReviewJoinDTO;

public class MovieReviewServiceImple implements MovieReviewService {
	
	private MovieReviewDAO movieReviewDao;
	
	public MovieReviewServiceImple(MovieReviewDAO movieReviewDao) {
		super();
		this.movieReviewDao = movieReviewDao;
	}

	@Override
	public List<MovieReviewJoinDTO> lists(int cp, int ls, int member_idx) {
		int start = (cp-1)*ls+1;
		int end = cp*ls;
		Map map = new HashedMap();
		map.put("start", start);
		map.put("end", end);
		map.put("member_idx", member_idx);
		List<MovieReviewJoinDTO> lists=movieReviewDao.reviewList(map);
		return lists;
	}
	
	@Override
	public int getTotalCnt(int member_idx) {
		int count=movieReviewDao.getTotalCnt(member_idx);
		return count;
	}
	
	@Override
	public int reviewListTotalCnt() {
		int result=movieReviewDao.reviewListTotalCnt();
		return result;
	}
	
	@Override
	public List<MovieReviewDTO> adminReviewList(int cp, int listSize) {
		int start=(cp-1) * listSize + 1;
		int end=cp * listSize;
		Map map=new HashMap();
		map.put("start", start);
		map.put("end", end);
		List<MovieReviewDTO> lists=movieReviewDao.adminReviewList(map);
		return lists;
	}
	
	@Override
	public MovieReviewDTO adminReviewPopup(int idx) {
		MovieReviewDTO dto=movieReviewDao.adminReviewPopup(idx);
		dto.setMovie_review_content(dto.getMovie_review_content().replaceAll("\n", "<br>"));
		return dto;
	}
	
	@Override
	public int adminReviewBlockUpdate(int idx, String value) {
		Map map=new HashMap();
		map.put("idx", idx);
		map.put("value", value);
		int result=movieReviewDao.adminReviewBlockUpdate(map);
		return result;
	}
	
	@Override
	public int adminReviewListDelete(int idx) {
		int result=movieReviewDao.adminReviewListDelete(idx);
		return result;
	}
	
	@Override
	public int adminReviewListSearchTotalCnt(String search) {
		int result=movieReviewDao.adminReviewListSearchTotalCnt(search);
		return result;
	}
	
	@Override
	public List<MovieReviewDTO> adminReviewListSearch(int cp, int listSize, String search) {
		int start=(cp-1) * listSize + 1;
		int end=cp * listSize;
		Map map=new HashMap();
		map.put("start", start);
		map.put("end", end);
		map.put("search", search);
		
		List<MovieReviewDTO> lists=movieReviewDao.adminReviewListSearch(map);
		return lists;
	}
	
	@Override
	public int movieReviewAdd(MovieReviewJoinDTO dto) {
		int result = movieReviewDao.movieReviewAdd(dto);
		return result;
	}
	
	@Override
	public int reviewListIdx(String member_id) {
		int member_idx = movieReviewDao.reviewListIdx(member_id);
		return member_idx;
	}
	
	@Override
	public int reviewDelete(int movie_review_idx) {
		int result = movieReviewDao.reviewDelete(movie_review_idx);
		return result;
	}
	
	@Override
	public int reviewUpdate(MovieReviewJoinDTO dto) {
		int result = movieReviewDao.reivewUpdate(dto);
		return result;
	}

	@Override
	public int reviewTicketingState(int ticketing_idx) {
		int result = movieReviewDao.reviewTicketingState(ticketing_idx);
		return result;
	}

	@Override
	public int reviewTicketingDelState(int ticketing_idx) {
		int result = movieReviewDao.reviewTicketingDelState(ticketing_idx);
		return result;
	}
}
