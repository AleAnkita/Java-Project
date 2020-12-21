package com.training.models;

import java.time.LocalDate;

public class Edible extends Products {
	private  String mfg;
	private String exp;
	private String foodType;

	public Edible() {
		super();
		// TODO Auto-generated constructor stub
	}


	public Edible(int itemCode, String itemName, double unitPrice, int quantity, String mfg, String exp,
			String foodType) {
		super(itemCode, itemName, unitPrice, quantity);
		this.mfg = mfg;
		this.exp = exp;
		this.foodType = foodType;
	}


	public Edible(int itemCode, String itemName, double unitPrice, int quantity) {
		super(itemCode, itemName, unitPrice, quantity);
		// TODO Auto-generated constructor stub
	}


	public String getMfg() {
		return mfg;
	}


	public void setMfg(String mfg) {
		this.mfg = mfg;
	}


	public String getExp() {
		return exp;
	}


	public void setExp(String exp) {
		this.exp = exp;
	}


	public String getFoodType() {
		return foodType;
	}


	public void setFoodType(String foodType) {
		this.foodType = foodType;
	}


	@Override
	public double calculateAmount() {
		// TODO Auto-generated method stub
		return super.calculateAmount();
	}
	

}
