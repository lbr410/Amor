package com.amor.inquiry.model;

import java.sql.Date;
import java.util.*;

import com.amor.member.model.MemberDTO;
public class InquiryJoinDTO {

	private int inquiry_idx;
	private int member_idx;
	private String inquiry_subject;
	private String inquiry_content;
	private String inquiry_filename;
	private Date inquiry_writedate;
	private String inquiry_answer;
	private String inquiry_astatus;
	private int inquiry_type;
	private String member_id;
	private String member_tel1;
	private String member_tel2;
	private String member_email;
	private String member_block;

	public InquiryJoinDTO() {
		// TODO Auto-generated constructor stub
	}

	public InquiryJoinDTO(int inquiry_idx, int member_idx, String inquiry_subject, String inquiry_content,
			String inquiry_filename, Date inquiry_writedate, String inquiry_answer, String inquiry_astatus,
			int inquiry_type, String member_id, String member_tel1, String member_tel2, String member_email,
			String member_block) {
		super();
		this.inquiry_idx = inquiry_idx;
		this.member_idx = member_idx;
		this.inquiry_subject = inquiry_subject;
		this.inquiry_content = inquiry_content;
		this.inquiry_filename = inquiry_filename;
		this.inquiry_writedate = inquiry_writedate;
		this.inquiry_answer = inquiry_answer;
		this.inquiry_astatus = inquiry_astatus;
		this.inquiry_type = inquiry_type;
		this.member_id = member_id;
		this.member_tel1 = member_tel1;
		this.member_tel2 = member_tel2;
		this.member_email = member_email;
		this.member_block = member_block;
	}

	public int getInquiry_idx() {
		return inquiry_idx;
	}

	public void setInquiry_idx(int inquiry_idx) {
		this.inquiry_idx = inquiry_idx;
	}

	public int getMember_idx() {
		return member_idx;
	}

	public void setMember_idx(int member_idx) {
		this.member_idx = member_idx;
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

	public int getInquiry_type() {
		return inquiry_type;
	}

	public void setInquiry_type(int inquiry_type) {
		this.inquiry_type = inquiry_type;
	}

	public String getMember_id() {
		return member_id;
	}

	public void setMember_id(String member_id) {
		this.member_id = member_id;
	}

	public String getMember_tel1() {
		return member_tel1;
	}

	public void setMember_tel1(String member_tel1) {
		this.member_tel1 = member_tel1;
	}

	public String getMember_tel2() {
		return member_tel2;
	}

	public void setMember_tel2(String member_tel2) {
		this.member_tel2 = member_tel2;
	}

	public String getMember_email() {
		return member_email;
	}

	public void setMember_email(String member_email) {
		this.member_email = member_email;
	}

	public String getMember_block() {
		return member_block;
	}

	public void setMember_block(String member_block) {
		this.member_block = member_block;
	}

	
	
	
}
