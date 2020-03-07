package com.project.controller;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Optional;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.project.model.MedicineBean;
import com.project.model.SearchBean;
import com.project.service.MedicineDao;

@Controller
public class MedicineController {

	@Autowired
	private MedicineDao md;
	@Autowired
	private Map<Integer, Double> cart;

	@RequestMapping("/addtocart")
	public String addToCart(Integer mid, Model m, HttpSession session) {
		cart.put(mid, null);
		session.setAttribute("cart", cart);
		m.addAttribute("sb", new SearchBean());
		System.out.println("added " + cart);
		return "viewmedicine";
	}

	@RequestMapping("/removefromcart")
	public String removeFromCart(Integer mid, Model m, HttpSession session) {
		cart.remove(mid);
		session.setAttribute("cart", cart);
		m.addAttribute("sb", new SearchBean());
		System.out.println("removed " + cart);
		return "viewmedicine";
	}

	@RequestMapping("/viewcart")
	public String viewCart(Model m) {
		List<MedicineBean> mb = new ArrayList<>();
		for (Map.Entry<Integer, Double> entry : cart.entrySet()) {
			Integer mid = entry.getKey();

			Optional<MedicineBean> o = md.findById(mid);
			if (o.isPresent())
				mb.add(o.get());

		}

		m.addAttribute("listofmedicine", mb);
		return "viewcart";
	}

}
