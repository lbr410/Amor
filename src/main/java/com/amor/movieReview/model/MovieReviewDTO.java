package com.amor.movieReview.model;
import java.sql.*;

public class MovieReviewDTO {
	
	private int movie_review_idx;
	private int movie_idx;
	private int ticketing_idx;
	private int member_idx;
	private int moview_review_star;
	private String moview_review_content;
	private String moview_review_img;
	private Date ticketing_screeningtime;
	private String movie_name;
	
	public MovieReviewDTO() {
		// TODO Auto-generated constructor stub
	}

	public MovieReviewDTO(int movie_review_idx, int movie_idx, int ticketing_idx, int member_idx,
			int moview_review_star, String moview_review_content, String moview_review_img,
			Date ticketing_screeningtime, String movie_name) {
		super();
		this.movie_review_idx = movie_review_idx;
		this.movie_idx = movie_idx;
		this.ticketing_idx = ticketing_idx;
		this.member_idx = member_idx;
		this.moview_review_star = moview_review_star;
		this.moview_review_content = moview_review_content;
		this.moview_review_img = moview_review_img;
		this.ticketing_screeningtime = ticketing_screeningtime;
		this.movie_name = movie_name;
	}

	public MovieReviewDTO(String moview_review_content, String moview_review_img, Date ticketing_screeningtime,
			String movie_name) {
		super();
		this.moview_review_content = moview_review_content;
		this.moview_review_img = moview_review_img;
		this.ticketing_screeningtime = ticketing_screeningtime;
		this.movie_name = movie_name;
	}

	public int getMovie_review_idx() {
		return movie_review_idx;
	}

	public void setMovie_review_idx(int movie_review_idx) {
		this.movie_review_idx = movie_review_idx;
	}

	public int getMovie_idx() {
		return movie_idx;
	}

	public void setMovie_idx(int movie_idx) {
		this.movie_idx = movie_idx;
	}

	public int getTicketing_idx() {
		return ticketing_idx;
	}

	public void setTicketing_idx(int ticketing_idx) {
		this.ticketing_idx = ticketing_idx;
	}

	public int getMember_idx() {
		return member_idx;
	}

	public void setMember_idx(int member_idx) {
		this.member_idx = member_idx;
	}

	public int getMoview_review_star() {
		return moview_review_star;
	}

	public void setMoview_review_star(int moview_review_star) {
		this.moview_review_star = moview_review_star;
	}

	public String getMoview_review_content() {
		return moview_review_content;
	}

	public void setMoview_review_content(String moview_review_content) {
		this.moview_review_content = moview_review_content;
	}

	public String getMoview_review_img() {
		return moview_review_img;
	}

	public void setMoview_review_img(String moview_review_img) {
		this.moview_review_img = moview_review_img;
	}

	public Date getTicketing_screeningtime() {
		return ticketing_screeningtime;
	}

	public void setTicketing_screeningtime(Date ticketing_screeningtime) {
		this.ticketing_screeningtime = ticketing_screeningtime;
	}

	public String getMovie_name() {
		return movie_name;
	}

	public void setMovie_name(String movie_name) {
		this.movie_name = movie_name;
	}
	
	
	
	
	

}
