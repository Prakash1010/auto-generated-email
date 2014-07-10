package com.edu.inventorycontrol.client;

import java.util.List;

import com.edu.inventorycontrol.shared.Product;
import com.google.gwt.user.client.rpc.RemoteService;
import com.google.gwt.user.client.rpc.RemoteServiceRelativePath;

/**
 * The client side stub for the RPC service.
 */
@RemoteServiceRelativePath("uploadproduct")
public interface UploadProductService extends RemoteService {
	List<Product> uploadProduct();
}
