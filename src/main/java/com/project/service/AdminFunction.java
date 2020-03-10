package com.project.service;

import java.util.ArrayList;
import java.util.Base64;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.project.model.MedicineBean;
import com.project.model.OrderBean;

@Service
public class AdminFunction {
	@Autowired
private	MedicineDao md;
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
	
	public Integer anyNotification() {
		Integer count=0;
		
		List<MedicineBean> mb=md.findAll();
	
		for(MedicineBean m:mb) {
			if(m.getStock()==0) {
				count+=1;
			}
		}
		return count;
	}
	
	public List<MedicineBean> getnotificaton(){
		
		List<MedicineBean> obj=new ArrayList<>();
		List<MedicineBean> mb=md.findAll();
		
		for(MedicineBean m:mb) {
			if(m.getStock()==0) {
				obj.add(m);
			}
		}System.out.println(obj);
		return obj;
	}
	
}
