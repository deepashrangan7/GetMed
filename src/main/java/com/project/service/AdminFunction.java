package com.project.service;

import org.springframework.stereotype.Service;

import com.project.model.AdminBean;
import com.project.model.UserBean;
import java.util.*;

@Service
public class AdminFunction {

	public AdminBean convert(UserBean userBean)
	{
		AdminBean adminBean =new AdminBean();
		
		adminBean.setAge(userBean.getAge());
		adminBean.setContact(userBean.getContact());
		adminBean.setEmailId(userBean.getEmailId());
		adminBean.setFirstName(userBean.getFirstName());
		adminBean.setLastName(userBean.getLastName());
		adminBean.setGender(userBean.getGender());
		String pass=userBean.getPassword();
		adminBean.setPassword(encryption(pass));
		
		return adminBean;
	}
	
	public String encryption(String pass)
	{
		 Base64.Encoder encoder = Base64.getEncoder(); 
		pass = encoder.encodeToString(pass.getBytes());  
//        System.out.println("Encoded string: "+password);  
       return pass;
	}
	
	public String decryption(String password)
	{ 
        Base64.Decoder decoder = Base64.getDecoder();
        password = new String(decoder.decode(password.getBytes()));
//        System.out.println("DECODED STRING:"+passwo);
        return password;
	}
	
	
	
}
