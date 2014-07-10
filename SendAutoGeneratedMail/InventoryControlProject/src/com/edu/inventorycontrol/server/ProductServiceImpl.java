package com.edu.inventorycontrol.server;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.logging.Level;
import java.util.logging.Logger;

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
	private static final Logger LOGGER = Logger.getLogger(ProductServiceImpl.class
			.getCanonicalName());
	@Override
	public Map<String, Product> getProductList() {
		DatastoreService datastore = DatastoreServiceFactory.getDatastoreService();
		LOGGER.log(Level.INFO, "In ProductServiceImpl");
		
		/*//Put data manually in to data store
		Key productKey = KeyFactory.createKey("Product", "KF-25");
		Entity product = new Entity(productKey);
		product.setProperty("ID", "KF-25");
		product.setProperty("Name", "product 1");
		product.setProperty("Percentage", 20);
		product.setProperty("Price", 200.00);
		datastore.put(product);
		
		productKey = KeyFactory.createKey("Product", "KF-50");
		product = new Entity(productKey);
		product.setProperty("ID", "KF-50");
		product.setProperty("Name", "product 2");
		product.setProperty("Percentage", 20);
		product.setProperty("Price", 200.00);
		datastore.put(product);

		productKey = KeyFactory.createKey("Product", "KF-100");
		product = new Entity(productKey);
		product.setProperty("ID", "KF-100");
		product.setProperty("Name", "product 3");
		product.setProperty("Percentage", 20);
		product.setProperty("Price", 200.00);
		datastore.put(product);*/

		
		/*// Retrieve data using key
		Key productKey = KeyFactory.createKey("Product", "KF-25");
		Entity product;
		try {
			product = datastore.get(productKey);
			System.out.println(product.getProperty("Name"));
			System.out.println(product.getProperty("ID"));
		} catch (EntityNotFoundException e) {
			System.out.println("Error while retrieving product");
			e.printStackTrace();
		}*/
		
		List<Product> prodList = new ArrayList<Product>();
		Iterable<Entity> itrEntity = Util.listEntities("Product", null, null);
		Map<String, Product> productMap = new LinkedHashMap<String, Product>();
		for(Entity productEntity: itrEntity){
			Product product = new Product();
			LOGGER.log(Level.INFO, "In ProductServiceImpl");
			product.setProductId(productEntity.getProperty("ID").toString());
			product.setProductName(productEntity.getProperty("Name").toString());
			product.setPrice(Double.parseDouble(productEntity.getProperty("Price").toString()));
			product.setPercentage(Double.parseDouble(productEntity.getProperty("Percentage").toString()));
			prodList.add(product);
			productMap.put(product.getProductId(), product);
		}
		
		return productMap;
	}
}
