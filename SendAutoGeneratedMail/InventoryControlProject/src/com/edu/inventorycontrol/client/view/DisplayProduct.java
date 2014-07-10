package com.edu.inventorycontrol.client.view;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

import com.edu.inventorycontrol.client.ProductServiceClientImpl;
import com.edu.inventorycontrol.shared.Product;
import com.google.gwt.core.client.GWT;
import com.google.gwt.uibinder.client.UiBinder;
import com.google.gwt.user.client.ui.Composite;
import com.google.gwt.user.client.ui.FlexTable;
import com.google.gwt.user.client.ui.HorizontalPanel;
import com.google.gwt.user.client.ui.RootPanel;
import com.google.gwt.user.client.ui.Widget;

public class DisplayProduct extends Composite {

	private static DisplayProductUiBinder uiBinder = GWT
			.create(DisplayProductUiBinder.class);

	interface DisplayProductUiBinder extends UiBinder<Widget, DisplayProduct> {
	}

	public DisplayProduct() {
		initWidget(uiBinder.createAndBindUi(this));
		ProductServiceClientImpl displayProduct = new ProductServiceClientImpl("product", this);
		displayProduct.getProductList();

	}

	public void addTableDisplay(Map<String, Product> productMap) {
		final FlexTable flexTable = new FlexTable();
		flexTable.setBorderWidth(1);
		// Set table headers
		flexTable.setText(0, 0, "Product Name");
		flexTable.setText(0, 1, "Product ID");
		flexTable.setText(0, 2, "Price");
		flexTable.setText(0, 3, "Percentage");
		int count = 0;

		List<Product> productList = new ArrayList<Product>();
		for (Entry<String, Product> entry : productMap.entrySet())
		{
		    productList.add(entry.getValue());
		}
		
		for (Product product : productList) {
			count++;
			flexTable.setText(count, 0, product.getProductName());
			flexTable.setText(count, 1, product.getProductId());
			flexTable.setText(count, 2, product.getPrice() + "");
			flexTable.setText(count, 3, product.getPercentage() + "");
		}
		HorizontalPanel hp = new HorizontalPanel();
		hp.add(flexTable);
		RootPanel.get("body").add(flexTable);
	}

}
