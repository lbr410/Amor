package com.amor.inventory.model;

public class InventoryDTO {

	private int inventory_idx;
	private String inventory_category;
	private String inventory_name;
	private int inventory_price;
	private int inventory_count;
	private String inventory_img;
	
	public InventoryDTO() {
		System.out.println("inventoryDTO() 호출됨");
	}

	public InventoryDTO(int inventory_idx, String inventory_category, String inventory_name, int inventory_price,
			int inventory_count, String inventory_img) {
		super();
		this.inventory_idx = inventory_idx;
		this.inventory_category = inventory_category;
		this.inventory_name = inventory_name;
		this.inventory_price = inventory_price;
		this.inventory_count = inventory_count;
		this.inventory_img = inventory_img;
	}

	public int getInventory_idx() {
		return inventory_idx;
	}

	public void setInventory_idx(int inventory_idx) {
		this.inventory_idx = inventory_idx;
	}

	public String getInventory_category() {
		return inventory_category;
	}

	public void setInventory_category(String inventory_category) {
		this.inventory_category = inventory_category;
	}

	public String getInventory_name() {
		return inventory_name;
	}

	public void setInventory_name(String inventory_name) {
		this.inventory_name = inventory_name;
	}

	public int getInventory_price() {
		return inventory_price;
	}

	public void setInventory_price(int inventory_price) {
		this.inventory_price = inventory_price;
	}

	public int getInventory_count() {
		return inventory_count;
	}

	public void setInventory_count(int inventory_count) {
		this.inventory_count = inventory_count;
	}

	public String getInventory_img() {
		return inventory_img;
	}

	public void setInventory_img(String inventory_img) {
		this.inventory_img = inventory_img;
	}
	
	
}
