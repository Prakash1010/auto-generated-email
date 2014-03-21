package edu.loganalyst.client.view;


import com.google.gwt.core.client.GWT;
import com.google.gwt.event.dom.client.ChangeEvent;
import com.google.gwt.event.dom.client.ChangeHandler;
import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.uibinder.client.UiBinder;
import com.google.gwt.uibinder.client.UiField;
import com.google.gwt.uibinder.client.UiHandler;
import com.google.gwt.user.client.Window;
import com.google.gwt.user.client.rpc.AsyncCallback;
import com.google.gwt.user.client.ui.Button;
import com.google.gwt.user.client.ui.Composite;
import com.google.gwt.user.client.ui.FileUpload;
import com.google.gwt.user.client.ui.FormPanel;
import com.google.gwt.user.client.ui.FormPanel.SubmitHandler;
import com.google.gwt.user.client.ui.Widget;
import com.google.gwt.user.client.ui.FormPanel.SubmitEvent;

import edu.loganalyst.client.UploadService;
import edu.loganalyst.client.UploadServiceAsync;

public class UploadLogFile extends Composite {
	
	private final String url = "";
	private static UploadLogFileUiBinder uiBinder = GWT
			.create(UploadLogFileUiBinder.class);

	interface UploadLogFileUiBinder extends UiBinder<Widget, UploadLogFile> {
	}

	public UploadLogFile() {
		initWidget(uiBinder.createAndBindUi(this));
		final UploadServiceAsync service = GWT.create(UploadService.class);
		uploader.addChangeHandler(new ChangeHandler() {
			@Override
			public void onChange(ChangeEvent event) {
				btnSubmit.setEnabled(false);
				service.returnURL(new AsyncCallback<String>() {
					@Override
					public void onFailure(Throwable caught) {
						Window.alert(caught.toString());
					}

					@Override
					public void onSuccess(String result) {
						Window.alert("Success URL" + result);
						btnSubmit.setEnabled(true);
						formPanel.setAction(result);
					}
				});
			}
		});
		
		formPanel.addSubmitHandler(new SubmitHandler() {
			
			@Override
			public void onSubmit(SubmitEvent event) {
				formPanel.setEncoding(FormPanel.ENCODING_MULTIPART);
				formPanel.setMethod(FormPanel.METHOD_POST);
			}
		});
	}

	@UiField(provided = true)
	FormPanel formPanel = new FormPanel();

	@UiField(provided = true)
	FileUpload uploader = new FileUpload();

	@UiField(provided = true)
	Button btnSubmit = new Button();

	@UiHandler("btnSubmit")
	void onClickButton(ClickEvent e) {
		formPanel.submit();
		btnSubmit.setEnabled(false);
	}

}
