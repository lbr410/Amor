package com.amor.product.model;

public class ProductDTO {
	private int product_idx;
	private String product_category;
	private String product_title;
	private int product_price;
	private String product_content;
	private String product_img;
	private String product_writedate;
	private String product_soldout;
	//test
	private String product_price2;
	
	public ProductDTO() {
		// TODO Auto-generated constructor stub
	}
	
	
	// +price2
	public ProductDTO(int product_idx, String product_category, String product_title, int product_price,
			String product_content, String product_img, String product_writedate, String product_soldout,
			String product_price2) {
		super();
		this.product_idx = product_idx;
		this.product_category = product_category;
		this.product_title = product_title;
		this.product_price = product_price;
		this.product_content = product_content;
		this.product_img = product_img;
		this.product_writedate = product_writedate;
		this.product_soldout = product_soldout;
		this.product_price2 = product_price2;
	}



	public ProductDTO(int product_idx, String product_category, String product_title, int product_price,
			String product_content, String product_img, String product_writedate, String product_soldout) {
		super();
		this.product_idx = product_idx;
		this.product_category = product_category;
		this.product_title = product_title;
		this.product_price = product_price;
		this.product_content = product_content;
		this.product_img = product_img;
		this.product_writedate = product_writedate;
		this.product_soldout = product_soldout;
	}

	public int getProduct_idx() {
		return product_idx;
	}

	public void setProduct_idx(int product_idx) {
		this.product_idx = product_idx;
	}

	public String getProduct_category() {
		return product_category;
	}

	public void setProduct_category(String product_category) {
		this.product_category = product_category;
	}

	public String getProduct_title() {
		return product_title;
	}

	public void setProduct_title(String product_title) {
		this.product_title = product_title;
	}

	public int getProduct_price() {
		return product_price;
	}

	public void setProduct_price(int product_price) {
		this.product_price = product_price;
	}

	public String getProduct_content() {
		return product_content;
	}

	public void setProduct_content(String product_content) {
		this.product_content = product_content;
	}

	public String getProduct_img() {
		return product_img;
	}

	public void setProduct_img(String product_img) {
		this.product_img = product_img;
	}

	public String getProduct_writedate() {
		return product_writedate;
	}

	public void setProduct_writedate(String product_writedate) {
		this.product_writedate = product_writedate;
	}

	public String getProduct_soldout() {
		return product_soldout;
	}

	public void setProduct_soldout(String product_soldout) {
		this.product_soldout = product_soldout;
	}
	
	
	public String getProduct_price2() {
		return product_price2;
	}

	public void setProduct_price2(String product_price2) {
		this.product_price2 = product_price2;
	}
	
	
}