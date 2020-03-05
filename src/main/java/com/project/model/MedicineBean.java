package com.project.model;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.Future;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import org.springframework.format.annotation.DateTimeFormat;

@Entity
@Table(name = "medicinetable")
public class MedicineBean {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer mid;

	@NotBlank(message = "Please enter medicine name")
	private String name;

	@NotBlank(message = "please enter Brand of medicine")
	private String brand;

	@NotNull(message = "please set the price of medicine")
	@Min(value = 1, message = "price should not be less than 1")
	private Double price;

	@Override
	public String toString() {
		return "MedicineBean [mid=" + mid + ", name=" + name + ", brand=" + brand + ", price=" + price + ", stock="
				+ stock + ", disease=" + disease + ", city=" + city + ", sales=" + sales + ", adminId=" + adminId
				+ ", type=" + type + ", expiryDate=" + expiryDate + "]";
	}

	@NotNull(message = "stock should not be empty")
	@Min(value = 1, message = "please enter stock")
	private Integer stock;

	@NotBlank(message = "Please specify the disease")
	private String disease;

	@NotBlank(message = "please enter area of sales")
	private String city;

	private Integer sales;

	private String adminId;
	
	private String type;
	
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	@Future(message = "Already Medicine Expired")
	private Date expiryDate;

	public String getAdminId() {
		return adminId;
	}

	public void setAdminId(String adminId) {
		this.adminId = adminId;
	}

	public Integer getMid() {
		return mid;
	}

	public void setMid(Integer mid) {
		this.mid = mid;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getBrand() {
		return brand;
	}

	public void setBrand(String brand) {
		this.brand = brand;
	}

	public Double getPrice() {
		return price;
	}

	public void setPrice(Double price) {
		this.price = price;
	}

	public Integer getStock() {
		return stock;
	}

	public void setStock(Integer stock) {
		this.stock = stock;
	}

	public String getDisease() {
		return disease;
	}

	public void setDisease(String disease) {
		this.disease = disease;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public Date getExpiryDate() {
		return expiryDate;
	}

	public void setExpiryDate(Date expiryDate) {

		this.expiryDate = expiryDate;
	}

	public Integer getSales() {
		return sales;
	}

	public void setSales(Integer sales) {
		this.sales = sales;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

}
