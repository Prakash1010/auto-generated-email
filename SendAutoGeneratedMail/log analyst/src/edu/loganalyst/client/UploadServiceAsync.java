package edu.loganalyst.client;

import com.google.gwt.user.client.rpc.AsyncCallback;

/**
 * The async counterpart of <code>GreetingService</code>.
 */
public interface UploadServiceAsync {
	void returnURL(AsyncCallback<String> callback)
			throws IllegalArgumentException;
}
