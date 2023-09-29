package com.amor.inquiry.model;

import java.sql.*;
public class InquiryDTO {
	
	private int inquiry_idx;
	private String inquiry_subject;
	private String inquiry_content;
	private String inquiry_filename;
	private Date inquiry_writedate;
	private String inquiry_answer;
	private String inquiry_astatus;
	
	public InquiryDTO() {
		// TODO Auto-generated constructor stub
	}

	public InquiryDTO(int inquiry_idx, String inquiry_subject, String inquiry_content, String inquiry_filename,
			Date inquiry_writedate, String inquiry_answer, String inquiry_astatus) {
		super();
		this.inquiry_idx = inquiry_idx;
		this.inquiry_subject = inquiry_subject;
		this.inquiry_content = inquiry_content;
		this.inquiry_filename = inquiry_filename;
		this.inquiry_writedate = inquiry_writedate;
		this.inquiry_answer = inquiry_answer;
		this.inquiry_astatus = inquiry_astatus;
	}

	public int getInquiry_idx() {
		return inquiry_idx;
	}

	public void setInquiry_idx(int inquiry_idx) {
		this.inquiry_idx = inquiry_idx;
	}

	public String getInquiry_subject() {
		return inquiry_subject;
	}

	public void setInquiry_subject(String inquiry_subject) {
		this.inquiry_subject = inquiry_subject;
	}

	public String getInquiry_content() {
		return inquiry_content;
	}

	public void setInquiry_content(String inquiry_content) {
		this.inquiry_content = inquiry_content;
	}

	public String getInquiry_filename() {
		return inquiry_filename;
	}

	public void setInquiry_filename(String inquiry_filename) {
		this.inquiry_filename = inquiry_filename;
	}

	public Date getInquiry_writedate() {
		return inquiry_writedate;
	}

	public void setInquiry_writedate(Date inquiry_writedate) {
		this.inquiry_writedate = inquiry_writedate;
	}

	public String getInquiry_answer() {
		return inquiry_answer;
	}

	public void setInquiry_answer(String inquiry_answer) {
		this.inquiry_answer = inquiry_answer;
	}

	public String getInquiry_astatus() {
		return inquiry_astatus;
	}

	public void setInquiry_astatus(String inquiry_astatus) {
		this.inquiry_astatus = inquiry_astatus;
	}
	
	
}