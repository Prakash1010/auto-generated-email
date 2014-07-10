package com.edu.inventorycontrol.client;

import java.util.List;

import com.edu.inventorycontrol.client.view.EnterStock;
import com.edu.inventorycontrol.shared.InventoryStockItem;
import com.google.gwt.core.client.GWT;
import com.google.gwt.user.client.Window;
import com.google.gwt.user.client.rpc.AsyncCallback;
import com.google.gwt.user.client.rpc.ServiceDefTarget;

public class InventoryStockServiceClientImpl {

	private InventoryStockServiceAsync service;
	private EnterStock enterStock;

	public InventoryStockServiceClientImpl(String url_locationofservlet, Object callingClass) {
		this.service = GWT.create(InventoryStockService.class);
		ServiceDefTarget endPoint = (ServiceDefTarget) this.service;
		endPoint.setServiceEntryPoint(url_locationofservlet);
		this.enterStock = (EnterStock) callingClass;
	}

	public void enterStockt(List<InventoryStockItem> inventoryStockItems) {
		this.service.enterStock(inventoryStockItems, new DefaultCallBack());
	}

	private class DefaultCallBack implements AsyncCallback<Boolean> {

		@Override
		public void onFailure(Throwable caught) {
			Window.alert("Failure");		
		}


		@Override
		public void onSuccess(Boolean result) {
			Window.alert("Success");		
		}

		
		

		
	}
}
