package com.gongchuangsu.helloweb.service;

import com.sun.mail.smtp.SMTPTransport;

import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.Properties;

@Service
public class EmailService implements IEmailService {

	@Override
    public void sendMail(String toto) {

    	// Recipient's email ID needs to be mentioned.
        String to = toto;

        String from = "username@louvre.ad";
        String host = "intsmtp.louvreabudhabi.ae";//or IP address  
        String port = "587";
    
       //Get the session object  
        Properties properties = System.getProperties();  
        properties.setProperty("mail.smtp.auth", "true"); 
        properties.setProperty("mail.smtp.starttls.enable", "true"); 
        properties.setProperty("mail.smtp.host", host); 
        properties.setProperty("mail.smtp.port", port); 
 
        Session session = Session.getDefaultInstance(properties, new javax.mail.Authenticator() {
            protected PasswordAuthentication getPasswordAuthentication() {
                return new PasswordAuthentication("username@louvre.ad", "r#3-79pRc@");
            }
        });  
    
       //compose the message  
        try{  
           MimeMessage message = new MimeMessage(session);  
           message.setFrom(new InternetAddress(from));  
           message.addRecipient(Message.RecipientType.TO,new InternetAddress(to));  
           message.setSubject("Ping");  
           message.setText("Hello, this is example of sending email");  
    
           // Send message  
           Transport.send(message);  
           System.out.println("message sent successfully....");  
    
        }catch (MessagingException mex) {mex.printStackTrace();System.out.println(mex.getMessage());}  


    }
}