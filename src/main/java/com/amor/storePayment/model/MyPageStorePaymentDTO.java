package com.amor.storePayment.model;

import java.util.Date;

public class MyPageStorePaymentDTO {

	private int paymentidx;
	private String productname;
	private String productimg;
	private Date paymentdate;
	private String payment;
	private int amount;
	private Long price;
	private String status;
	private String changePaymentDate;
	private String changePrice;
	
	public MyPageStorePaymentDTO() {
	}

	public MyPageStorePaymentDTO(int paymentidx, String productname, String productimg, Date paymentdate,
			String payment, int amount, Long price, String status) {
		super();
		this.paymentidx = paymentidx;
		this.productname = productname;
		this.productimg = productimg;
		this.paymentdate = paymentdate;
		this.payment = payment;
		this.amount = amount;
		this.price = price;
		this.status = status;
	}

	public int getPaymentidx() {
		return paymentidx;
	}

	public void setPaymentidx(int paymentidx) {
		this.paymentidx = paymentidx;
	}

	public String getProductname() {
		return productname;
	}

	public void setProductname(String productname) {
		this.productname = productname;
	}

	public String getProductimg() {
		return productimg;
	}

	public void setProductimg(String productimg) {
		this.productimg = productimg;
	}

	public Date getPaymentdate() {
		return paymentdate;
	}

	public void setPaymentdate(Date paymentdate) {
		this.paymentdate = paymentdate;
	}

	public String getPayment() {
		return payment;
	}

	public void setPayment(String payment) {
		this.payment = payment;
	}

	public int getAmount() {
		return amount;
	}

	public void setAmount(int amount) {
		this.amount = amount;
	}

	public Long getPrice() {
		return price;
	}

	public void setPrice(Long price) {
		this.price = price;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public String getChangePrice() {
		return changePrice;
	}

	public void setChangePrice(String changePrice) {
		this.changePrice = changePrice;
	}

	public String getChangePaymentDate() {
		return changePaymentDate;
	}

	public void setChangePaymentDate(String changePaymentDate) {
		this.changePaymentDate = changePaymentDate;
	}
	
}
