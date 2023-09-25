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
	public List<MovieReviewDTO> reviewList(Map map) {
		List<MovieReviewDTO> lists=sqlmap.selectList("playingMovieList", map);
		return lists;
	}
	
	@Override
	public int getTotalCnt() {
		int count=sqlmap.selectOne("totalCntReview");
		return count;
	}

}
