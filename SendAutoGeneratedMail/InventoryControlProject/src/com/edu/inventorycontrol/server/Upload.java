package com.edu.inventorycontrol.server;

import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ExecutionException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.fileupload.FileItemFactory;
import org.apache.commons.fileupload.FileItemIterator;
import org.apache.commons.fileupload.FileItemStream;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;
import org.apache.poi.util.IOUtils;

import com.edu.inventorycontrol.server.util.ExcelParsingUtil;
import com.edu.inventorycontrol.shared.Product;


public class Upload extends HttpServlet {

	
	private static final long serialVersionUID = 1L;
	private static String uploadedFileName;
	private static boolean isUploadSuccessful = true;
	
	@Override
	public void doPost(HttpServletRequest req, HttpServletResponse res)
			throws ServletException, IOException {
		
		FileItemFactory fileItemFactory = new DiskFileItemFactory();
		ServletFileUpload servletFileUpload = new ServletFileUpload(
				fileItemFactory);
		isUploadSuccessful = true;
		try 
		{
			FileItemIterator fileItemIterator = servletFileUpload
					.getItemIterator(req);
			while (fileItemIterator.hasNext()) 
			{
				// System.out.println("in file iterator loop");
				FileItemStream fileItemStream = (FileItemStream) fileItemIterator
						.next();
				if (fileItemStream.isFormField()) 
				{
					System.out.print(fileItemStream.getFieldName() + " : " +fileItemStream.getName());
					uploadedFileName=fileItemStream.getName();
				} 
				else if (fileItemStream.getFieldName().equals("myFile")) 
				{
					uploadedFileName=fileItemStream.getName();
					InputStream inputStream = fileItemStream.openStream();
					InputStream stream = new ByteArrayInputStream(IOUtils.toByteArray(inputStream));
					List<List<Object>> table = ExcelParsingUtil.readExcellData(stream);
					if (table == null) 
					{
						isUploadSuccessful = false;
					}
					else{
					List<Product> list;
					//make productlist
					
					
					}
				}
				
			}
		}
		catch (Exception e) 
		{
			isUploadSuccessful = false;
			//message="Unknown Error";
			System.out.println(e.getMessage());
			e.printStackTrace();
		}

	}

	private void insertUploadDetails(String uploadedFileName, String Message)
			throws IOException {
		System.out.println("Inside insert upload details");
		Calendar calendar = Calendar.getInstance();
		
	}

	// converting a list of list of objects to a list of Products...
	private List<Product> createProductSetup(List<List<Object>> table) {
		
				
		return null;
	}

	private void insertProduct(List<Product> list) throws IOException {
	
	}

}