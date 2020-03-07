package com.project.controller;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Optional;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;

import com.project.model.MedicineBean;
import com.project.model.SearchBean;
import com.project.service.MedicineDao;
import com.project.service.OrderFunction;

@Controller
public class MedicineController {
	@Autowired
	private	OrderFunction of;
	@Autowired
	private MedicineDao md;
	@Autowired
	private Map<Integer, Integer> cart;

	@RequestMapping("/pay")
	public String payment()
	{
		return "payment";
	}
	
	
	@RequestMapping("/addtocart")
	public String addToCart(Integer mid, Model m, HttpSession session) {
		cart.put(mid, 1);
		session.setAttribute("cart", cart);
		m.addAttribute("sb", new SearchBean());
//		System.out.println("added " + cart);
		return "viewmedicine";
	}

	@RequestMapping("/removefromcart")
	public String removeFromCart(Integer mid, Model m, HttpSession session) {
		cart.remove(mid);
		session.setAttribute("cart", cart);
		m.addAttribute("sb", new SearchBean());
		return "viewmedicine";
	}

	@RequestMapping("/removefromcart2")
	public String removeFromCart2(Integer mid, Model m, HttpSession session) {
		cart.remove(mid);
		session.setAttribute("cart", cart);
		m.addAttribute("sb", new SearchBean());
//		System.out.println("removed " + cart);
		List<MedicineBean> mb = new ArrayList<>();
		for (Map.Entry<Integer, Integer> entry : cart.entrySet()) {
			Integer mid1 = entry.getKey();

			Optional<MedicineBean> o = md.findById(mid1);
			if (o.isPresent())
				mb.add(o.get());

		}
		Double prices=0.0;
		for(MedicineBean mm:mb) {
			
			prices+=mm.getPrice()*cart.get(mm.getMid());;
			
		}
		
				session.setAttribute("listofmedicine", mb);
				session.setAttribute("total", prices);
	
		
		return "viewcart";
	}
	
	
	
	@RequestMapping("/viewcart")
	public String viewCart(Model m, HttpSession session) {
		List<MedicineBean> mb = new ArrayList<>();
		for (Map.Entry<Integer, Integer> entry : cart.entrySet()) {
			Integer mid = entry.getKey();

			Optional<MedicineBean> o = md.findById(mid);
			if (o.isPresent())
				mb.add(o.get());

		}
		Double prices=0.0;
		for(MedicineBean mm:mb) {
			
			prices+=mm.getPrice()*1;
			
		}
		
				session.setAttribute("listofmedicine", mb);
				session.setAttribute("total", prices);
				
				return "viewcart";
	}

	@RequestMapping("/addquantity")
	public String addQuantity(Integer mid, Integer quantity, HttpSession session) {

		
		//		System.out.println(mid+" "+quantity);
//			
//		Map<Integer,Integer> o=(Map<Integer,Integer>)session.getAttribute("cart");
//		
		if(of.stockAvailable(mid, quantity)) {

			cart.replace(mid, quantity);
			List<MedicineBean> mb = new ArrayList<>();
			for (Map.Entry<Integer, Integer> entry : cart.entrySet()) {
			Integer mid1 = entry.getKey();

			Optional<MedicineBean> o = md.findById(mid1);
			if (o.isPresent())
				mb.add(o.get());

		}

		Double prices=0.0;
		for(MedicineBean mm:mb) {
			
			prices+=mm.getPrice()*cart.get(mm.getMid());
			
		}
		session.setAttribute("nostock", 0);
		session.setAttribute("total", prices);
		}else {
			//System.out.println("no stock");
		session.setAttribute("nostock", 1);
		}
		session.setAttribute("cart", cart);
		
		
		return "viewcart";
	}

}
