package com.edu.inventorycontrol.client;

import java.util.List;

import com.edu.inventorycontrol.shared.Product;
import com.google.gwt.user.client.rpc.AsyncCallback;

/**
 * The async counterpart of <code>GreetingService</code>.
 */
public interface UploadProductServiceAsync {
	
	void uploadProduct(AsyncCallback<List<Product>> callback);
}
