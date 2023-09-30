package com.amor.playingMovie.model;

public class PlayingMovieJoinDTO {

	
	private int playing_movie_idx;
	private int movie_idx;
	private int theater_idx;
	private String playing_movie_date;
	private String playing_movie_start;
	private String playing_movie_end;
	private int playing_movie_remain_seats;
	private String playing_movie_seat;
	private String theater_name;
	private String movie_name;

	public PlayingMovieJoinDTO() {
		// TODO Auto-generated constructor stub
	}

	public PlayingMovieJoinDTO(int playing_movie_idx, int movie_idx, int theater_idx, String playing_movie_date,
			String playing_movie_start, String playing_movie_end, int playing_movie_remain_seats,
			String playing_movie_seat, String theater_name, String movie_name) {
		super();
		this.playing_movie_idx = playing_movie_idx;
		this.movie_idx = movie_idx;
		this.theater_idx = theater_idx;
		this.playing_movie_date = playing_movie_date;
		this.playing_movie_start = playing_movie_start;
		this.playing_movie_end = playing_movie_end;
		this.playing_movie_remain_seats = playing_movie_remain_seats;
		this.playing_movie_seat = playing_movie_seat;
		this.theater_name = theater_name;
		this.movie_name = movie_name;
	}
	
	
	public int getPlaying_movie_idx() {
		return playing_movie_idx;
	}

	public void setPlaying_movie_idx(int playing_movie_idx) {
		this.playing_movie_idx = playing_movie_idx;
	}

	public int getMovie_idx() {
		return movie_idx;
	}

	public void setMovie_idx(int movie_idx) {
		this.movie_idx = movie_idx;
	}

	public int getTheater_idx() {
		return theater_idx;
	}

	public void setTheater_idx(int theater_idx) {
		this.theater_idx = theater_idx;
	}

	public String getPlaying_movie_date() {
		return playing_movie_date;
	}

	public void setPlaying_movie_date(String playing_movie_date) {
		this.playing_movie_date = playing_movie_date;
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

	public int getPlaying_movie_remain_seats() {
		return playing_movie_remain_seats;
	}

	public void setPlaying_movie_remain_seats(int playing_movie_remain_seats) {
		this.playing_movie_remain_seats = playing_movie_remain_seats;
	}

	public String getPlaying_movie_seat() {
		return playing_movie_seat;
	}

	public void setPlaying_movie_seat(String playing_movie_seat) {
		this.playing_movie_seat = playing_movie_seat;
	}

	public String getTheater_name() {
		return theater_name;
	}

	public void setTheater_name(String theater_name) {
		this.theater_name = theater_name;
	}

	public String getMovie_name() {
		return movie_name;
	}

	public void setMovie_name(String movie_name) {
		this.movie_name = movie_name;
	}
	
}
