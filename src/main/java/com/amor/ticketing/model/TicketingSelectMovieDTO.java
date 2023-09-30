package com.amor.ticketing.model;

public class TicketingSelectMovieDTO {

	private int movie_maxage;//영화 연령제한
	private String movie_name;//영화 이름
	
	
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
