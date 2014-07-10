package com.edu.inventorycontrol.client.view;

import com.google.gwt.user.client.Command;
import com.google.gwt.user.client.ui.Composite;
import com.google.gwt.user.client.ui.MenuBar;
import com.google.gwt.user.client.ui.MenuItem;
import com.google.gwt.user.client.ui.RootPanel;

public class Menu extends Composite {
	private MenuBar menuBar = new MenuBar(true);
	MenuItem home;
	MenuItem enterSalesDetails;
	
	public Menu() {
		initWidget(this.menuBar);
		/*String linkname="SCM_L4KissFlow";
		GetLinkServiceClientImpl getLinkServiceClientImpl = new GetLinkServiceClientImpl("getLink",Menu.this);
		getLinkServiceClientImpl.getKissFlowLink(linkname);*/
		menuBar.setAutoOpen(true);
		menuBar.setSize("100%", "32px");
		menuBar.setAnimationEnabled(true);
		//////menuBar.addSeparator();

		final String imageHome = "<NOBR><img src='/images/home.jpg' height='30px' width='30px' style='vertical-align:middle'/>&nbsp;<span >Home</span></NOBR>";

		home = new MenuItem(imageHome, true, new Command() {
			public void execute() {
				RootPanel.get("body").clear();
				RootPanel.get("body").add(new DisplayProduct());
				home.setStyleName("selectedButton");
				//home.setEnabled(false);
			}
		});
		menuBar.addItem(home);
		home.setWidth("100");
		////menuBar.addSeparator();
		
		
		//final String image1 = "<NOBR><img src='/images/fileUpload.png' height='30px' width='30px' style='vertical-align:middle'/><span >Data Upload</NOBR></span>";
		final String imageSales = "<NOBR><img src='/images/home.jpg' height='30px' width='30px' style='vertical-align:middle'/><span >home</NOBR></span>";

		enterSalesDetails = new MenuItem(imageHome, true, new Command() {
			public void execute() {
				enterSalesDetails.setStyleName("selectedButton");
				enterSalesDetails.setEnabled(false);
				
			}
		});

		menuBar.addItem(home);
		enterSalesDetails.setWidth("100");
	}

		

}