package com.training.models;

public abstract class Products {

	public int itemCode;
	public String itemName;
	public double unitPrice;
	public int quantity;
	
	
	public Products() {
		super();
		// TODO Auto-generated constructor stub
	}


	public Products(int itemCode, String itemName, double unitPrice, int quantity) {
		super();
		this.itemCode = itemCode;
		this.itemName = itemName;
		this.unitPrice = unitPrice;
		this.quantity = quantity;
	}


	public int getItemCode() {
		return itemCode;
	}


	public void setItemCode(int itemCode) {
		this.itemCode = itemCode;
	}


	public String getItemName() {
		return itemName;
	}


	public void setItemName(String itemNmae) {
		this.itemName = itemNmae;
	}


	public double getUnitPrice() {
		return unitPrice;
	}


	public void setUnitPrice(double unitPrice) {
		this.unitPrice = unitPrice;
	}


	public int getQuantity() {
		return quantity;
	}


	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}


	public double calculateAmount() {
		return 0;
	}
	
	@Override
    public String toString() {
        return "    " + itemName + "        " + unitPrice + "        " + quantity + "        " + unitPrice*quantity;
    }
}
