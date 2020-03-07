package com.project.model;

import javax.validation.constraints.NotBlank;

public class SearchBean {

	private String type;
	
	@NotBlank(message="Please enter name ")
	private String name;
	
	private String city;

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}
	
}
