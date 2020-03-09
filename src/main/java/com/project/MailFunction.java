package com.project;



import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;



@Service
public class MailFunction {

			@Autowired
	    private JavaMailSender javaMailSender;
		
		public void sendEmail(String email,Integer oid,String status,String name) {

	        SimpleMailMessage msg = new SimpleMailMessage();
	        msg.setTo(email);
//	        msg.setTo("monikamohan98@gmail.com", "to_2@gmail.com", "to_3@yahoo.com");

	        msg.setSubject("Order Update ");
	        msg.setText("Hello "+name+"\n Your Order No : "+oid+"\n is "+status+"\nContact Us Through Help Section If You Have Any Queries \n Call : 8888888888 !.");

	        javaMailSender.send(msg);

	    }
}
