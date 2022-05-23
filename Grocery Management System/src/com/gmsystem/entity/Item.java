 package com.gmsystem.entity;

public class Item {
	private String item_name;
	private String manu_date;
	private String exp_date;
	private int quantity;
	private float price;
	private String category;
	
	public Item(String item_name, String manu_date, String exp_date, int quantity, float price, String category) {
		super();
		this.item_name = item_name;
		this.manu_date = manu_date;
		this.exp_date = exp_date;
		this.quantity = quantity;
		this.price = price;
		this.category = category;
	}

	public String getItem_name() {
		return item_name;
	}

	public void setItem_name(String item_name) {
		this.item_name = item_name;
	}

	public String getManu_date() {
		return manu_date;
	}

	public void setManu_date(String manu_date) {
		this.manu_date = manu_date;
	}

	public String getExp_date() {
		return exp_date;
	}

	public void setExp_date(String exp_date) {
		this.exp_date = exp_date;
	}

	public int getQuantity() {
		return quantity;
	}

	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}

	public float getPrice() {
		return price;
	}

	public void setPrice(float price) {
		this.price = price;
	}

	public String getCategory() {
		return category;
	}

	public void setCategory(String category) {
		this.category = category;
	} 
	
}
