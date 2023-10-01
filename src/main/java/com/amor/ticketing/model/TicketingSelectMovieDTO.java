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
	
	
	

}
