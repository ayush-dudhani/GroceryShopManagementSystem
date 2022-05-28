 package com.gmsystem.entity;

public class Item {
	private int sr_no;
	private int item_id;
	private String item_name;
	private String manu_date;
	private String exp_date;
	private int quantity;
	private float price;
	private String category;
	public Item(int sr_no, int item_id, String item_name, String manu_date, String exp_date, int quantity, float price,
			String category) {
		super();
		this.sr_no = sr_no;
		this.item_id = item_id;
		this.item_name = item_name;
		this.manu_date = manu_date;
		this.exp_date = exp_date;
		this.quantity = quantity;
		this.price = price;
		this.category = category;
	}
	
	public Item(int item_id, String item_name, int quantity, float price,String mfg, String exp,	String category) {
		super();
		this.item_id = item_id;
		this.item_name = item_name;
		this.manu_date = mfg;
		this.exp_date = exp;
		this.quantity = quantity;
		this.price = price;
		this.category = category;
	}

	public int getSr_no() {
		return sr_no;
	}
	public void setSr_no(int sr_no) {
		this.sr_no = sr_no;
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
