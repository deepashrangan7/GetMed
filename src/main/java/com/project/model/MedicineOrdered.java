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
	
	private Integer oid;
	
	private Integer mid;
	
	private Integer quantity;
	
	private Double unitprice;
	
}
