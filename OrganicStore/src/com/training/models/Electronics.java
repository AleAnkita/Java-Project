package com.training.models;

public class Electronics extends Products {
	public Electronics(int itemCode, String itemName, double unitPrice, int quantity) {
		super(itemCode, itemName, unitPrice, quantity);
		// TODO Auto-generated constructor stub
	}

	private double wattage;
	private String size;
	private int warranty;
	
	
	public Electronics() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Electronics(int itemCode, String itemName, double unitPrice, int quantity, double wattage, String size,
			int warranty) {
		super(itemCode, itemName, unitPrice, quantity);
		this.wattage = wattage;
		this.size = size;
		this.warranty = warranty;
	}

	public double getWattage() {
		return wattage;
	}

	public void setWattage(double wattage) {
		this.wattage = wattage;
	}

	public String getSize() {
		return size;
	}

	public void setSize(String size) {
		this.size = size;
	}

	public int getWarranty() {
		return warranty;
	}

	public void setWarranty(int warranty) {
		this.warranty = warranty;
	}

	@Override
	public double calculateAmount() {
		// TODO Auto-generated method stub
		return super.calculateAmount();
	}
	

}
