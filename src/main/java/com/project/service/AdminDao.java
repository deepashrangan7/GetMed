package com.project.service;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.project.model.AdminBean;



public interface AdminDao extends JpaRepository<AdminBean, String>{
	
	@Query("select s from AdminBean s where s.emailId=:email AND s.password=:password")
	public AdminBean validateAdmin(String email,String password);

	@Query("select s from AdminBean s where s.emailId=:email")
	public AdminBean findAdmin(String email);

}
