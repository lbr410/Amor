package com.amor.movieReview.service;

import java.util.List;
import java.util.Map;

import org.apache.commons.collections.map.HashedMap;

import com.amor.movieReview.model.MovieReviewDAO;
import com.amor.movieReview.model.MovieReviewDTO;

public class MovieReviewServiceImple implements MovieReviewService {
	
	private MovieReviewDAO movieReviewDao;
	
	public MovieReviewServiceImple(MovieReviewDAO movieReviewDao) {
		super();
		this.movieReviewDao = movieReviewDao;
	}

	@Override
	public List<MovieReviewDTO> lists(int cp, int ls, int member_idx) {
		int start = (cp-1)*ls+1;
		int end = cp*ls;
		Map map = new HashedMap();
		map.put("start", start);
		map.put("end", end);
		map.put("member_idx", member_idx);
		List<MovieReviewDTO> lists=movieReviewDao.reviewList(map);
		return lists;
	}
	
	@Override
	public int getTotalCnt() {
		int count=movieReviewDao.getTotalCnt();
		return count;
	}

}
