import java.util.Properties;

import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.Session;
import javax.mail.PasswordAuthentication;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;


public class Mail {

	/** Sender Address*/
	private String sender;

	/** Psswd */
	private String psswd;

	/** Authentication Flag */
	private boolean auth;

	/** Host */
	private String host = "smtp.gmail.com";

	/** Port */
	private int port = 587;


	public Mail (String username, String psswd) {

		this.sender = username;

		this.psswd = psswd;

		if (psswd == null) {

			this.auth = false;

		} else {

			this.auth = true;

		}

		System.out.println ("Constructor:");

		System.out.println ("Username: " + this.sender);

		System.out.println ("Psswd: " + this.psswd);

		System.out.println ("Host: " + this.host);

		System.out.println ("\n\n");

	}


	public void sendMail (String receiver, String header, String text) {

		System.out.println ("Sending Mail ...");
		System.out.println ("Receiver: " + receiver);
		System.out.println ("Header: " + header);
		System.out.println ("Mail Text: " + text);
		System.out.println ();

	    // Setup mail server
	    Properties props = new Properties();
        props.put("mail.smtp.starttls.enable", ("" + this.auth));
        props.put("mail.smtp.auth", ("" + this.auth));
        props.put("mail.smtp.host", this.host);
        props.put("mail.smtp.port", ("" + this.port));

        Session session = null;

        if (this.auth) {

			final String username = this.sender;

			final String password = this.psswd;

			session = Session.getDefaultInstance(props,
	        		new javax.mail.Authenticator() {

	        		protected PasswordAuthentication getPasswordAuthentication() {
	        		return new PasswordAuthentication(username, password);
	        		}
	        		});

		} else {

			session = Session.getDefaultInstance (props);

		}


	    try {

	    	// Create a default MimeMessage object.
	         MimeMessage message = new MimeMessage(session);

	         // Set From: Sender Address
	         message.setFrom(new InternetAddress(this.sender));

	         // Set To: Receiver Address
	         message.addRecipient(Message.RecipientType.TO, new InternetAddress(receiver));

	         // Set Subject: header field
	         message.setSubject(header);

	         // Email Actual MEssage
	         message.setText(text);



	         // Send message
	         Transport.send(message);

	         System.out.println("Sent message successfully....");

	    } catch (MessagingException mex) {

	      mex.printStackTrace();

	    }



	}

}
