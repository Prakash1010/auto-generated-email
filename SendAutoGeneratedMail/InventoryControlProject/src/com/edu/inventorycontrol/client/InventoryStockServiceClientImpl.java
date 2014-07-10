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

	public InventoryStockServiceClientImpl(String url_locationofservlet,
			Object callingClass) {
		this.service = GWT.create(InventoryStockService.class);
		ServiceDefTarget endPoint = (ServiceDefTarget) this.service;
		endPoint.setServiceEntryPoint(url_locationofservlet);
		this.enterStock = (EnterStock) callingClass;
	}

	public void addStock(List<InventoryStockItem> inventoryStockItems) {
		this.service.addStock(inventoryStockItems, new AddStockCallBack());
	}

	public void displayStock() {
		this.service.displayStock(new DisplayStockCallBack());
	}

	private class DisplayStockCallBack implements
			AsyncCallback<List<InventoryStockItem>> {

		@Override
		public void onFailure(Throwable caught) {
			// TODO Auto-generated method stub

		}

		@Override
		public void onSuccess(List<InventoryStockItem> result) {
			// TODO Auto-generated method stub

		}

	}

	private class AddStockCallBack implements AsyncCallback<Boolean> {

		@Override
		public void onFailure(Throwable caught) {
			Window.alert("Failure in inventory client impl");
		}

		@Override
		public void onSuccess(Boolean result) {
			Window.alert("Success in inventory client impl");
		}

	}
}
