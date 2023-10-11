package com.amor.ticketing.model;

public class TicketingPayingJoinDTO {
	
	private String movie_poster;
	private String movie_name;
	private String playing_movie_start;
	private String playing_movie_end;
	private String theater_name;
	
	public TicketingPayingJoinDTO() {
		// TODO Auto-generated constructor stub
	}

	public TicketingPayingJoinDTO(String movie_poster, String movie_name, String playing_movie_start,
			String playing_movie_end, String theater_name) {
		super();
		this.movie_poster = movie_poster;
		this.movie_name = movie_name;
		this.playing_movie_start = playing_movie_start;
		this.playing_movie_end = playing_movie_end;
		this.theater_name = theater_name;
	}

	public String getMovie_poster() {
		return movie_poster;
	}

	public void setMovie_poster(String movie_poster) {
		this.movie_poster = movie_poster;
	}

	public String getMovie_name() {
		return movie_name;
	}

	public void setMovie_name(String movie_name) {
		this.movie_name = movie_name;
	}

	public String getPlaying_movie_start() {
		return playing_movie_start;
	}

	public void setPlaying_movie_start(String playing_movie_start) {
		this.playing_movie_start = playing_movie_start;
	}

	public String getPlaying_movie_end() {
		return playing_movie_end;
	}

	public void setPlaying_movie_end(String playing_movie_end) {
		this.playing_movie_end = playing_movie_end;
	}

	public String getTheater_name() {
		return theater_name;
	}

	public void setTheater_name(String theater_name) {
		this.theater_name = theater_name;
	}

}
