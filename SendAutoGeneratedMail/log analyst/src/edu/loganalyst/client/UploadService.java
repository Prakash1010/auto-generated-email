package edu.loganalyst.client;

import com.google.gwt.user.client.rpc.RemoteService;
import com.google.gwt.user.client.rpc.RemoteServiceRelativePath;

/**
 * The client side stub for the RPC service.
 */
@RemoteServiceRelativePath("upload")
public interface UploadService extends RemoteService {
	String returnURL() throws IllegalArgumentException;
}
