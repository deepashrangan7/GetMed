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

import com.project.model.AdminBean;
import com.project.model.MedicineBean;
import com.project.model.SearchBean;
import com.project.service.MedicineDao;
import com.project.service.OrderFunction;

@Controller
public class MedicineController {
	@Autowired
	private OrderFunction of;
	@Autowired
	private MedicineDao md;
	@Autowired
	private Map<Integer, Integer> cart;

	@RequestMapping("/orderdone")
	public synchronized String ordermedicine(HttpSession session) {

		String page = "viewcart";

		String stk = "some stocks sold out";
		int i = 0;
		for (Map.Entry<Integer, Integer> entry : cart.entrySet()) {
			Integer mid1 = entry.getKey();
			if (!(of.stockAvailable(mid1, cart.get(mid1)))) {
//				System.out.println(mid1+" srock no");
				i += 1;

				Optional<MedicineBean> o = md.findById(mid1);
				if (o.isPresent()) {
					MedicineBean mbb = o.get();

					stk += "\n only " + mbb.getStock() + " left in " + mbb.getName() + " ";

				} // o.present
			} // !

		} // for
//		System.out.println(stk);
		if (i != 0) {
			session.setAttribute("nostock", stk);
			return "viewcart";
		} else {

//			System.out.println("success");
			Double total = (Double) session.getAttribute("total");
			AdminBean ab = (AdminBean) session.getAttribute("id");
			String uid = ab.getEmailId();
			of.placeorder(cart, total, uid);
			System.out.println("order placed " + uid + " " + total);
			session.setAttribute("nostock", "");
			cart.clear();
			session.setAttribute("cart", null);
			//// write
		}

		return page;
	}

	@RequestMapping("/pay")
	public synchronized String payment(HttpSession session) {
		String stk = "some stocks sold out";
		int i = 0;
		try {Thread.sleep(2000);}catch (Exception e) {
			// TODO: handle exception
		}
		for (Map.Entry<Integer, Integer> entry : cart.entrySet()) {
			Integer mid1 = entry.getKey();
			if (!(of.stockAvailable(mid1, cart.get(mid1)))) {
				System.out.println(mid1 + " srock no");
				i += 1;

				Optional<MedicineBean> o = md.findById(mid1);
				if (o.isPresent()) {
					MedicineBean mbb = o.get();

					stk += "\n only " + mbb.getStock() + " left in" + mbb.getName() + " ";

				} // o.present
			} // !

		} // for
//		System.out.println(stk);
		if (i != 0) {
			session.setAttribute("nostock", stk);
			return "viewcart";
		}

		return "payment";
	}// method

	@RequestMapping("/addtocart")
	public String addToCart(Integer mid, Integer opt, Model m, HttpSession session) {
		cart.put(mid, 1);
		System.out.println("opt "+opt+ " added");
		session.setAttribute("cart", cart);
		m.addAttribute("sb", new SearchBean());
//		System.out.println("added " + cart);
		if (opt == 1) {
			m.addAttribute("sb", new SearchBean());
			return "viewallmedicine";
		}
		return "viewmedicine";
	}

	@RequestMapping("/removefromcart")
	public String removeFromCart(Integer mid, Integer opt, Model m, HttpSession session) {
		cart.remove(mid);
		System.out.println("opt "+opt+ " remove");
		session.setAttribute("cart", cart);
		m.addAttribute("sb", new SearchBean());
		if (opt == 1) {
			m.addAttribute("sb", new SearchBean());
			return "viewallmedicine";
		}
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
		Double prices = 0.0;
		for (MedicineBean mm : mb) {

			prices += mm.getPrice() * cart.get(mm.getMid());
			;

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
		Double prices = 0.0;
		for (MedicineBean mm : mb) {

			prices += mm.getPrice() * 1;

		}

		session.setAttribute("listofmedicine", mb);
		session.setAttribute("total", prices);
		session.setAttribute("nostock", null);
		return "viewcart";
	}

	@RequestMapping("/addquantity")
	public String addQuantity(Integer mid, Integer quantity, HttpSession session) {

		// System.out.println(mid+" "+quantity);
//			
//		Map<Integer,Integer> o=(Map<Integer,Integer>)session.getAttribute("cart");
//		
		if (of.stockAvailable(mid, quantity)) {

			cart.replace(mid, quantity);
			List<MedicineBean> mb = new ArrayList<>();
			for (Map.Entry<Integer, Integer> entry : cart.entrySet()) {
				Integer mid1 = entry.getKey();

				Optional<MedicineBean> o = md.findById(mid1);
				if (o.isPresent())
					mb.add(o.get());

			}
			Double prices = 0.0;
			for (MedicineBean mm : mb) {

				prices += mm.getPrice() * cart.get(mm.getMid());

			}
			session.setAttribute("nostock", null);
			session.setAttribute("total", prices);
		} else {
			// System.out.println("no stock");
			String stk = "";
			Optional<MedicineBean> o = md.findById(mid);
			MedicineBean mbb = null;
			if (o.isPresent())
				mbb = o.get();

			stk += ("Only " + mbb.getStock() + " left in " + mbb.getName() + " .");
			session.setAttribute("nostock", stk);
		}

		session.setAttribute("cart", cart);

		return "viewcart";
	}

}
