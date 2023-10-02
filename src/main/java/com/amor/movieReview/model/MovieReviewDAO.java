package com.amor.movieReview.model;

import java.util.*;

public interface MovieReviewDAO {

	public List<MovieReviewJoinDTO> reviewList(Map map);
	public int getTotalCnt();
	public int reviewListTotalCnt();
	public List<MovieReviewDTO> adminReviewList(Map map);
	public MovieReviewDTO adminReviewPopup(int idx);
	public int adminReviewBlockUpdate(Map map);
	public int adminReviewListDelete(int idx);
	public int adminReviewListSearchTotalCnt(String search);
	public List<MovieReviewDTO> adminReviewListSearch(Map map);
}
