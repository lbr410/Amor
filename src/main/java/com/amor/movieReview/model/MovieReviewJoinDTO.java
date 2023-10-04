package com.amor.movieReview.model;

import java.sql.Date;

public class MovieReviewJoinDTO {

	private int movie_review_idx;
	private int movie_idx;
	private int ticketing_idx;
	private int member_idx;
	private int movie_review_star;
	private String movie_review_content;
	private String movie_review_shortcontent;
	private String movie_review_img;
	private Date ticketing_screeningtime;
	private Date movie_review_writedate;
	private String movie_name;
	
	public MovieReviewJoinDTO() {
		// TODO Auto-generated constructor stub
	}

	public MovieReviewJoinDTO(int movie_review_idx, int movie_idx, int ticketing_idx, int member_idx,
			int movie_review_star, String movie_review_content, String movie_review_shortcontent,
			String movie_review_img, Date ticketing_screeningtime, Date movie_review_writedate, String movie_name) {
		super();
		this.movie_review_idx = movie_review_idx;
		this.movie_idx = movie_idx;
		this.ticketing_idx = ticketing_idx;
		this.member_idx = member_idx;
		this.movie_review_star = movie_review_star;
		this.movie_review_content = movie_review_content;
		this.movie_review_shortcontent = movie_review_shortcontent;
		this.movie_review_img = movie_review_img;
		this.ticketing_screeningtime = ticketing_screeningtime;
		this.movie_review_writedate = movie_review_writedate;
		this.movie_name = movie_name;
	}

	public MovieReviewJoinDTO(int movie_idx, int ticketing_idx, int member_idx, int movie_review_star,
			String movie_review_content, String movie_review_img) {
		super();
		this.movie_idx = movie_idx;
		this.ticketing_idx = ticketing_idx;
		this.member_idx = member_idx;
		this.movie_review_star = movie_review_star;
		this.movie_review_content = movie_review_content;
		this.movie_review_img = movie_review_img;
	}

	public MovieReviewJoinDTO(int movie_review_idx, int movie_review_star, String movie_review_content,
			String movie_review_img) {
		super();
		this.movie_review_idx = movie_review_idx;
		this.movie_review_star = movie_review_star;
		this.movie_review_content = movie_review_content;
		this.movie_review_img = movie_review_img;
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

	public int getMovie_review_star() {
		return movie_review_star;
	}

	public void setMovie_review_star(int movie_review_star) {
		this.movie_review_star = movie_review_star;
	}

	public String getMovie_review_content() {
		return movie_review_content;
	}

	public void setMovie_review_content(String movie_review_content) {
		this.movie_review_content = movie_review_content;
	}

	public String getMovie_review_shortcontent() {
		return movie_review_shortcontent;
	}

	public void setMovie_review_shortcontent(String movie_review_shortcontent) {
		this.movie_review_shortcontent = movie_review_shortcontent;
	}

	public String getMovie_review_img() {
		return movie_review_img;
	}

	public void setMovie_review_img(String movie_review_img) {
		this.movie_review_img = movie_review_img;
	}

	public Date getTicketing_screeningtime() {
		return ticketing_screeningtime;
	}

	public void setTicketing_screeningtime(Date ticketing_screeningtime) {
		this.ticketing_screeningtime = ticketing_screeningtime;
	}

	public Date getMovie_review_writedate() {
		return movie_review_writedate;
	}

	public void setMovie_review_writedate(Date movie_review_writedate) {
		this.movie_review_writedate = movie_review_writedate;
	}

	public String getMovie_name() {
		return movie_name;
	}

	public void setMovie_name(String movie_name) {
		this.movie_name = movie_name;
	}
	
}
