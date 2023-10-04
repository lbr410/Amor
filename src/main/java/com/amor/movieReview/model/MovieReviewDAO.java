package com.amor.movieReview.model;

import java.util.*;

public interface MovieReviewDAO {

	public List<MovieReviewJoinDTO> reviewList(Map map);
	public int getTotalCnt(int member_idx);
	public int reviewListTotalCnt();
	public List<MovieReviewDTO> adminReviewList(Map map);
	public MovieReviewDTO adminReviewPopup(int idx);
	public int adminReviewBlockUpdate(Map map);
	public int adminReviewListDelete(int idx);
	public int adminReviewListSearchTotalCnt(String search);
	public List<MovieReviewDTO> adminReviewListSearch(Map map);
	public int movieReviewAdd(MovieReviewJoinDTO dto);
	public int reviewListIdx(String member_id);
	public int reviewDelete(int movie_review_idx);
	public int reivewUpdate(MovieReviewJoinDTO dto);
}
