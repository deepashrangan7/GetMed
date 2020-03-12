package com.project.controller;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

import com.project.model.FilterBean;
import com.project.model.OrderBean;
import com.project.model.ParticularBean;
import com.project.model.SearchBean;
import com.project.service.MedicineDao;
import com.project.service.OrderDao;
import com.project.service.OrderFunction;

@Controller
public class OrderController {

	@Autowired
	private OrderFunction of;
	@Autowired
	private MedicineDao md;
	@Autowired
	private OrderDao od;
	@RequestMapping("/viewordersadmin")
	public String viewOrdersAdmin(@ModelAttribute("filter")FilterBean filter,BindingResult br,Model m,HttpSession session) {
		if (session.getAttribute("id") == null)
			return "choose";
		String page="viewordersad";
		System.out.println(filter.getFilter());
		List<OrderBean> ob=null;
		
		
		if(filter.getFilter()==null ||filter.getFilter().equals("all")) {
			ob=od.findAll();
		}else if(filter.getFilter().equals("delivered")) {
		System.out.println("deliver");
			ob=od.findByStatus(filter.getFilter());
		}else if(filter.getFilter().endsWith("shipped")) {
			System.out.println("ship ");
			ob=od.findByStatus(filter.getFilter());
		}else if(filter.getFilter().equalsIgnoreCase("inprogress")) {
			System.out.println("prog");
			ob=od.findByStatus(filter.getFilter());
		}
		
		session.setAttribute("allorders", ob);
		return page;
	}
	
	@RequestMapping("/viewparticluardetail")
	public String particularDetail(Integer oid,Model m,HttpSession session) {
		if (session.getAttribute("id") == null)
			return "choose";
		String role=(String)session.getAttribute("role");
		String page="partorder";
		List<ParticularBean> pb=of.getDetails(oid);
		m.addAttribute("partdetail",pb);
		m.addAttribute("oidd",oid);
		if(role.equals("ad"))
		return page;
		else
			return "partorderus";
	
	}
	
	
	@RequestMapping("/gohome")
	public String gohome(Model m,HttpSession session) {
		if (session.getAttribute("id") == null)
			return "choose";
		m.addAttribute("sb",new SearchBean());
		m.addAttribute("err", 0);
		return"userHome";
	}
	
	@RequestMapping("/changestatus")
	public String changeStatus(String status,Integer oid) {
		
		of.change(oid,status);
		return "redirect:viewordersadmin";
	}
	
}
