package com.amor.movieReview.service;
import java.util.*;

import com.amor.movieReview.model.MovieReviewDTO;

public interface MovieReviewService {
	
	public List<MovieReviewDTO> lists(int cp, int ls, int member_idx);
	public int getTotalCnt();

}
