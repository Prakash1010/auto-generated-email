package edu.loganalyst.server;

import com.google.appengine.api.blobstore.BlobstoreService;
import com.google.appengine.api.blobstore.BlobstoreServiceFactory;
import com.google.appengine.api.datastore.DatastoreService;
import com.google.appengine.api.datastore.DatastoreServiceFactory;
import com.google.gwt.user.server.rpc.RemoteServiceServlet;

import edu.loganalyst.client.UploadService;

@SuppressWarnings("serial")
public class UploadServiceImpl  extends RemoteServiceServlet implements UploadService{

	@Override
	public String returnURL() throws IllegalArgumentException {
		DatastoreService datastore = DatastoreServiceFactory
				.getDatastoreService();
		System.out.println("______datastore------------"+datastore);
		 BlobstoreService blobstoreService = 
				 BlobstoreServiceFactory.getBlobstoreService(); 
		return blobstoreService.createUploadUrl("/uploadFile");
	}

	

}
