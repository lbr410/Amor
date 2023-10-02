package com.amor.ticketing.model;

public class TicketingSelectMovieDTO {

	private int movie_idx;//영화 고유번호
	private String movie_name;//영화 이름
	private int movie_maxage;//영화 연령제한
	private int playing_movie_idx;//상영영화 고유번호
	private int theater_idx;//영화관 고유번호
	private String theater_name;//상영관 이름
	private String playing_movie_date;//상영날짜
	private String playing_movie_start;//상영시작시간
	private int playing_movie_remain_seats;//남은 좌석?
	private int theater_totalseat;//해당 상영관 총 좌석
	
	
	
	
	public TicketingSelectMovieDTO() {
		// TODO Auto-generated constructor stub
	}
	

	public TicketingSelectMovieDTO(int movie_maxage, String movie_name) {
		super();
		this.movie_maxage = movie_maxage;
		this.movie_name = movie_name;
	}

	public TicketingSelectMovieDTO(int movie_idx, String movie_name, int movie_maxage, int playing_movie_idx,
			int theater_idx, String theater_name, String playing_movie_date, String playing_movie_start,
			int playing_movie_remain_seats, int theater_totalseat) {
		super();
		this.movie_idx = movie_idx;
		this.movie_name = movie_name;
		this.movie_maxage = movie_maxage;
		this.playing_movie_idx = playing_movie_idx;
		this.theater_idx = theater_idx;
		this.theater_name = theater_name;
		this.playing_movie_date = playing_movie_date;
		this.playing_movie_start = playing_movie_start;
		this.playing_movie_remain_seats = playing_movie_remain_seats;
		this.theater_totalseat = theater_totalseat;
	}


	public int getMovie_maxage() {
		return movie_maxage;
	}


	public void setMovie_maxage(int movie_maxage) {
		this.movie_maxage = movie_maxage;
	}


	public String getMovie_name() {
		return movie_name;
	}


	public void setMovie_name(String movie_name) {
		this.movie_name = movie_name;
	}


	public int getMovie_idx() {
		return movie_idx;
	}


	public void setMovie_idx(int movie_idx) {
		this.movie_idx = movie_idx;
	}


	public int getPlaying_movie_idx() {
		return playing_movie_idx;
	}


	public void setPlaying_movie_idx(int playing_movie_idx) {
		this.playing_movie_idx = playing_movie_idx;
	}


	public int getTheater_idx() {
		return theater_idx;
	}


	public void setTheater_idx(int theater_idx) {
		this.theater_idx = theater_idx;
	}


	public String getTheater_name() {
		return theater_name;
	}


	public void setTheater_name(String theater_name) {
		this.theater_name = theater_name;
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


	public int getPlaying_movie_remain_seats() {
		return playing_movie_remain_seats;
	}


	public void setPlaying_movie_remain_seats(int playing_movie_remain_seats) {
		this.playing_movie_remain_seats = playing_movie_remain_seats;
	}


	public int getTheater_totalseat() {
		return theater_totalseat;
	}


	public void setTheater_totalseat(int theater_totalseat) {
		this.theater_totalseat = theater_totalseat;
	}
	
	
	

}
