package com.amor.ticketing.model;

import java.sql.Date;

public class JoinTicketingHistoryDTO {

	private String moviename;
	private String movieimg;
	private String ticketnum;
	private String seatnum;
	private Date screeningdate;
	private String payment;
	private Long price;
	private Date reservetime;
	private String changePrice;
	private String theatername;
	private String timelimit;
	
	public JoinTicketingHistoryDTO() {
		System.out.println("joinTicketingDTO start");
	}

	public JoinTicketingHistoryDTO(String moviename, String movieimg, String ticketnum, String seatnum,
			Date screeningdate, String payment, Long price, Date reservetime, String changePrice, String theatername,
			String timelimit) {
		super();
		this.moviename = moviename;
		this.movieimg = movieimg;
		this.ticketnum = ticketnum;
		this.seatnum = seatnum;
		this.screeningdate = screeningdate;
		this.payment = payment;
		this.price = price;
		this.reservetime = reservetime;
		this.changePrice = changePrice;
		this.theatername = theatername;
		this.timelimit = timelimit;
	}

	public String getMoviename() {
		return moviename;
	}

	public void setMoviename(String moviename) {
		this.moviename = moviename;
	}

	public String getMovieimg() {
		return movieimg;
	}

	public void setMovieimg(String movieimg) {
		this.movieimg = movieimg;
	}

	public String getTicketnum() {
		return ticketnum;
	}

	public void setTicketnum(String ticketnum) {
		this.ticketnum = ticketnum;
	}

	public String getSeatnum() {
		return seatnum;
	}

	public void setSeatnum(String seatnum) {
		this.seatnum = seatnum;
	}

	public Date getScreeningdate() {
		return screeningdate;
	}

	public void setScreeningdate(Date screeningdate) {
		this.screeningdate = screeningdate;
	}

	public String getPayment() {
		return payment;
	}

	public void setPayment(String payment) {
		this.payment = payment;
	}

	public Long getPrice() {
		return price;
	}

	public void setPrice(Long price) {
		this.price = price;
	}

	public Date getReservetime() {
		return reservetime;
	}

	public void setReservetime(Date reservetime) {
		this.reservetime = reservetime;
	}

	public String getChangePrice() {
		return changePrice;
	}

	public void setChangePrice(String changePrice) {
		this.changePrice = changePrice;
	}

	public String getTheatername() {
		return theatername;
	}

	public void setTheatername(String theatername) {
		this.theatername = theatername;
	}

	public String getTimelimit() {
		return timelimit;
	}

	public void setTimelimit(String timelimit) {
		this.timelimit = timelimit;
	}		

	
		
	
}
