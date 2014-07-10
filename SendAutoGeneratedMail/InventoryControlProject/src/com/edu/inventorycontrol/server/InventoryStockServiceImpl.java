package com.edu.inventorycontrol.server;

import java.util.List;

import com.edu.inventorycontrol.client.InventoryStockService;
import com.edu.inventorycontrol.shared.InventoryStockItem;
import com.google.appengine.api.datastore.DatastoreService;
import com.google.appengine.api.datastore.DatastoreServiceFactory;
import com.google.appengine.api.datastore.Entity;
import com.google.appengine.api.datastore.Key;
import com.google.appengine.api.datastore.KeyFactory;
import com.google.gwt.user.server.rpc.RemoteServiceServlet;

/**
 * The server side implementation of the RPC service.
 */
@SuppressWarnings("serial")
public class InventoryStockServiceImpl extends RemoteServiceServlet implements
		InventoryStockService {


	@Override
	public boolean addStock(List<InventoryStockItem> stock) {
		DatastoreService datastore = DatastoreServiceFactory.getDatastoreService();
		System.out.println("called...");
		
//		Entity stockEntry1 = new Entity("Inventory");
//		stockEntry1.setProperty("ProductId", "KF-25");
//		stockEntry1.setProperty("Date", "20140709");
//		stockEntry1.setProperty("Quantity", 2000);
//		stockEntry1.setProperty("RemQuantity", 2000);	
//		stockEntry1.setProperty("Type", "ADD");
//		datastore.put(stockEntry1);
//		
//		Entity stockEntry2 = new Entity("Inventory");
//		stockEntry2.setProperty("ProductId", "KF-50");
//		stockEntry2.setProperty("Date", "20140709");
//		stockEntry2.setProperty("Quantity", 200);
//		stockEntry2.setProperty("RemQuantity", 200);	
//		stockEntry2.setProperty("Type", "ADD");
//		datastore.put(stockEntry2);
//		
//		Entity stockEntry3 = new Entity("Inventory");
//		stockEntry3 = new Entity("Inventory");
//		stockEntry3.setProperty("ProductId", "KF-100");
//		stockEntry3.setProperty("Date", "20140709");
//		stockEntry3.setProperty("Quantity", 20);
//		stockEntry3.setProperty("RemQuantity", 20);
//		stockEntry3.setProperty("Type", "ADD");
//		datastore.put(stockEntry3);
		return true;
	}

	@Override
	public List<InventoryStockItem> displayStock() {
		// TODO Auto-generated method stub
		return null;
	}
}
