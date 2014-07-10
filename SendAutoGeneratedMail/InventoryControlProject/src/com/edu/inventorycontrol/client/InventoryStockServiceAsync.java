package com.edu.inventorycontrol.client;

import java.util.List;

import com.edu.inventorycontrol.shared.InventoryStockItem;
import com.google.gwt.user.client.rpc.AsyncCallback;

/**
 * The async counterpart of <code>GreetingService</code>.
 */
public interface InventoryStockServiceAsync {
	
	void enterStock(List<InventoryStockItem> stock,
			AsyncCallback<Boolean> callback);	
	void displayStock(AsyncCallback<List<InventoryStockItem>> callback);
	
}
