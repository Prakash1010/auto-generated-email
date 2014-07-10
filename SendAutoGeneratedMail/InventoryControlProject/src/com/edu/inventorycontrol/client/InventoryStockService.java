package com.edu.inventorycontrol.client;

import java.util.List;

import com.edu.inventorycontrol.shared.InventoryStockItem;
import com.google.gwt.user.client.rpc.RemoteService;
import com.google.gwt.user.client.rpc.RemoteServiceRelativePath;

/**
 * The client side stub for the RPC service.
 */
@RemoteServiceRelativePath("inventorystock")
public interface InventoryStockService extends RemoteService {
	List<InventoryStockItem> displayStock();
	boolean addStock(List<InventoryStockItem> stock);
}
