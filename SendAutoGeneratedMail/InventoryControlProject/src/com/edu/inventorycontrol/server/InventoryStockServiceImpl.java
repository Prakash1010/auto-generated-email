package com.edu.inventorycontrol.server;

import java.util.List;

import com.edu.inventorycontrol.client.InventoryStockService;
import com.edu.inventorycontrol.shared.InventoryStockItem;
import com.google.appengine.api.datastore.DatastoreService;
import com.google.appengine.api.datastore.DatastoreServiceFactory;
import com.google.gwt.user.server.rpc.RemoteServiceServlet;

/**
 * The server side implementation of the RPC service.
 */
@SuppressWarnings("serial")
public class InventoryStockServiceImpl extends RemoteServiceServlet implements
		InventoryStockService {


	@Override
	public boolean enterStock(List<InventoryStockItem> stock) {
		DatastoreService datastore = DatastoreServiceFactory.getDatastoreService();
		/*System.out.println("called...");
		Entity stockEntry = new Entity("Inventory");
		stockEntry.setProperty("ID", "KF-25");
		stockEntry.setProperty("Date", "20140709");
		stockEntry.setProperty("Quantity", 2000);
		datastore.put(stockEntry);
		stockEntry.setProperty("ID", "KF-50");
		stockEntry.setProperty("Date", "20140709");
		stockEntry.setProperty("Quantity", 200);
		datastore.put(stockEntry);
		stockEntry.setProperty("ID", "KF-100");
		stockEntry.setProperty("Date", "20140709");
		stockEntry.setProperty("Quantity", 20);
		datastore.put(stockEntry);*/
		return true;
	}

	@Override
	public List<InventoryStockItem> displayStock() {
		// TODO Auto-generated method stub
		return null;
	}
}
