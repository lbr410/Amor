package com.amor.movieReview.model;
import java.sql.*;

public class MovieReviewDTO {
	
	private int movie_review_idx;
	private int movie_idx;
	private int ticketing_idx;
	private int member_idx;
	private int movie_review_star;
	private String movie_review_content;
	private String movie_review_img;
	private Date movie_review_writedate;
	private Date ticketing_screeningtime;
	private String movie_name;
	private String member_id;
	private String member_block;
	
	public MovieReviewDTO() {
		// TODO Auto-generated constructor stub
	}
	

	public MovieReviewDTO(int movie_review_idx, int movie_idx, int ticketing_idx, int member_idx, int movie_review_star,
			String movie_review_content, String movie_review_img, Date movie_review_writedate,
			Date ticketing_screeningtime, String movie_name, String member_id, String member_block) {
		super();
		this.movie_review_idx = movie_review_idx;
		this.movie_idx = movie_idx;
		this.ticketing_idx = ticketing_idx;
		this.member_idx = member_idx;
		this.movie_review_star = movie_review_star;
		this.movie_review_content = movie_review_content;
		this.movie_review_img = movie_review_img;
		this.movie_review_writedate = movie_review_writedate;
		this.ticketing_screeningtime = ticketing_screeningtime;
		this.movie_name = movie_name;
		this.member_id = member_id;
		this.member_block = member_block;
	}


	public MovieReviewDTO(String movie_review_content, String movie_review_img, Date ticketing_screeningtime,
			String movie_name) {
		super();
		this.movie_review_content = movie_review_content;
		this.movie_review_img = movie_review_img;
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

	public String getMovie_review_img() {
		return movie_review_img;
	}

	public void setMovie_review_img(String movie_review_img) {
		this.movie_review_img = movie_review_img;
	}

	public Date getMovie_review_writedate() {
		return movie_review_writedate;
	}

	public void setMovie_review_writedate(Date movie_review_writedate) {
		this.movie_review_writedate = movie_review_writedate;
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

	public String getMember_id() {
		return member_id;
	}

	public void setMember_id(String member_id) {
		this.member_id = member_id;
	}

	public String getMember_block() {
		return member_block;
	}

	public void setMember_block(String member_block) {
		this.member_block = member_block;
	}

	
}
