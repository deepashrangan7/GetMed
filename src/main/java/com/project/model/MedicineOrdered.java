package com.project.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="medicineordered")
public class MedicineOrdered {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer moid;
	
	public Integer getMoid() {
		return moid;
	}

	public void setMoid(Integer moid) {
		this.moid = moid;
	}

	public MedicineOrdered() {
		super();
	}

	public MedicineOrdered(Integer oid, Integer mid, Integer quantity) {
		super();
		this.oid = oid;
		this.mid = mid;
		this.quantity = quantity;
	}

	public Integer getOid() {
		return oid;
	}

	public void setOid(Integer oid) {
		this.oid = oid;
	}

	public Integer getMid() {
		return mid;
	}

	public void setMid(Integer mid) {
		this.mid = mid;
	}

	public Integer getQuantity() {
		return quantity;
	}

	public void setQuantity(Integer quantity) {
		this.quantity = quantity;
	}
	private Integer oid;
	
	private Integer mid;
	
	private Integer quantity;
	
	
}
