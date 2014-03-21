package edu.loganalyst.client;

import com.google.gwt.core.client.EntryPoint;
import com.google.gwt.user.client.ui.RootPanel;
import com.google.gwt.user.client.ui.VerticalPanel;

import edu.loganalyst.client.view.UploadLogFile;

/**
 * Entry point classes define <code>onModuleLoad()</code>.
 */
public class Log_analyst implements EntryPoint {

	public void onModuleLoad() {
		VerticalPanel panel = new VerticalPanel();
		UploadLogFile uploadLogFile = new UploadLogFile();
		panel.add(uploadLogFile);
		RootPanel.get().add(panel);
		
	}
}
