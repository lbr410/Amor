package com.amor.member.model;

import java.sql.*;


public class MemberDTO {
	
	private int member_idx;
	private String member_id;
	private String member_pwd;
	private String member_name;
	private String member_birth_year;
	private String member_birth_month;
	private String member_birth_day;
	private String member_gender;
	private String member_tel1;
	private String member_tel2;
	private String member_email;
	private String member_zip;
	private String member_addr1;
	private String member_addr2;
	private Date member_joindate;
	private String member_quit;
	private String member_block;
	private Date member_quitdate;
	
	public MemberDTO() {
		System.out.println("memberDTO() 호출됨");
	}
	
	public MemberDTO(int member_idx, String member_id, String member_pwd, String member_name) {
		super();
		this.member_idx = member_idx;
		this.member_id = member_id;
		this.member_pwd = member_pwd;
		this.member_name = member_name;
	}

	public MemberDTO(int member_idx, String member_id, String member_pwd, String member_name, String member_birth_year,
			String member_birth_month, String member_birth_day, String member_gender, String member_tel1,
			String member_tel2, String member_email, String member_zip, String member_addr1, String member_addr2,
			Date member_joindate, String member_quit, String member_block, Date member_quitdate) {
		super();
		this.member_idx = member_idx;
		this.member_id = member_id;
		this.member_pwd = member_pwd;
		this.member_name = member_name;
		this.member_birth_year = member_birth_year;
		this.member_birth_month = member_birth_month;
		this.member_birth_day = member_birth_day;
		this.member_gender = member_gender;
		this.member_tel1 = member_tel1;
		this.member_tel2 = member_tel2;
		this.member_email = member_email;
		this.member_zip = member_zip;
		this.member_addr1 = member_addr1;
		this.member_addr2 = member_addr2;
		this.member_joindate = member_joindate;
		this.member_quit = member_quit;
		this.member_block = member_block;
		this.member_quitdate = member_quitdate;
	}

	public int getMember_idx() {
		return member_idx;
	}

	public void setMember_idx(int member_idx) {
		this.member_idx = member_idx;
	}

	public String getMember_id() {
		return member_id;
	}

	public void setMember_id(String member_id) {
		this.member_id = member_id;
	}

	public String getMember_pwd() {
		return member_pwd;
	}

	public void setMember_pwd(String member_pwd) {
		this.member_pwd = member_pwd;
	}

	public String getMember_name() {
		return member_name;
	}

	public void setMember_name(String member_name) {
		this.member_name = member_name;
	}

	public String getMember_birth_year() {
		return member_birth_year;
	}

	public void setMember_birth_year(String member_birth_year) {
		this.member_birth_year = member_birth_year;
	}

	public String getMember_birth_month() {
		return member_birth_month;
	}

	public void setMember_birth_month(String member_birth_month) {
		this.member_birth_month = member_birth_month;
	}

	public String getMember_birth_day() {
		return member_birth_day;
	}

	public void setMember_birth_day(String member_birth_day) {
		this.member_birth_day = member_birth_day;
	}

	public String getMember_gender() {
		return member_gender;
	}

	public void setMember_gender(String member_gender) {
		this.member_gender = member_gender;
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

	public String getMember_zip() {
		return member_zip;
	}

	public void setMember_zip(String member_zip) {
		this.member_zip = member_zip;
	}

	public String getMember_addr1() {
		return member_addr1;
	}

	public void setMember_addr1(String member_addr1) {
		this.member_addr1 = member_addr1;
	}

	public String getMember_addr2() {
		return member_addr2;
	}

	public void setMember_addr2(String member_addr2) {
		this.member_addr2 = member_addr2;
	}

	public Date getMember_joindate() {
		return member_joindate;
	}

	public void setMember_joindate(Date member_joindate) {
		this.member_joindate = member_joindate;
	}

	public String getMember_quit() {
		return member_quit;
	}

	public void setMember_quit(String member_quit) {
		this.member_quit = member_quit;
	}

	public String getMember_block() {
		return member_block;
	}

	public void setMember_block(String member_block) {
		this.member_block = member_block;
	}

	public Date getMember_quitdate() {
		return member_quitdate;
	}

	public void setMember_quitdate(Date member_quitdate) {
		this.member_quitdate = member_quitdate;
	}
	
}
