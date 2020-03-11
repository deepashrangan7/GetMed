package com.project.service;

import java.util.List;
import java.util.Optional;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Service;

import com.project.model.MedicineBean;
import com.project.model.MedicineOrdered;
import com.project.model.OrderBean;

@Service
@Scope("singleton")
public class OrderFunction2 {
	@Autowired
	 OrderDao od;
	@Autowired
	 MedicineDao md;
	@Autowired
	 MedicineOrderDao mod;
	@Transactional
	public synchronized  Integer setOrder(List<MedicineOrdered> mo, String uid, Double total) {
		List<OrderBean> ob1 = od.findOid();
		Integer oid = 1;
		if (ob1 == null || ob1.size() == 0)
			oid = 1;
		else
			oid = ob1.get(0).getOrderId() + 1;
		 synchronized (this) {

		OrderBean ob = new OrderBean(uid, total, "inprogress");
		od.save(ob);
		 }
		for (MedicineOrdered m : mo) {
			m.setOid(oid);
			Optional<MedicineBean> o = md.findById(m.getMid());
			MedicineBean mb = o.get();
			synchronized (this) {
			if(mb.getStock()>=m.getQuantity()) {
				
			mb.setStock(mb.getStock() - m.getQuantity());
			mb.setSales(mb.getSales() + m.getQuantity());
				
			
			md.save(mb);
			mod.save(m);
		}
			else {
				return -1;
			}
			}}

		return oid;
	}
}
