package com.amor.movieReview.service;
import java.util.*;

import com.amor.movieReview.model.MovieReviewDTO;
import com.amor.movieReview.model.MovieReviewJoinDTO;

public interface MovieReviewService {
	
	public List<MovieReviewJoinDTO> lists(int cp, int ls, int member_idx);
	public int getTotalCnt(int member_idx);
	public int reviewListTotalCnt();
	public List<MovieReviewDTO> adminReviewList(int cp, int listSize);
	public MovieReviewDTO adminReviewPopup(int idx);
	public int adminReviewBlockUpdate(int idx, String value);
	public int adminReviewListDelete(int idx);
	public int adminReviewListSearchTotalCnt(String search);
	public List<MovieReviewDTO> adminReviewListSearch(int cp, int listSize, String search);
	public int movieReviewAdd(MovieReviewJoinDTO dto);
	public int reviewListIdx(String member_id);
	public int reviewDelete(int movie_review_idx);
	public int reviewUpdate(MovieReviewJoinDTO dto);
	public int reviewTicketingState(int ticketing_idx);
	public int reviewTicketingDelState(int ticketing_idx);
	public int reviewTicketingIDX(int movie_review_idx);
}
