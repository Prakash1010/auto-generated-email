package com.edu.inventorycontrol.shared;

import java.io.Serializable;

public class InventoryStockItem implements Serializable{

	private static final long serialVersionUID = 1L;
	String prodID;
	String date;
	String type;
	double quantity;
	double remainingQty;
	
	
	public String getProdID() {
		return prodID;
	}
	public void setProdID(String prodID) {
		this.prodID = prodID;
	}
	public String getDate() {
		return date;
	}
	public void setDate(String date) {
		this.date = date;
	}
	public double getQuantity() {
		return quantity;
	}
	public void setQuantity(double quantity) {
		this.quantity = quantity;
	}
	public double getRemainingQty() {
		return remainingQty;
	}
	public void setRemainingQty(double remainingQty) {
		this.remainingQty = remainingQty;
	}
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}

	
}
