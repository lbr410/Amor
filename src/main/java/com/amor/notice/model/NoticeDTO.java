package com.amor.notice.model;

import java.sql.*;

public class NoticeDTO {
	
	private int notice_idx;
	private String notice_subject;
	private String notice_content;
	private Date notice_writedate;
	private int notice_readnum;
	
	public NoticeDTO() {
		
	}


	public NoticeDTO(int notice_idx, String notice_subject, String notice_content, Date notice_writedate,
			int notice_readnum) {
		super();
		this.notice_idx = notice_idx;
		this.notice_subject = notice_subject;
		this.notice_content = notice_content;
		this.notice_writedate = notice_writedate;
		this.notice_readnum = notice_readnum;
	}

	public int getNotice_idx() {
		return notice_idx;
	}

	public void setNotice_idx(int notice_idx) {
		this.notice_idx = notice_idx;
	}

	public String getNotice_subject() {
		return notice_subject;
	}

	public void setNotice_subject(String notice_subject) {
		this.notice_subject = notice_subject;
	}

	public String getNotice_content() {
		return notice_content;
	}

	public void setNotice_content(String notice_content) {
		this.notice_content = notice_content;
	}

	public Date getNotice_writedate() {
		return notice_writedate;
	}

	public void setNotice_writedate(Date notice_writedate) {
		this.notice_writedate = notice_writedate;
	}

	public int getNotice_readnum() {
		return notice_readnum;
	}

	public void setNotice_readnum(int notice_readnum) {
		this.notice_readnum = notice_readnum;
	}

	
}
