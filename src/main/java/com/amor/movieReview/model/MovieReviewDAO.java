package com.amor.movieReview.model;

import java.util.*;

public interface MovieReviewDAO {

	public List<MovieReviewJoinDTO> reviewList(Map map);
	public int getTotalCnt();
}
