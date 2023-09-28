package com.amor.ads.model;

public class AdsDTO {

	private int ads_idx;
	private String ads_name;
	private String ads_url;
	private String ads_filename;
	
	public AdsDTO() {
		// TODO Auto-generated constructor stub
	}

	public AdsDTO(int ads_idx, String ads_name, String ads_url, String ads_filename) {
		super();
		this.ads_idx = ads_idx;
		this.ads_name = ads_name;
		this.ads_url = ads_url;
		this.ads_filename = ads_filename;
	}

	public int getAds_idx() {
		return ads_idx;
	}

	public void setAds_idx(int ads_idx) {
		this.ads_idx = ads_idx;
	}

	public String getAds_name() {
		return ads_name;
	}

	public void setAds_name(String ads_name) {
		this.ads_name = ads_name;
	}

	public String getAds_url() {
		return ads_url;
	}

	public void setAds_url(String ads_url) {
		this.ads_url = ads_url;
	}

	public String getAds_filename() {
		return ads_filename;
	}

	public void setAds_filename(String ads_filename) {
		this.ads_filename = ads_filename;
	}
	
	
}
