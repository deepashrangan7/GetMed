package com.project.service;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.project.model.MedicineOrder;


@Repository
public interface MedicineOrderDao extends JpaRepository<MedicineOrder, Integer>{
	
}
