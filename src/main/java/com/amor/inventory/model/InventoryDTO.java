package com.amor.inventory.model;

public class InventoryDTO {

	private int inventory_idx;
	private String inventory_num;
	private String inventory_category;
	private String inventory_name;
	private String inventory_brand;
	private String inventory_unit;
	private int inventory_optimal;
	private int inventory_current;
	private int inventory_deviation;
	
	public InventoryDTO() {
		// TODO Auto-generated constructor stub
	}

	public InventoryDTO(int inventory_idx, String inventory_num, String inventory_category, String inventory_name,
			String inventory_brand, String inventory_unit, int inventory_optimal, int inventory_current,
			int inventory_deviation) {
		super();
		this.inventory_idx = inventory_idx;
		this.inventory_num = inventory_num;
		this.inventory_category = inventory_category;
		this.inventory_name = inventory_name;
		this.inventory_brand = inventory_brand;
		this.inventory_unit = inventory_unit;
		this.inventory_optimal = inventory_optimal;
		this.inventory_current = inventory_current;
		this.inventory_deviation = inventory_deviation;
	}

	public int getInventory_idx() {
		return inventory_idx;
	}

	public void setInventory_idx(int inventory_idx) {
		this.inventory_idx = inventory_idx;
	}

	public String getInventory_num() {
		return inventory_num;
	}

	public void setInventory_num(String inventory_num) {
		this.inventory_num = inventory_num;
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

	public String getInventory_brand() {
		return inventory_brand;
	}

	public void setInventory_brand(String inventory_brand) {
		this.inventory_brand = inventory_brand;
	}

	public String getInventory_unit() {
		return inventory_unit;
	}

	public void setInventory_unit(String inventory_unit) {
		this.inventory_unit = inventory_unit;
	}

	public int getInventory_optimal() {
		return inventory_optimal;
	}

	public void setInventory_optimal(int inventory_optimal) {
		this.inventory_optimal = inventory_optimal;
	}

	public int getInventory_current() {
		return inventory_current;
	}

	public void setInventory_current(int inventory_current) {
		this.inventory_current = inventory_current;
	}

	public int getInventory_deviation() {
		return inventory_deviation;
	}

	public void setInventory_deviation(int inventory_deviation) {
		this.inventory_deviation = inventory_deviation;
	}
	
	
}
