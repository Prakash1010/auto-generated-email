package com.edu.inventorycontrol.client;

import java.util.List;
import java.util.Map;

import com.edu.inventorycontrol.shared.Product;
import com.google.gwt.user.client.rpc.AsyncCallback;

/**
 * The async counterpart of <code>GreetingService</code>.
 */
public interface ProductServiceAsync {
	void getProductList(AsyncCallback<Map<String, Product>> callback);
}
