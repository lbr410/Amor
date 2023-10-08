package com.amor.ticketing.model;

import java.sql.*;

public class TicketingDTO {
	private int ticketing_idx;
	private int playing_movie_idx;
	private int theater_idx;
	private int member_idx;
	private String ticketing_num;
	private String ticketing_seat;
	private Date ticketing_reservetime;
	private Date ticketing_screeningtime;
	private int ticketing_price;
	private int ticketing_personnel; // 테이블 자료형 변경 후 int로 변경할 것
	private String ticketing_state;
	private String ticketing_payment;
	private int a; // 총 가격 합계(매출)
	private String b; // 날짜 문자열 타입
	private String c; // 총 가격 format(#,###) 표현 값
	
	public TicketingDTO() {
		// TODO Auto-generated constructor stub
	}
	
	public TicketingDTO(int ticketing_idx, int playing_movie_idx, int theater_idx, int member_idx, String ticketing_num,
			String ticketing_seat, Date ticketing_reservetime, Date ticketing_screeningtime, int ticketing_price,
			int ticketing_personnel, String ticketing_state, String ticketing_payment, int a, String b, String c) {
		super();
		this.ticketing_idx = ticketing_idx;
		this.playing_movie_idx = playing_movie_idx;
		this.theater_idx = theater_idx;
		this.member_idx = member_idx;
		this.ticketing_num = ticketing_num;
		this.ticketing_seat = ticketing_seat;
		this.ticketing_reservetime = ticketing_reservetime;
		this.ticketing_screeningtime = ticketing_screeningtime;
		this.ticketing_price = ticketing_price;
		this.ticketing_personnel = ticketing_personnel;
		this.ticketing_state = ticketing_state;
		this.ticketing_payment = ticketing_payment;
		this.a = a;
		this.b = b;
		this.c = c;
	}

	public TicketingDTO(int playing_movie_idx, int theater_idx, int member_idx, String ticketing_num,
			String ticketing_seat, Date ticketing_screeningtime, int ticketing_price, int ticketing_personnel) {
		super();
		this.playing_movie_idx = playing_movie_idx;
		this.theater_idx = theater_idx;
		this.member_idx = member_idx;
		this.ticketing_num = ticketing_num;
		this.ticketing_seat = ticketing_seat;
		this.ticketing_screeningtime = ticketing_screeningtime;
		this.ticketing_price = ticketing_price;
		this.ticketing_personnel = ticketing_personnel;
	}

	public int getTicketing_idx() {
		return ticketing_idx;
	}

	public void setTicketing_idx(int ticketing_idx) {
		this.ticketing_idx = ticketing_idx;
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

	public int getMember_idx() {
		return member_idx;
	}

	public void setMember_idx(int member_idx) {
		this.member_idx = member_idx;
	}

	public String getTicketing_num() {
		return ticketing_num;
	}

	public void setTicketing_num(String ticketing_num) {
		this.ticketing_num = ticketing_num;
	}

	public String getTicketing_seat() {
		return ticketing_seat;
	}

	public void setTicketing_seat(String ticketing_seat) {
		this.ticketing_seat = ticketing_seat;
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

	public String getTicketing_state() {
		return ticketing_state;
	}

	public void setTicketing_state(String ticketing_state) {
		this.ticketing_state = ticketing_state;
	}

	public String getTicketing_payment() {
		return ticketing_payment;
	}

	public void setTicketing_payment(String ticketing_payment) {
		this.ticketing_payment = ticketing_payment;
	}

	public int getA() {
		return a;
	}

	public void setA(int a) {
		this.a = a;
	}

	public String getB() {
		return b;
	}

	public void setB(String b) {
		this.b = b;
	}

	public String getC() {
		return c;
	}

	public void setC(String c) {
		this.c = c;
	}

	
}