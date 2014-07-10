package com.edu.inventorycontrol.client;

import java.util.List;

import com.edu.inventorycontrol.client.view.DisplayProduct;
import com.edu.inventorycontrol.client.view.EnterStock;
import com.edu.inventorycontrol.shared.Product;
import com.google.gwt.core.client.GWT;
import com.google.gwt.user.client.Window;
import com.google.gwt.user.client.rpc.AsyncCallback;
import com.google.gwt.user.client.rpc.ServiceDefTarget;

public class ProductServiceClientImpl {

	private ProductServiceAsync service;
	private DisplayProduct displayProduct;
	private EnterStock enterStock;

	public ProductServiceClientImpl(String url_locationofservlet,
			DisplayProduct displayProduct) {
		this.service = GWT.create(ProductService.class);
		ServiceDefTarget endPoint = (ServiceDefTarget) this.service;
		endPoint.setServiceEntryPoint(url_locationofservlet);
		this.displayProduct = displayProduct;
	}

	public ProductServiceClientImpl(String url_locationofservlet,
			EnterStock enterStock) {
		this.service = GWT.create(ProductService.class);
		ServiceDefTarget endPoint = (ServiceDefTarget) this.service;
		endPoint.setServiceEntryPoint(url_locationofservlet);
		this.enterStock = enterStock;
	}

	public void getProductList() {
		this.service.getProductList(new DefaultCallBack());
	}

	private class DefaultCallBack implements AsyncCallback<List<Product>> {

		@Override
		public void onFailure(Throwable caught) {
			Window.alert("Failure");

		}

		@Override
		public void onSuccess(List<Product> result) {
			if (displayProduct != null) {
				displayProduct.addTableDisplay(result);
			}
			else if(enterStock != null){
				enterStock.addTableDisplay(result);
			}
		}

	}

}
