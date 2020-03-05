package com.project.service;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.project.model.RecoveryBean;


@Repository
public interface RecoveryDao extends JpaRepository<RecoveryBean, Integer>{
	
}
