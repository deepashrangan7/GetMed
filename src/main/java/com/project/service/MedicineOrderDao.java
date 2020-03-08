package com.project.service;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.project.model.MedicineOrdered;


@Repository
public interface MedicineOrderDao extends JpaRepository<MedicineOrdered, Integer>{
	
	@Query("select s from MedicineOrdered s where s.oid=:oid")
	public List<MedicineOrdered> getListOfOrder(Integer oid);
}
