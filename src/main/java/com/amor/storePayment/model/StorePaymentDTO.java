package com.amor.storePayment.model;

import java.sql.*;

public class StorePaymentDTO {
	private int store_payment_idx;
	private int product_idx;
	private int member_idx;
	private int store_payment_amount;
	private int store_payment_price;
	private String store_payment_payment;
	private Date store_payment_paymentdate;
	private String store_payment_status;
	private int a; // 총 가격 합계(매출)
	private String b; // 날짜 문자열 타입
	private String c; // 총 가격 format(#,###) 표현 값
	private String member_id; 
	private String product_title;
	
	public StorePaymentDTO() {
		// TODO Auto-generated constructor stub
	}
	
	public StorePaymentDTO(int store_payment_idx, int product_idx, int member_idx, int store_payment_amount,
			int store_payment_price, String store_payment_payment, Date store_payment_paymentdate,
			String store_payment_status, int a, String b, String c, String member_id, String product_title) {
		super();
		this.store_payment_idx = store_payment_idx;
		this.product_idx = product_idx;
		this.member_idx = member_idx;
		this.store_payment_amount = store_payment_amount;
		this.store_payment_price = store_payment_price;
		this.store_payment_payment = store_payment_payment;
		this.store_payment_paymentdate = store_payment_paymentdate;
		this.store_payment_status = store_payment_status;
		this.a = a;
		this.b = b;
		this.c = c;
		this.member_id = member_id;
		this.product_title = product_title;
	}

	public StorePaymentDTO(int store_payment_idx, int product_idx, int member_idx, int store_payment_amount,
			int store_payment_price, String store_payment_payment, Date store_payment_paymentdate,
			String store_payment_status, int a, String b, String c) {
		super();
		this.store_payment_idx = store_payment_idx;
		this.product_idx = product_idx;
		this.member_idx = member_idx;
		this.store_payment_amount = store_payment_amount;
		this.store_payment_price = store_payment_price;
		this.store_payment_payment = store_payment_payment;
		this.store_payment_paymentdate = store_payment_paymentdate;
		this.store_payment_status = store_payment_status;
		this.a = a;
		this.b = b;
		this.c = c;
	}

	public int getStore_payment_idx() {
		return store_payment_idx;
	}

	public void setStore_payment_idx(int store_payment_idx) {
		this.store_payment_idx = store_payment_idx;
	}

	public int getProduct_idx() {
		return product_idx;
	}

	public void setProduct_idx(int product_idx) {
		this.product_idx = product_idx;
	}

	public int getMember_idx() {
		return member_idx;
	}

	public void setMember_idx(int member_idx) {
		this.member_idx = member_idx;
	}

	public int getStore_payment_amount() {
		return store_payment_amount;
	}

	public void setStore_payment_amount(int store_payment_amount) {
		this.store_payment_amount = store_payment_amount;
	}

	public int getStore_payment_price() {
		return store_payment_price;
	}

	public void setStore_payment_price(int store_payment_price) {
		this.store_payment_price = store_payment_price;
	}

	public String getStore_payment_payment() {
		return store_payment_payment;
	}

	public void setStore_payment_payment(String store_payment_payment) {
		this.store_payment_payment = store_payment_payment;
	}

	public Date getStore_payment_paymentdate() {
		return store_payment_paymentdate;
	}

	public void setStore_payment_paymentdate(Date store_payment_paymentdate) {
		this.store_payment_paymentdate = store_payment_paymentdate;
	}

	public String getStore_payment_status() {
		return store_payment_status;
	}

	public void setStore_payment_status(String store_payment_status) {
		this.store_payment_status = store_payment_status;
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

	public String getMember_id() {
		return member_id;
	}

	public void setMember_id(String member_id) {
		this.member_id = member_id;
	}

	public String getProduct_title() {
		return product_title;
	}

	public void setProduct_title(String product_title) {
		this.product_title = product_title;
	}
	
}