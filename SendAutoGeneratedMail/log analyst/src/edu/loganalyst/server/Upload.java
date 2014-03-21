package edu.loganalyst.server;

import java.io.BufferedReader;
import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.List;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.appengine.api.blobstore.BlobKey;
import com.google.appengine.api.blobstore.BlobstoreService;
import com.google.appengine.api.blobstore.BlobstoreServiceFactory;

import edu.loganalyst.shared.LogData;

public class Upload extends HttpServlet {

	private static final long serialVersionUID = 1L;
	private BlobstoreService blobstoreService = BlobstoreServiceFactory
			.getBlobstoreService();
	private LogData data = null;
	private boolean isFound = false;
	private String lastRead = "";

	@Override
	public void doPost(HttpServletRequest req, HttpServletResponse res)
			throws ServletException, IOException {

		Map<String, List<BlobKey>> blobs = blobstoreService.getUploads(req);
		List<BlobKey> blobKeyList = blobs.get("myFile");

		if (blobKeyList == null) {
			res.sendRedirect("/");
		} else {

			BlobKey blobKey = new BlobKey(blobKeyList.get(0).getKeyString());
			// fetch the byte array
			byte[] b = blobstoreService.fetchData(blobKey, 0,
					BlobstoreService.MAX_BLOB_FETCH_SIZE - 1);
			InputStream is = new ByteArrayInputStream(b);
			BufferedReader br = null;

			try {

				String sCurrentLine;
				br = new BufferedReader(new InputStreamReader(is, "UTF-8"));
				br.markSupported();
				sCurrentLine = br.readLine();
				while (sCurrentLine != null) {
					//System.out.println("###Outer loop");
					//System.out.println("###Updated NEXT 1"+ sCurrentLine);
					isFound = false;
					data = new LogData();
					sCurrentLine.isEmpty();
					String pattern = "(^[0-9:]+)";
					// Create a Pattern object
					Pattern r = Pattern.compile(pattern);
					// Now create matcher object.
					Matcher m = r.matcher(sCurrentLine);
					
					// Find match for String containing required log information
					if (m.find()) {
						isFound = true;
					}

					if (isFound == true) {
						// set time 
						data.setTime(m.group(0));

						// differentiate type and save
						if (sCurrentLine.contains("INFO")) {
							data.setType("INFO");
						} else if (sCurrentLine.contains("ERROR")) {
							//if type is error collect extra error information appended
							data.setType("ERROR");
							br.mark(0);
							//System.out.println("### CONTAINS ERROR:  "
								//	+ sCurrentLine);
						} else if (sCurrentLine.contains("WARN")) {
							data.setType("WARN");
						}

						// System.out.println("Last read = " + lastRead +
						// "Type = " + data.getType());

						if (sCurrentLine != lastRead
								&& data.getType().equals("ERROR")) {
						
							//System.out.println("LastRead Before "+lastRead);
							lastRead = sCurrentLine;
							//System.out.println("LastRead After "+lastRead);
							StringBuffer errorData = new StringBuffer();
							sCurrentLine = br.readLine();
							while (sCurrentLine != null) {
								//System.out.println("###Inner loop");
								Matcher m1 = r.matcher(sCurrentLine);
								if (!m1.find()) {									
									errorData.append(sCurrentLine + "~");
									
								} else {
									//System.out.println("###Before "+sCurrentLine);
									br.reset();
									//System.out.println("###After "+sCurrentLine);
									break;
								}
								sCurrentLine = br.readLine();
								//System.out.println("###Updated NEXT 2"+ sCurrentLine);
							}
							data.setErrorData(errorData.toString());
							//System.out.println(data.getErrorData());
						} else {
							data.setErrorData("NOT APPLICABLE");
						}
						//System.out.println(data.getTime());
						System.out.println(sCurrentLine);
						System.out.println("TYPE: " + data.getType());
						//System.out
						//		.println("ERROR DATA: " + data.getErrorData());
					}
					sCurrentLine = br.readLine();
					//System.out.println("###Updated NEXT 3"+ sCurrentLine);
				}

			} catch (IOException e) {
				e.printStackTrace();
			} finally {
				try {
					if (br != null)
						br.close();
				} catch (IOException ex) {
					ex.printStackTrace();
				}
			}
		}
	}
}
