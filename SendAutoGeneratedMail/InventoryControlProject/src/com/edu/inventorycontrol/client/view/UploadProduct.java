package com.edu.inventorycontrol.client.view;

import com.google.gwt.core.client.GWT;
import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.uibinder.client.UiBinder;
import com.google.gwt.uibinder.client.UiField;
import com.google.gwt.uibinder.client.UiHandler;
import com.google.gwt.user.client.Window;
import com.google.gwt.user.client.ui.Button;
import com.google.gwt.user.client.ui.Composite;
import com.google.gwt.user.client.ui.FileUpload;
import com.google.gwt.user.client.ui.FormPanel;
import com.google.gwt.user.client.ui.Widget;

public class UploadProduct extends Composite{

	private static UploadProductUiBinder uiBinder = GWT
			.create(UploadProductUiBinder.class);

	interface UploadProductUiBinder extends UiBinder<Widget, UploadProduct> {
	}

	public UploadProduct() {
		initWidget(uiBinder.createAndBindUi(this));
	}

	@UiField(provided = true)
	FormPanel formPanel = new FormPanel();
	
	@UiField(provided = true)
	FileUpload uploader = new FileUpload();
	
	@UiField(provided = true)
	Button btnSubmit = new Button();
	
	@UiHandler("uploader")
	void onChangeFileUpload(ClickEvent e) {
		formPanel.setAction("/uploadFile");
	}
	
	@UiHandler("btnSubmit")
	void onClickButton(ClickEvent e) {
		formPanel.submit();
		Window.alert("SUBMITTED");
	}	
	
}
