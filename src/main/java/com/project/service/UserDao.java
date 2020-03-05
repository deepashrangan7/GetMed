package com.project.service;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.project.model.UserBean;

public interface UserDao extends JpaRepository<UserBean, String>{

	
	
	@Query("select s from UserBean s where s.emailId=:email AND s.password=:password")
	public UserBean validateUser(String email,String password);
	
	@Query("select s from UserBean s where s.emailId=:email ")
	public UserBean findUser(String email);
}
