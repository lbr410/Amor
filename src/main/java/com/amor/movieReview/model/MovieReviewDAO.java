package com.amor.movieReview.model;

import java.util.*;

public interface MovieReviewDAO {

	public List<MovieReviewDTO> reviewList(Map map);
	public int getTotalCnt();
}
