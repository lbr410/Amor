package com.amor.ticketing.model;

import java.util.*;

public class TicketingListDTO {

	private int ticketing_idx; 
	private int member_idx;			// 멤버테이블 예매내역 테이블 조인
	private int playing_movie_idx;	// 상영영화 예매내역 테이블 조인
	private int theater_idx;		// 상영관테이블 예매내역 테이블 조인
	private int movie_idx;		// 영화테이블 예매내역 테이블 조인
	
	private String member_id;		// 멤버테이블 
	private String member_name;		// 멤버테이블 
	private String member_tel1; 		// 멤버테이블 
	private String member_tel2; 		// 멤버테이블 
	private String movie_name;		// 상영영화 -> 영화 테이블 
	private String theater_name;	// 상영관테이블 예매 내역테이블 조인 
	private String ticketing_seat;	
	private java.sql.Date playing_movie_date;		// 상영영화 테이블 
	private Date playing_movie_start;		// 상영시작 시간(시 : 분) 
	private Date ticketing_reservetime;	// 실 예매시간 
	private int ticketing_price; 
	private int ticketing_personnel;
	private String ticketing_payment;
	private String ticketing_state;
	
	private String btn_cancel;
	private String ticketing_reservetime_s;
	
	public TicketingListDTO() {
		// TODO Auto-generated constructor stub
	}

	public TicketingListDTO(int ticketing_idx, String ticketing_state) {
		super();
		this.ticketing_idx = ticketing_idx;
		this.ticketing_state = ticketing_state;
	}

	public TicketingListDTO(int ticketing_idx, int member_idx, int playing_movie_idx, int theater_idx, int movie_idx,String member_id,
			String member_name, String member_tel1, String member_tel2, String movie_name, String theater_name,
			String ticketing_seat, java.sql.Date playing_movie_date, Date playing_movie_start, Date ticketing_reservetime,
			int ticketing_price, int ticketing_personnel, String ticketing_payment, String ticketing_state) {
		super();
		this.ticketing_idx = ticketing_idx;
		this.member_idx = member_idx;
		this.playing_movie_idx = playing_movie_idx;
		this.theater_idx = theater_idx;
		this.movie_idx = movie_idx;
		this.member_id = member_id;
		this.member_name = member_name;
		this.member_tel1 = member_tel1;
		this.member_tel2 = member_tel2;
		this.movie_name = movie_name;
		this.theater_name = theater_name;
		this.ticketing_seat = ticketing_seat;
		this.playing_movie_date = playing_movie_date;
		this.playing_movie_start = playing_movie_start;
		this.ticketing_reservetime = ticketing_reservetime;
		this.ticketing_price = ticketing_price;
		this.ticketing_personnel = ticketing_personnel;
		this.ticketing_payment = ticketing_payment;
		this.ticketing_state = ticketing_state;
	}
	
	
	
	

	public String getTicketing_reservetime_s() {
		return ticketing_reservetime_s;
	}

	public void setTicketing_reservetime_s(String ticketing_reservetime_s) {
		this.ticketing_reservetime_s = ticketing_reservetime_s;
	}

	public String getBtn_cancel() {
		return btn_cancel;
	}

	public void setBtn_cancel(String btn_cancel) {
		this.btn_cancel = btn_cancel;
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

	public String getMember_id() {
		return member_id;
	}

	public void setMember_id(String member_id) {
		this.member_id = member_id;
	}

	public String getMember_name() {
		return member_name;
	}

	public void setMember_name(String member_name) {
		this.member_name = member_name;
	}

	public String getMember_tel1() {
		return member_tel1;
	}

	public void setMember_tel1(String member_tel1) {
		this.member_tel1 = member_tel1;
	}

	public String getMember_tel2() {
		return member_tel2;
	}

	public void setMember_tel2(String member_tel2) {
		this.member_tel2 = member_tel2;
	}

	public String getMovie_name() {
		return movie_name;
	}

	public void setMovie_name(String movie_name) {
		this.movie_name = movie_name;
	}

	public String getTheater_name() {
		return theater_name;
	}

	public void setTheater_name(String theater_name) {
		this.theater_name = theater_name;
	}

	public String getTicketing_seat() {
		return ticketing_seat;
	}

	public void setTicketing_seat(String ticketing_seat) {
		this.ticketing_seat = ticketing_seat;
	}

	public java.sql.Date getPlaying_movie_date() {
		return playing_movie_date;
	}

	public void setPlaying_movie_date(java.sql.Date playing_movie_date) {
		this.playing_movie_date = playing_movie_date;
	}

	public Date getPlaying_movie_start() {
		return playing_movie_start;
	}

	public void setPlaying_movie_start(Date playing_movie_start) {
		this.playing_movie_start = playing_movie_start;
	}

	public Date getTicketing_reservetime() {
		return ticketing_reservetime;
	}

	public void setTicketing_reservetime(Date ticketing_reservetime) {
		this.ticketing_reservetime = ticketing_reservetime;
	}

	public int getTicketing_price() {
		return ticketing_price;
	}

	public void setTicketing_price(int ticketing_price) {
		this.ticketing_price = ticketing_price;
	}

	public int getTicketing_personnel() {
		return ticketing_personnel;
	}

	public void setTicketing_personnel(int ticketing_personnel) {
		this.ticketing_personnel = ticketing_personnel;
	}

	public String getTicketing_payment() {
		return ticketing_payment;
	}

	public void setTicketing_payment(String ticketing_payment) {
		this.ticketing_payment = ticketing_payment;
	}

	public String getTicketing_state() {
		return ticketing_state;
	}

	public void setTicketing_state(String ticketing_state) {
		this.ticketing_state = ticketing_state;
	}
	

}
