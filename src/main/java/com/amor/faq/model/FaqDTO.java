package com.amor.faq.model;

import java.sql.*;

public class FaqDTO {
	
	private int faq_idx;
	private int faq_type;
	private String faq_subject;
	private String faq_content;
	private Date faq_writedate;
	private String faq_type2;
	
	public FaqDTO() {
		// TODO Auto-generated constructor stub
	}
	
	public FaqDTO(int faq_idx, int faq_type, String faq_subject, String faq_content, Date faq_writedate,
			String faq_type2) {
		super();
		this.faq_idx = faq_idx;
		this.faq_type = faq_type;
		this.faq_subject = faq_subject;
		this.faq_content = faq_content;
		this.faq_writedate = faq_writedate;
		this.faq_type2 = faq_type2;
	}

	public FaqDTO(int faq_idx, int faq_type, String faq_subject, String faq_content, Date faq_writedate) {
		super();
		this.faq_idx = faq_idx;
		this.faq_type = faq_type;
		this.faq_subject = faq_subject;
		this.faq_content = faq_content;
		this.faq_writedate = faq_writedate;
	}

	public int getFaq_idx() {
		return faq_idx;
	}

	public void setFaq_idx(int faq_idx) {
		this.faq_idx = faq_idx;
	}

	public int getFaq_type() {
		return faq_type;
	}

	public void setFaq_type(int faq_type) {
		this.faq_type = faq_type;
	}

	public String getFaq_subject() {
		return faq_subject;
	}

	public void setFaq_subject(String faq_subject) {
		this.faq_subject = faq_subject;
	}

	public String getFaq_content() {
		return faq_content;
	}

	public void setFaq_content(String faq_content) {
		this.faq_content = faq_content;
	}

	public Date getFaq_writedate() {
		return faq_writedate;
	}

	public void setFaq_writedate(Date faq_writedate) {
		this.faq_writedate = faq_writedate;
	}

	public String getFaq_type2() {
		return faq_type2;
	}

	public void setFaq_type2(String faq_type2) {
		this.faq_type2 = faq_type2;
	}
	
	
}
