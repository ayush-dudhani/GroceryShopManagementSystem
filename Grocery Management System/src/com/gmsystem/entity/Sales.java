package com.gmsystem.entity;

public class Sales {
	private int item_id;
	private String item_name;
	private int quantity_sold;
	private float total_amount;
	private String sold_date;
	private String category;
	
	
	public Sales(int item_id, String item_name, int quantity_sold, float total_amount, String sold_date, String category) {
		super();
		this.item_id = item_id;
		this.item_name = item_name;
		this.quantity_sold = quantity_sold;
		this.total_amount = total_amount;
		this.sold_date = sold_date;
		this.category = category;
	}
	
	public int getItem_id() {
		return item_id;
	}
	public void setItem_id(int item_id) {
		this.item_id = item_id;
	}
	public String getItem_name() {
		return item_name;
	}
	public void setItem_name(String item_name) {
		this.item_name = item_name;
	}
	public int getQuantitySold() {
		return quantity_sold;
	}
	public void setQuantitySold(int quantity) {
		this.quantity_sold = quantity;
	}
	public float getTotal_amount() {
		return total_amount;
	}
	public void setTotal_amount(float total_amount) {
		this.total_amount = total_amount;
	}
	public String getSold_date() {
		return sold_date;
	}
	public void setSold_date(String sold_date) {
		this.sold_date = sold_date;
	}
	public String getCategory() {
		return category;
	}
	public void setCategory(String category) {
		this.category = category;
	}
	
}
