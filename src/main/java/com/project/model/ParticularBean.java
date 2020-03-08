package com.project.model;

import java.util.Date;

public class ParticularBean {
	private Integer oid;
	public Integer getOid() {
		return oid;
	}

	public void setOid(Integer oid) {
		this.oid = oid;
	}

	public Integer getMid() {
		return mid;
	}

	@Override
	public String toString() {
		return "ParticularBean [oid=" + oid + ", mid=" + mid + ", name=" + name + ", brand=" + brand + ", Type=" + type
				+ ", quantity=" + quantity + ", unitPrice=" + unitPrice + ", orderDate=" + orderDate + ", totalAmount="
				+ totalAmount + ", status=" + status + "]";
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

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public Integer getQuantity() {
		return quantity;
	}

	public void setQuantity(Integer quantity) {
		this.quantity = quantity;
	}

	public Double getUnitPrice() {
		return unitPrice;
	}

	public void setUnitPrice(Double unitPrice) {
		this.unitPrice = unitPrice;
	}

	public Date getOrderDate() {
		return orderDate;
	}

	public void setOrderDate(Date orderDate) {
		this.orderDate = orderDate;
	}

	public Double getTotalAmount() {
		return totalAmount;
	}

	public void setTotalAmount(Double totalAmount) {
		this.totalAmount = totalAmount;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	private Integer mid;
	
	private String name;
	
	private String brand;
	
	private String type;
	private Integer quantity;
	
	private Double unitPrice;
	
	private Date orderDate;
	
	private Double totalAmount;

	private String status;
}
