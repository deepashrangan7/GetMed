package com.project.service;

import org.springframework.data.jpa.repository.JpaRepository;

import com.project.model.RecoveryBean;



public interface RecoveryDao extends JpaRepository<RecoveryBean, String>{
	
}
