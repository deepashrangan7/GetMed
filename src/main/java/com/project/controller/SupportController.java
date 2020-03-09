package com.project.controller;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

import com.project.model.AdminBean;
import com.project.model.FilterBean;
import com.project.model.OrderBean;
import com.project.service.AdminFunction;

@Controller
public class SupportController {
	@Autowired
	private AdminFunction af;

	@RequestMapping("/orderhistory")
	public String orderHistory(@ModelAttribute("filter")FilterBean filter,BindingResult br,HttpSession session) {

		String page = "orderhistory";
		AdminBean ab = (AdminBean) session.getAttribute("id");
		List<OrderBean> obj = af.getOrdersUser(ab.getEmailId());
		session.setAttribute("orderhis", obj);
		session.setAttribute("filter", new FilterBean());
		return page;

	}

}
