package com.project.service;

import org.springframework.stereotype.Service;

import com.project.model.AdminBean;

import java.util.*;

@Service
public class AdminFunction {
	
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
	
	
	
}
