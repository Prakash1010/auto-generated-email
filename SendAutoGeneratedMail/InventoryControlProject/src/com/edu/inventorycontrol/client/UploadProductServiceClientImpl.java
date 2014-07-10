package com.edu.inventorycontrol.client;


import com.edu.inventorycontrol.client.view.UploadProduct;
import com.google.gwt.core.client.GWT;
import com.google.gwt.user.client.rpc.ServiceDefTarget;

public class UploadProductServiceClientImpl {

	private ProductServiceAsync service;
	private UploadProduct uploadProduct;

	public UploadProductServiceClientImpl(String url_locationofservlet) {
		this.service = GWT.create( ProductService.class);
		ServiceDefTarget endPoint = (ServiceDefTarget) this.service;
		endPoint.setServiceEntryPoint(url_locationofservlet);
	}

}
