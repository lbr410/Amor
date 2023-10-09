package com.amor.banner.model;

public class BannerDTO {

	private int banner_idx;
	private String banner_name;
	private String banner_url;
	private String banner_source;
	
	public BannerDTO() {
		// TODO Auto-generated constructor stub
	}
	
	public BannerDTO(int banner_idx, String banner_name, String banner_url, String banner_source) {
		super();
		this.banner_idx = banner_idx;
		this.banner_name = banner_name;
		this.banner_url = banner_url;
		this.banner_source = banner_source;
	}
	
	public int getBanner_idx() {
		return banner_idx;
	}
	public void setBanner_idx(int banner_idx) {
		this.banner_idx = banner_idx;
	}
	public String getBanner_name() {
		return banner_name;
	}
	public void setBanner_name(String banner_name) {
		this.banner_name = banner_name;
	}
	public String getBanner_url() {
		return banner_url;
	}
	public void setBanner_url(String banner_url) {
		this.banner_url = banner_url;
	}
	public String getBanner_source() {
		return banner_source;
	}
	public void setBanner_source(String banner_source) {
		this.banner_source = banner_source;
	}
	
	
}
