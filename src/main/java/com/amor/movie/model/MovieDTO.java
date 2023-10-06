package com.amor.movie.model;

import java.sql.*;

public class MovieDTO {

	private int movie_idx;
	private String movie_name;
	private String movie_genre;
	private String movie_god;
	private String movie_actor;
	private String movie_maxage;
	private Date movie_opendate;
	private int movie_runningtime;
	private String movie_country;
	private String movie_content;
	private String movie_poster;
	private String movie_state;
	private int movie_audience;
	private String movie_stillcut1;
	private String movie_stillcut2;
	private String movie_stillcut3;
	private String movie_stillcut4;
	private String movie_stillcut5; 
	private double avg_movie_review_star;
	
	public MovieDTO() {
		// TODO Auto-generated constructor stub
	}
	
	public MovieDTO(int movie_idx, String movie_state) {
		super();
		this.movie_idx = movie_idx;
		this.movie_state = movie_state;
	}
	
	public MovieDTO(int movie_idx, String movie_name, String movie_genre, String movie_god, String movie_actor,
			String movie_maxage, Date movie_opendate, int movie_runningtime, String movie_country, String movie_content,
			String movie_poster, String movie_stillcut1, String movie_stillcut2, String movie_stillcut3,
			String movie_stillcut4, String movie_stillcut5) {
		super();
		this.movie_idx = movie_idx;
		this.movie_name = movie_name;
		this.movie_genre = movie_genre;
		this.movie_god = movie_god;
		this.movie_actor = movie_actor;
		this.movie_maxage = movie_maxage;
		this.movie_opendate = movie_opendate;
		this.movie_runningtime = movie_runningtime;
		this.movie_country = movie_country;
		this.movie_content = movie_content;
		this.movie_poster = movie_poster;
		this.movie_stillcut1 = movie_stillcut1;
		this.movie_stillcut2 = movie_stillcut2;
		this.movie_stillcut3 = movie_stillcut3;
		this.movie_stillcut4 = movie_stillcut4;
		this.movie_stillcut5 = movie_stillcut5;
	}
	
	

	public MovieDTO(int movie_idx, String movie_name, String movie_genre, String movie_god, String movie_actor,
			String movie_maxage, Date movie_opendate, int movie_runningtime, String movie_country, String movie_content,
			String movie_poster, String movie_state, String movie_stillcut1, String movie_stillcut2,
			String movie_stillcut3, String movie_stillcut4, String movie_stillcut5) {
		super();
		this.movie_idx = movie_idx;
		this.movie_name = movie_name;
		this.movie_genre = movie_genre;
		this.movie_god = movie_god;
		this.movie_actor = movie_actor;
		this.movie_maxage = movie_maxage;
		this.movie_opendate = movie_opendate;
		this.movie_runningtime = movie_runningtime;
		this.movie_country = movie_country;
		this.movie_content = movie_content;
		this.movie_poster = movie_poster;
		this.movie_state = movie_state;
		this.movie_stillcut1 = movie_stillcut1;
		this.movie_stillcut2 = movie_stillcut2;
		this.movie_stillcut3 = movie_stillcut3;
		this.movie_stillcut4 = movie_stillcut4;
		this.movie_stillcut5 = movie_stillcut5;
	}
	
	
	

	public MovieDTO(int movie_idx, String movie_name, String movie_genre, String movie_god, String movie_actor,
			String movie_maxage, Date movie_opendate, int movie_runningtime, String movie_country, String movie_content,
			String movie_poster, String movie_state, int movie_audience, String movie_stillcut1, String movie_stillcut2,
			String movie_stillcut3, String movie_stillcut4, String movie_stillcut5, double avg_movie_review_star) {
		super();
		this.movie_idx = movie_idx;
		this.movie_name = movie_name;
		this.movie_genre = movie_genre;
		this.movie_god = movie_god;
		this.movie_actor = movie_actor;
		this.movie_maxage = movie_maxage;
		this.movie_opendate = movie_opendate;
		this.movie_runningtime = movie_runningtime;
		this.movie_country = movie_country;
		this.movie_content = movie_content;
		this.movie_poster = movie_poster;
		this.movie_state = movie_state;
		this.movie_audience = movie_audience;
		this.movie_stillcut1 = movie_stillcut1;
		this.movie_stillcut2 = movie_stillcut2;
		this.movie_stillcut3 = movie_stillcut3;
		this.movie_stillcut4 = movie_stillcut4;
		this.movie_stillcut5 = movie_stillcut5;
		this.avg_movie_review_star = avg_movie_review_star;
	}

	public int getMovie_idx() {
		return movie_idx;
	}

	public void setMovie_idx(int movie_idx) {
		this.movie_idx = movie_idx;
	}

	public String getMovie_name() {
		return movie_name;
	}

	public void setMovie_name(String movie_name) {
		this.movie_name = movie_name;
	}

	public String getMovie_genre() {
		return movie_genre;
	}

	public void setMovie_genre(String movie_genre) {
		this.movie_genre = movie_genre;
	}

	public String getMovie_god() {
		return movie_god;
	}

	public void setMovie_god(String movie_god) {
		this.movie_god = movie_god;
	}

	public String getMovie_actor() {
		return movie_actor;
	}

	public void setMovie_actor(String movie_actor) {
		this.movie_actor = movie_actor;
	}

	public String getMovie_maxage() {
		return movie_maxage;
	}

	public void setMovie_maxage(String movie_maxage) {
		this.movie_maxage = movie_maxage;
	}

	public Date getMovie_opendate() {
		return movie_opendate;
	}

	public void setMovie_opendate(Date movie_opendate) {
		this.movie_opendate = movie_opendate;
	}

	public int getMovie_runningtime() {
		return movie_runningtime;
	}

	public void setMovie_runningtime(int movie_runningtime) {
		this.movie_runningtime = movie_runningtime;
	}

	public String getMovie_country() {
		return movie_country;
	}

	public void setMovie_country(String movie_country) {
		this.movie_country = movie_country;
	}

	public String getMovie_content() {
		return movie_content;
	}

	public void setMovie_content(String movie_content) {
		this.movie_content = movie_content;
	}

	public String getMovie_poster() {
		return movie_poster;
	}

	public void setMovie_poster(String movie_poster) {
		this.movie_poster = movie_poster;
	}

	public String getMovie_state() {
		return movie_state;
	}

	public void setMovie_state(String movie_state) {
		this.movie_state = movie_state;
	}

	public int getMovie_audience() {
		return movie_audience;
	}

	public void setMovie_audience(int movie_audience) {
		this.movie_audience = movie_audience;
	}

	public String getMovie_stillcut1() {
		return movie_stillcut1;
	}

	public void setMovie_stillcut1(String movie_stillcut1) {
		this.movie_stillcut1 = movie_stillcut1;
	}

	public String getMovie_stillcut2() {
		return movie_stillcut2;
	}

	public void setMovie_stillcut2(String movie_stillcut2) {
		this.movie_stillcut2 = movie_stillcut2;
	}

	public String getMovie_stillcut3() {
		return movie_stillcut3;
	}

	public void setMovie_stillcut3(String movie_stillcut3) {
		this.movie_stillcut3 = movie_stillcut3;
	}

	public String getMovie_stillcut4() {
		return movie_stillcut4;
	}

	public void setMovie_stillcut4(String movie_stillcut4) {
		this.movie_stillcut4 = movie_stillcut4;
	}

	public String getMovie_stillcut5() {
		return movie_stillcut5;
	}

	public void setMovie_stillcut5(String movie_stillcut5) {
		this.movie_stillcut5 = movie_stillcut5;
	}

	public double getAvg_movie_review_star() {
		return avg_movie_review_star;
	}

	public void setAvg_movie_review_star(double avg_movie_review_star) {
		this.avg_movie_review_star = avg_movie_review_star;
	}
	
	
	
}
