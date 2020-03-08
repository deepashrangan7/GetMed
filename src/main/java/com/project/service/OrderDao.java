package com.project.service;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.project.model.OrderBean;


@Repository
public interface OrderDao extends JpaRepository<OrderBean, Integer>{
	
	@Query("select i from OrderBean i  order by i.orderId desc")
	public  List<OrderBean> findOid();

	@Query("select o from OrderBean o where o.status=:status")
	public List<OrderBean> findByStatus(String status);
	
	
}
