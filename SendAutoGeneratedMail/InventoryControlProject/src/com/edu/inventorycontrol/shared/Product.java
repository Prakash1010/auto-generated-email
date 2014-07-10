package com.edu.inventorycontrol.shared;

import java.io.Serializable;

public class Product implements Serializable{
	
	private static final long serialVersionUID = 1L;
	String productId;
	String productName;
	double percentage;
	double price;
	
	public double getPrice() {
		return price;
	}
	public void setPrice(double price) {
		this.price = price;
	}
	public String getProductId() {
		return productId;
	}
	public void setProductId(String productId) {
		this.productId = productId;
	}
	public String getProductName() {
		return productName;
	}
	public void setProductName(String productName) {
		this.productName = productName;
	}
	public double getPercentage() {
		return percentage;
	}
	public void setPercentage(double percentage) {
		this.percentage = percentage;
	}
	
}
