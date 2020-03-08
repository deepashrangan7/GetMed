package com.project.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.project.model.MedicineBean;
import com.project.model.MedicineOrdered;
import com.project.model.OrderBean;

@Service
public class OrderFunction {

	@Autowired
	private MedicineDao medicineDao;
	@Autowired
	private OrderDao od;
	@Autowired
	private MedicineOrderDao md;

	public synchronized boolean stockAvailable(Integer mid, Integer needed) {
		boolean flag = false;

		MedicineBean mb = null;

		Optional<MedicineBean> o = medicineDao.findById(mid);
		if (o.isPresent())
			mb = o.get();
		try 
		{

			if (mb.getStock() - needed >= 0) {
				flag = true;
			}

			Thread.sleep(300);
		} catch (Exception e) {
			System.out.println("multiple tried");
		}

		return flag;

	}// method1

	public synchronized boolean placeorder(Map<Integer, Integer> cart,Double total,String uid) {
		boolean flag = false;
		
		try {
		List<MedicineOrdered> morder=new ArrayList<>();
		MedicineBean mbb=null;
		OrderBean ob=new OrderBean();
		ob.setAmount(total);
		ob.setStatus("In Progress");
		ob.setUserId(uid);
		od.save(ob);
		List<OrderBean> ob1=od.findOid();
		Integer oid=ob1.get(0).getOrderId();
		for (Map.Entry<Integer, Integer> entry : cart.entrySet()) {
			Integer mid1 = entry.getKey();
		morder.add(new MedicineOrdered());
		morder.get(morder.size()-1).setMid(mid1);
		morder.get(morder.size()-1).setQuantity(cart.get(mid1));
		morder.get(morder.size()-1).setOid(oid);
		md.save(morder.get(morder.size()-1));
		
		Optional<MedicineBean> o = medicineDao.findById(mid1);
		if(o.isPresent())
		{
			mbb=o.get();
			mbb.setStock(mbb.getStock()-cart.get(mid1));
			mbb.setSales(mbb.getSales()+cart.get(mid1));
			medicineDao.save(mbb);
		}
		}//for
	
		
		
		}catch (Exception e) {
//			System.out.println(e.getMessage());
		System.out.println("error in ordering");
		}
		
		return flag;

	}//method place

}
