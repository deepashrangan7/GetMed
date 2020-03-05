package com.project.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.project.model.AdminBean;


@Service
public class Validation {
	
	@Autowired
	private AdminDao adminDao;
	@Autowired
	private AdminFunction adminFunction;

//	public boolean authenticate(String email, String password, String role) {
//		boolean result = false;
//		if (role.equals("us")) {
//			Optional<UserBean> option = userDao.findById(email);
//			if (option.isPresent()) {
//				UserBean userBean = option.get();
//				if (adminFunction.decryption(userBean.getPassword()).equals(password))
//					result = true;
//			}
//
//			result = true;
//		} else {
//			Optional<AdminBean> option = adminDao.findById(email);
//			if (option.isPresent()) {
//				AdminBean adminBean = option.get();
//				if (adminFunction.decryption(adminBean.getPassword()).equals(password))
//					result = true;
//			}
//		}
//		return result;
//	}

}
