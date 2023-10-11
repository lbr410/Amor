package com.amor.ticketing.model;

import java.util.Date;

public class JoinTicketingHistoryDTO {

	private int movieidx;
	private int ticketingidx;
	private int memberidx;
	private int playingMovieidx;
	private String moviename;
	private String movieimg;
	private String ticketnum;
	private String seatnum;
	private Date endDate;
	private Date screeningdate;
	private String payment;
	private Long price;
	private Date reservetime;
	private String changeEndDate;
	private String changeScreeningDate;
	private String changeReserveTime;
	private String changePrice;
	private String theatername;
	private String timelimit;
	private String state;
	
	public JoinTicketingHistoryDTO() {
	}

	public JoinTicketingHistoryDTO(int movieidx, int ticketingidx, int memberidx, int playingMovieidx, String moviename,
			String movieimg, String ticketnum, String seatnum, Date endDate, Date screeningdate, String payment,
			Long price, Date reservetime, String changeEndDate, String changeScreeningDate, String changeReserveTime,
			String changePrice, String theatername, String timelimit, String state) {
		super();
		this.movieidx = movieidx;
		this.ticketingidx = ticketingidx;
		this.memberidx = memberidx;
		this.playingMovieidx = playingMovieidx;
		this.moviename = moviename;
		this.movieimg = movieimg;
		this.ticketnum = ticketnum;
		this.seatnum = seatnum;
		this.endDate = endDate;
		this.screeningdate = screeningdate;
		this.payment = payment;
		this.price = price;
		this.reservetime = reservetime;
		this.changeEndDate = changeEndDate;
		this.changeScreeningDate = changeScreeningDate;
		this.changeReserveTime = changeReserveTime;
		this.changePrice = changePrice;
		this.theatername = theatername;
		this.timelimit = timelimit;
		this.state = state;
	}

	public int getMovieidx() {
		return movieidx;
	}

	public void setMovieidx(int movieidx) {
		this.movieidx = movieidx;
	}

	public int getTicketingidx() {
		return ticketingidx;
	}

	public void setTicketingidx(int ticketingidx) {
		this.ticketingidx = ticketingidx;
	}

	public int getMemberidx() {
		return memberidx;
	}

	public void setMemberidx(int memberidx) {
		this.memberidx = memberidx;
	}

	public int getPlayingMovieidx() {
		return playingMovieidx;
	}

	public void setPlayingMovieidx(int playingMovieidx) {
		this.playingMovieidx = playingMovieidx;
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

	public Date getEndDate() {
		return endDate;
	}

	public void setEndDate(Date endDate) {
		this.endDate = endDate;
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

	public String getChangeEndDate() {
		return changeEndDate;
	}

	public void setChangeEndDate(String changeEndDate) {
		this.changeEndDate = changeEndDate;
	}

	public String getChangeScreeningDate() {
		return changeScreeningDate;
	}

	public void setChangeScreeningDate(String changeScreeningDate) {
		this.changeScreeningDate = changeScreeningDate;
	}

	public String getChangeReserveTime() {
		return changeReserveTime;
	}

	public void setChangeReserveTime(String changeReserveTime) {
		this.changeReserveTime = changeReserveTime;
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

	public String getState() {
		return state;
	}

	public void setState(String state) {
		this.state = state;
	}	
		
}
