package com.edu.inventorycontrol.client.view;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

import com.edu.inventorycontrol.client.InventoryStockServiceClientImpl;
import com.edu.inventorycontrol.client.ProductServiceClientImpl;
import com.edu.inventorycontrol.shared.Product;
import com.google.gwt.core.client.GWT;
import com.google.gwt.event.dom.client.BlurEvent;
import com.google.gwt.event.dom.client.BlurHandler;
import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.event.dom.client.ClickHandler;
import com.google.gwt.event.dom.client.KeyCodes;
import com.google.gwt.event.dom.client.KeyDownEvent;
import com.google.gwt.event.dom.client.KeyDownHandler;
import com.google.gwt.i18n.client.DateTimeFormat;
import com.google.gwt.uibinder.client.UiBinder;
import com.google.gwt.user.client.ui.Composite;
import com.google.gwt.user.client.ui.FlexTable;
import com.google.gwt.user.client.ui.HorizontalPanel;
import com.google.gwt.user.client.ui.Label;
import com.google.gwt.user.client.ui.RootPanel;
import com.google.gwt.user.client.ui.TextBox;
import com.google.gwt.user.client.ui.VerticalPanel;
import com.google.gwt.user.client.ui.Widget;
import com.google.gwt.user.datepicker.client.DateBox;

public class EnterStock extends Composite {
	public Map<String, Product>  productMap;
	
	private static EnterStockUiBinder uiBinder = GWT
			.create(EnterStockUiBinder.class);

	interface EnterStockUiBinder extends UiBinder<Widget, EnterStock> {
	}

	public EnterStock() {
		initWidget(uiBinder.createAndBindUi(this));
		ProductServiceClientImpl getProductList = new ProductServiceClientImpl(
				"product", this);
		getProductList.getProductList();
		InventoryStockServiceClientImpl enterStock = new InventoryStockServiceClientImpl("inventorystock", this);
		enterStock.addStock(null);
	}

	public void addTableDisplay(Map<String, Product> productMap) {

		// Create a DateBox
		DateTimeFormat dateFormat = DateTimeFormat.getFormat("MM/dd/yyyy");
		DateBox dateBox = new DateBox();
		dateBox.setFormat(new DateBox.DefaultFormat(dateFormat));

		Label selectLabel = new Label("Enter date for which you want to enter the stock:");
		HorizontalPanel datePanel = new HorizontalPanel();
		datePanel.add(selectLabel);
		datePanel.add(dateBox);
		List<Product> productList = new ArrayList<Product>();
		for (Entry<String, Product> entry : productMap.entrySet())
		{
		    productList.add(entry.getValue());
		}
		FlexTable flexTable = createFlexTable(productList);
		VerticalPanel hp = new VerticalPanel();
		hp.add(datePanel);
		hp.add(flexTable);
		RootPanel.get("body").add(hp);
	}

	private FlexTable createFlexTable(List<Product> productList) {
		final FlexTable flexTable = new FlexTable();
		flexTable.setBorderWidth(1);
		// Set table headers
		flexTable.setText(0, 0, "Product Name");
		flexTable.setText(0, 1, "Product ID");
		flexTable.setText(0, 2, "Add Stock");
		int count = 0;	
		for (Product product : productList) {
			count++;
			flexTable.setText(count, 0, product.getProductName());
			flexTable.setText(count, 1, product.getProductId());
			flexTable.setText(count, 2, "");

			flexTable.addClickHandler(new ClickHandler() {
				public void onClick(ClickEvent event) {
					final int cellIndex = flexTable.getCellForEvent(event)
							.getCellIndex();
					final int rowIndex = flexTable.getCellForEvent(event)
							.getRowIndex();
					final TextBox textBox = new TextBox();
					textBox.addKeyDownHandler(new KeyDownHandler() {
						@Override
						public void onKeyDown(KeyDownEvent event) {
							int code = event.getNativeKeyCode();
							if (KeyCodes.KEY_ENTER == code) {
								flexTable.setText(rowIndex, cellIndex,
										textBox.getText());
							}
						}
					});
					textBox.addBlurHandler(new BlurHandler() {

						@Override
						public void onBlur(BlurEvent event) {
							flexTable.setText(rowIndex, cellIndex,
									textBox.getText());
						}

					});
					if (rowIndex > 0 && cellIndex > 1) {
						flexTable.setWidget(rowIndex, cellIndex, textBox);
					}
					// You may also need something like this
					textBox.setFocus(true);
				}
			});
		}
		return null;
	}
}
