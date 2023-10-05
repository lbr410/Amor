package com.amor.dual.model;

import java.sql.Date;

public class DualDTO {
	private int a;
	private int b;
	private int c;
	private int d;
	private int e;
	private int f;
	private int g;
	private String ad;
	private String bd;
	private String cd;
	private String dd;
	private String ed;
	private String fd;
	private String gd;
	private int orders;
	private int rnum;
	private Date dates;
	private String fPrice;
	
	public DualDTO() {
		// TODO Auto-generated constructor stub
	}

	public DualDTO(int a, int b, int c, int d, int e, int f, int g, String ad, String bd, String cd, String dd,
			String ed, String fd, String gd, int orders, int rnum, Date dates, String fPrice) {
		super();
		this.a = a;
		this.b = b;
		this.c = c;
		this.d = d;
		this.e = e;
		this.f = f;
		this.g = g;
		this.ad = ad;
		this.bd = bd;
		this.cd = cd;
		this.dd = dd;
		this.ed = ed;
		this.fd = fd;
		this.gd = gd;
		this.orders = orders;
		this.rnum = rnum;
		this.dates = dates;
		this.fPrice = fPrice;
	}
	
	public int getA() {
		return a;
	}

	public void setA(int a) {
		this.a = a;
	}

	public int getB() {
		return b;
	}

	public void setB(int b) {
		this.b = b;
	}

	public int getC() {
		return c;
	}

	public void setC(int c) {
		this.c = c;
	}

	public int getD() {
		return d;
	}

	public void setD(int d) {
		this.d = d;
	}

	public int getE() {
		return e;
	}

	public void setE(int e) {
		this.e = e;
	}

	public int getF() {
		return f;
	}

	public void setF(int f) {
		this.f = f;
	}

	public int getG() {
		return g;
	}

	public void setG(int g) {
		this.g = g;
	}

	public String getAd() {
		return ad;
	}

	public void setAd(String ad) {
		this.ad = ad;
	}

	public String getBd() {
		return bd;
	}

	public void setBd(String bd) {
		this.bd = bd;
	}

	public String getCd() {
		return cd;
	}

	public void setCd(String cd) {
		this.cd = cd;
	}

	public String getDd() {
		return dd;
	}

	public void setDd(String dd) {
		this.dd = dd;
	}

	public String getEd() {
		return ed;
	}

	public void setEd(String ed) {
		this.ed = ed;
	}

	public String getFd() {
		return fd;
	}

	public void setFd(String fd) {
		this.fd = fd;
	}

	public String getGd() {
		return gd;
	}

	public void setGd(String gd) {
		this.gd = gd;
	}

	public int getOrders() {
		return orders;
	}

	public void setOrders(int orders) {
		this.orders = orders;
	}

	public int getRnum() {
		return rnum;
	}

	public void setRnum(int rnum) {
		this.rnum = rnum;
	}

	public Date getDates() {
		return dates;
	}

	public void setDates(Date dates) {
		this.dates = dates;
	}

	public String getfPrice() {
		return fPrice;
	}

	public void setfPrice(String fPrice) {
		this.fPrice = fPrice;
	}
}