package com.project.service;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.project.model.RecoveryBean;


@Repository
public interface RecoveryDao extends JpaRepository<RecoveryBean, Integer>{
	@Query("select s from RecoveryBean s where s.desgination=:id AND s.a1=:answer")
	public RecoveryBean Validate (String id,String answer);

	@Query("select s from RecoveryBean s where s.desgination=:id AND s.a2=:answer")
	public RecoveryBean Validate1 (String id,String answer);

	@Query("select s from RecoveryBean s where s.desgination=:id AND s.a3=:answer")
	public RecoveryBean Validate2 (String id,String answer);


	@Query("select s from RecoveryBean s where (s.a1=:a1 AND s.a2=:a2 AND s.a3=:a3 )")
	public RecoveryBean Validateusername ( String a1,String a2,String a3);
}
