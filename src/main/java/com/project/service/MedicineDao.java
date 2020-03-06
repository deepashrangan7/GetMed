package com.project.service;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.project.model.AdminBean;
import com.project.model.MedicineBean;
@Repository
public interface MedicineDao extends JpaRepository<MedicineBean, Integer>{

	@Query("select s from MedicineBean s where s.type=:type")
	public List<MedicineBean> findType(String type);

	
	
}
