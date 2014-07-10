package com.edu.inventorycontrol.client;

import com.edu.inventorycontrol.client.view.EnterStock;
import com.google.gwt.core.client.EntryPoint;
import com.google.gwt.user.client.ui.RootPanel;

/**
 * Entry point classes define <code>onModuleLoad()</code>.
 */
public class InventoryControlProject implements EntryPoint {
	/**
	 * The message displayed to the user when the server cannot be reached or
	 * returns an error.
	 */
	
	public void onModuleLoad() {
		//DisplayProduct displayProduct = new DisplayProduct();
		EnterStock enterStock = new EnterStock();
		RootPanel.get("body").add(enterStock);
	}
}
