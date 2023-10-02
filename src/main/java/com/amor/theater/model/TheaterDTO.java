package com.amor.theater.model;

public class TheaterDTO {
	private int theater_idx;
	private String theater_name;
	private int theater_totalseat;
	private int theater_row;
	private int theater_column;
	private String theater_path;
	private String theater_seat;
	
	public TheaterDTO() {
		// TODO Auto-generated constructor stub
	}

	public TheaterDTO(int theater_idx, String theater_name, int theater_totalseat, int theater_row, int theater_column,
			String theater_path, String theater_seat) {
		super();
		this.theater_idx = theater_idx;
		this.theater_name = theater_name;
		this.theater_totalseat = theater_totalseat;
		this.theater_row = theater_row;
		this.theater_column = theater_column;
		this.theater_path = theater_path;
		this.theater_seat = theater_seat;
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

	public int getTheater_totalseat() {
		return theater_totalseat;
	}

	public void setTheater_totalseat(int theater_totalseat) {
		this.theater_totalseat = theater_totalseat;
	}

	public int getTheater_row() {
		return theater_row;
	}

	public void setTheater_row(int theater_row) {
		this.theater_row = theater_row;
	}

	public int getTheater_column() {
		return theater_column;
	}

	public void setTheater_column(int theater_column) {
		this.theater_column = theater_column;
	}

	public String getTheater_path() {
		return theater_path;
	}

	public void setTheater_path(String theater_path) {
		this.theater_path = theater_path;
	}

	public String getTheater_seat() {
		return theater_seat;
	}

	public void setTheater_seat(String theater_seat) {
		this.theater_seat = theater_seat;
	}
}