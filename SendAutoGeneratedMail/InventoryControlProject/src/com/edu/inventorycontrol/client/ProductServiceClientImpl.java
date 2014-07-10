package com.edu.inventorycontrol.client;

import java.util.List;
import java.util.Map;

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

	private class DefaultCallBack implements AsyncCallback<Map<String, Product>> {

		@Override
		public void onFailure(Throwable caught) {
			Window.alert("Failure in display product");

		}

		@Override
		public void onSuccess(Map<String, Product> productMap) {
			Window.alert("SUCCESS "+productMap+"");
			if (displayProduct != null) {
				displayProduct.addTableDisplay(productMap);
			}
			else if(enterStock != null){
				enterStock.productMap = productMap;
			}
		}

	}

}
