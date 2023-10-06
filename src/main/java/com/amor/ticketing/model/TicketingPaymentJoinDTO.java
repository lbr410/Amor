package com.amor.ticketing.model;

import java.sql.Date;

public class TicketingPaymentJoinDTO {
	
	int ticketing_idx;
	String movie_poster;
	String movie_name;
	Date ticketing_reservetime;
	Date ticketing_screeningtime;
	String theater_name;
	int ticketing_personnel;
	String ticketing_seat;
	String ticketing_price;
	
	public TicketingPaymentJoinDTO() {
		// TODO Auto-generated constructor stub
	}

	public TicketingPaymentJoinDTO(int ticketing_idx, String movie_poster, String movie_name,
			Date ticketing_reservetime, Date ticketing_screeningtime, String theater_name, int ticketing_personnel,
			String ticketing_seat, String ticketing_price) {
		super();
		this.ticketing_idx = ticketing_idx;
		this.movie_poster = movie_poster;
		this.movie_name = movie_name;
		this.ticketing_reservetime = ticketing_reservetime;
		this.ticketing_screeningtime = ticketing_screeningtime;
		this.theater_name = theater_name;
		this.ticketing_personnel = ticketing_personnel;
		this.ticketing_seat = ticketing_seat;
		this.ticketing_price = ticketing_price;
	}

	public int getTicketing_idx() {
		return ticketing_idx;
	}

	public void setTicketing_idx(int ticketing_idx) {
		this.ticketing_idx = ticketing_idx;
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

	public Date getTicketing_reservetime() {
		return ticketing_reservetime;
	}

	public void setTicketing_reservetime(Date ticketing_reservetime) {
		this.ticketing_reservetime = ticketing_reservetime;
	}

	public Date getTicketing_screeningtime() {
		return ticketing_screeningtime;
	}

	public void setTicketing_screeningtime(Date ticketing_screeningtime) {
		this.ticketing_screeningtime = ticketing_screeningtime;
	}

	public String getTheater_name() {
		return theater_name;
	}

	public void setTheater_name(String theater_name) {
		this.theater_name = theater_name;
	}

	public int getTicketing_personnel() {
		return ticketing_personnel;
	}

	public void setTicketing_personnel(int ticketing_personnel) {
		this.ticketing_personnel = ticketing_personnel;
	}

	public String getTicketing_seat() {
		return ticketing_seat;
	}

	public void setTicketing_seat(String ticketing_seat) {
		this.ticketing_seat = ticketing_seat;
	}

	public String getTicketing_price() {
		return ticketing_price;
	}

	public void setTicketing_price(String ticketing_price) {
		this.ticketing_price = ticketing_price;
	}

	
	
}
