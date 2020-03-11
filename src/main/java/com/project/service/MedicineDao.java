package com.project.service;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.project.model.AdminBean;
import com.project.model.MedicineBean;
@Repository
public interface MedicineDao extends JpaRepository<MedicineBean, Integer>{

	@Query("select s from MedicineBean s where s.type=:type And s.name=:name And s.brand=:brand")
	public MedicineBean weatherAny(String name,String brand,String type);
	
	@Query("select s from MedicineBean s where s.type=:type")
	public List<MedicineBean> findType(String type);

	@Query("select DISTINCT(mb.city) from MedicineBean mb")
	public List<String> findAllCity();
	
	@Query("select s from MedicineBean s where s.brand=:brand And s.stock>0")
	public List<MedicineBean> findBrand(String brand);
	
	@Query("select s from MedicineBean s where s.name=:name And s.stock>0")
	public List<MedicineBean> findName(String name);
	
	@Query("select s from MedicineBean s order by s.name ")
	public List<MedicineBean> findNameAsc();
	
	@Query("select s from MedicineBean s order by s.name desc")
	public List<MedicineBean> findNameDesc();
	

	@Query("select s from MedicineBean s order by s.brand desc")
	public List<MedicineBean> findBrandDesc();
	
	@Query("select s from MedicineBean s order by s.brand ")
	public List<MedicineBean> findBrandAsc();
	

	@Query("select s from MedicineBean s order by s.price ")
	public List<MedicineBean> findPriceAsc();


	@Query("select s from MedicineBean s order by s.price desc")
	public List<MedicineBean> findPriceDesc();
	

	@Query("select s from MedicineBean s order by s.city ")
	public List<MedicineBean> findCityAsc();
	

	@Query("select s from MedicineBean s order by s.city desc")
	public List<MedicineBean> findCityDesc();

	@Query("select s from MedicineBean s where s.mid=:mid")
	public MedicineBean findMed(Integer mid);
	
//
//	@Query("select s from MedicineBean s where s.name=:mb.name order by s.city desc")
//	public List<MedicineBean> findCityDesc(List<MedicineBean> mb);
//
//	@Query("select s from MedicineBean s where s.name=:mb.name order by s.name ")
//	public List<MedicineBean> findNameAsc(List<MedicineBean> mb);
//	
//	@Query("select s from MedicineBean s where s.name=:mb.name order by s.name desc")
//	public List<MedicineBean> findNameDesc(List<MedicineBean> mb);
//	
//
//	@Query("select s from MedicineBean s where s.name=:mb.name order by s.brand desc")
//	public List<MedicineBean> findBrandDesc(List<MedicineBean> mb);
//	
//	@Query("select s from MedicineBean s where s.name=:mb.name order by s.brand ")
//	public List<MedicineBean> findBrandAsc(List<MedicineBean> mb);
//	
//
//	@Query("select s from MedicineBean s where s.name=:mb.name order by s.price ")
//	public List<MedicineBean> findPriceAsc(List<MedicineBean> mb);
//
//
//	@Query("select s from MedicineBean s where s.name=:mb.name order by s.price desc")
//	public List<MedicineBean> findPriceDesc(List<MedicineBean> mb);
//	
//
//	@Query("select s from MedicineBean where s.name=:mb.name s order by s.city ")
//	public List<MedicineBean> findCityAsc(List<MedicineBean> mb);
//	
//	
//	
	
}
