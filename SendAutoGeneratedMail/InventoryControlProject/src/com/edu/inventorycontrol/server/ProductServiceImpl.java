package com.edu.inventorycontrol.server;

import java.util.ArrayList;
import java.util.List;

import com.edu.inventorycontrol.client.ProductService;
import com.edu.inventorycontrol.server.util.Util;
import com.edu.inventorycontrol.shared.Product;
import com.google.appengine.api.datastore.DatastoreService;
import com.google.appengine.api.datastore.DatastoreServiceFactory;
import com.google.appengine.api.datastore.Entity;
import com.google.gwt.user.server.rpc.RemoteServiceServlet;

/**
 * The server side implementation of the RPC service.
 */
@SuppressWarnings("serial")
public class ProductServiceImpl extends RemoteServiceServlet implements
		ProductService {

	@Override
	public List<Product> getProductList() {
		DatastoreService datastore = DatastoreServiceFactory.getDatastoreService();
		/*Entity product = new Entity("Product", "KF-25");
		product.setProperty("ID", "KF-25");
		product.setProperty("Name", "productname1");
		product.setProperty("Percentage", 20);
		product.setProperty("Price", 200.00);
		datastore.put(product);
		product = new Entity("Product", "KF-50");
		product.setProperty("ID", "KF-50");
		product.setProperty("Name", "productname2");
		product.setProperty("Percentage", 25);
		product.setProperty("Price", 400.00);
		datastore.put(product);
		product = new Entity("Product", "KF-100");
		product.setProperty("ID", "KF-100");
		product.setProperty("Name", "productname3");
		product.setProperty("Percentage", 25);
		product.setProperty("Price", 800.00);
		datastore.put(product);*/
		List<Product> prodList = new ArrayList<Product>();
		Iterable<Entity> itrEntity = Util.listEntities("Product", null, null);
		for(Entity productEntity: itrEntity){
			Product product = new Product();
			product.setProductId(productEntity.getProperty("ID").toString());
			product.setProductName(productEntity.getProperty("Name").toString());
			product.setPrice(Double.parseDouble(productEntity.getProperty("Price").toString()));
			product.setPercentage(Double.parseDouble(productEntity.getProperty("Percentage").toString()));
			prodList.add(product);
		}
		
		return prodList;
	}
}
