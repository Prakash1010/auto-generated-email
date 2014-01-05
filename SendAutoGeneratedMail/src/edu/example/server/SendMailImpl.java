package edu.example.server;

import java.io.UnsupportedEncodingException;
import java.util.Properties;

import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.AddressException;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

public class SendMailImpl {
	public void sendMail(String[] recepients, String subject, String content) throws UnsupportedEncodingException {
		Properties props = new Properties();
		Session session = Session.getDefaultInstance(props, null);
		try {
			Message msg = new MimeMessage(session);
			msg.setContent(content, "text/html; charset=utf-8");
			msg.setFrom(new InternetAddress("babajyoti.prakash10@gmail.com",
					"Example.com Admin"));
			
			
			msg.setSubject(subject);
			for(String recepient: recepients){
			msg.addRecipient(Message.RecipientType.TO, new InternetAddress(
					recepient, "Mr. User"));
			Transport.send(msg);
			System.out.println("mail sent to" + recepient);
			}

		} catch (AddressException e) {
			// ...
		} catch (MessagingException e) {
			// ...
		}
	}
}
