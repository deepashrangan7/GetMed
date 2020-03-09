package com.project.service;

import java.util.ArrayList;
import java.util.Base64;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;

import com.project.model.OrderBean;

@Service
public class AdminFunction {
	@Autowired
	private OrderDao od;
		public AdminFunction() {
		super();
	}

	public String encryption(String pass)
	{
		 Base64.Encoder encoder = Base64.getEncoder(); 
		pass = encoder.encodeToString(pass.getBytes());  
       return pass;
	}
	
	public String decryption(String password)
	{ 
        Base64.Decoder decoder = Base64.getDecoder();
        password = new String(decoder.decode(password.getBytes()));
        return password;
	}
	
	public List<OrderBean> getOrdersUser(String uid){
		List<OrderBean> obj=new ArrayList<>();
		
		obj=od.findByUid(uid);
		return obj;
		
	}
	
}
