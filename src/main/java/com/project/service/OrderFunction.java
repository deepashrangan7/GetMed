package com.project.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.project.model.MedicineBean;

@Service
public class OrderFunction {

	@Autowired
	private MedicineDao medicineDao;

	public synchronized boolean stockAvailable(Integer mid, Integer needed) {
		boolean flag = false;
		
		MedicineBean mb=null;
		
		Optional<MedicineBean> o=medicineDao.findById(mid);
		if(o.isPresent())
			mb=o.get();
		try {
		

			if(mb.getStock()-needed>=0)
			{
//			mb.setSales(mb.getSales()+needed);
//			mb.setStock(mb.getStock()-needed);
//			
				flag=true;
			}
			
			
			Thread.sleep(300);
		} catch (Exception e) {
			System.out.println("multiple tried");
		}

		return flag;

	}
	
	

}
