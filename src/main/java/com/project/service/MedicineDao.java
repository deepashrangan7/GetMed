package com.project.service;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.project.model.MedicineBean;
@Repository
public interface MedicineDao extends JpaRepository<MedicineBean, Integer>{

	@Query("select s from MedicineBean s where s.adminId=:admin")
	public List<MedicineBean> findByAdminId(String admin);
}
