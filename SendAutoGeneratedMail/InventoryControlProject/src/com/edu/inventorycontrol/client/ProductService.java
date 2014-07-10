package com.edu.inventorycontrol.client;

import java.util.List;
import java.util.Map;

import com.edu.inventorycontrol.shared.Product;
import com.google.gwt.user.client.rpc.RemoteService;
import com.google.gwt.user.client.rpc.RemoteServiceRelativePath;

/**
 * The client side stub for the RPC service.
 */
@RemoteServiceRelativePath("product")
public interface ProductService extends RemoteService {
	Map<String, Product> getProductList();
}
