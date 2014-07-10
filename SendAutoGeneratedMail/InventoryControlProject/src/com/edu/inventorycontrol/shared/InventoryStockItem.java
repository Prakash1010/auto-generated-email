package com.edu.inventorycontrol.shared;

import java.io.Serializable;

public class InventoryStockItem implements Serializable{

	private static final long serialVersionUID = 1L;
	String ID;
	String Date;
	String Quantity;

	public String getID() {
		return ID;
	}

	public void setID(String iD) {
		ID = iD;
	}

	public String getDate() {
		return Date;
	}

	public void setDate(String date) {
		Date = date;
	}

	public String getQuantity() {
		return Quantity;
	}

	public void setQuantity(String quantity) {
		Quantity = quantity;
	}
}
