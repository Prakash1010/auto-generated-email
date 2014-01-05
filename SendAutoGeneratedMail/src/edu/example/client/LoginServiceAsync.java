package edu.example.client;

import com.google.gwt.user.client.rpc.AsyncCallback;

import edu.example.shared.LoginInfo;

public interface LoginServiceAsync {

	void login(String requestUri, AsyncCallback<LoginInfo> callback);

}
