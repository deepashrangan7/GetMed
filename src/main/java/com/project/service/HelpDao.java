package com.project.service;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


import com.project.model.HelpBean;

@Repository
public interface HelpDao extends JpaRepository<HelpBean, Integer> {

}