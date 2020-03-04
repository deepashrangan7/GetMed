package com.project.model;

import javax.validation.constraints.NotBlank;

import org.springframework.stereotype.Component;

@Component
public class LoginBean {
	
	@NotBlank(message = "email cant Be empty")
	private String email;
	@NotBlank(message = "Password must be minimum of length 8")
	private String password;
	
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}


}
