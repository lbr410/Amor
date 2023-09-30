package com.amor.movieReview.service;
import java.util.*;

import com.amor.movieReview.model.MovieReviewDTO;
import com.amor.movieReview.model.MovieReviewJoinDTO;

public interface MovieReviewService {
	
	public List<MovieReviewJoinDTO> lists(int cp, int ls, int member_idx);
	public int getTotalCnt();

}
