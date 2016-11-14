package com.users.service;

import static javax.mail.Message.RecipientType.TO;

import javax.mail.Address;
import javax.mail.Authenticator;
import javax.mail.Message;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

import java.util.Properties;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.users.beans.Email;
import com.users.security.PermissionService;

@Service
public class EmailService {
	
	private static final Logger log = LoggerFactory.getLogger(EmailService.class);
	
	private final String username = "";
	private final String password = "";
	
	private Properties props;
	private Authenticator auth;
	
	@Autowired
	private PermissionService permissionService;
	
	
	//i think that the properties object is providing options and parameters for sending emails.  By adding the 
	//property to props, it is passed into Javamail, and tells Javamail what host to sent the mail  
	//SMTP (Simple Mail Transfer Protocol) is a TCP/IP protocol used in sending and receiving e-mail
	public EmailService() {
		props = new Properties();
		props.put("mail.smtp.auth", "true");
		props.put("mail.smtp.starttls.enable", "true");
		props.put("mail.smtp.host", "smtp.gmail.com");
		props.put("mail.smtp.port", "587");

		auth = new Authenticator() {
			protected PasswordAuthentication getPasswordAuthentication() {
				return new PasswordAuthentication(username, password);
			}
		};
	}

	//We're returning a boolean because we're making sure all necessary fields are added for an email to send properly 
	//Session is a conversion between a server and a client
	//MIME (Multi-Purpose Internet Mail Extensions)
	//MimeMessage is an e-mail message that understands MIME types and headers
	//Transport an abstract class that models a message transport mechanism for sending an e-mail message
	public boolean sendMessage(Email email) {
		Session session = Session.getInstance(props, auth);
		Message message = new MimeMessage(session);
		try {
				message.setRecipient(TO, new InternetAddress(email.getTo()));
				message.setReplyTo(
					new Address[] { new InternetAddress(permissionService.getCurrentEmail()) });
	
			message.setSubject(email.getSubject());
			message.setText(email.getCustom() + "\n\n" + email.getMessage());

			Transport.send(message);
		} catch (Exception e) {
			log.error("Unable to send message", e);
			return false;
		}
		return true;
	}



}	


