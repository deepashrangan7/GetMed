package com.project.controller;

import java.util.Map;
import java.util.Optional;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.project.model.AdminBean;
import com.project.model.MedicineBean;
import com.project.model.SearchBean;
import com.project.service.MedicineDao;
import com.project.service.OrderFunction;

@Controller
public class OrderController {

	@Autowired
	private OrderFunction of;
	@Autowired
	private MedicineDao md;
	
	Map<Integer,Integer> cart;
	

	@RequestMapping("/gohome")
	public String gohome(Model m) {
		m.addAttribute("sb",new SearchBean());
		m.addAttribute("err", 0);
		return"userHome";
	}
	
}
