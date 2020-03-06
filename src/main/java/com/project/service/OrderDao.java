package com.project.service;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.project.model.OrderBean;


@Repository
public interface OrderDao extends JpaRepository<OrderBean, Integer>{
	
}
