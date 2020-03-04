package com.project.controller;

import javax.servlet.http.HttpSession;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.project.model.AdminBean;
import com.project.model.LoginBean;
import com.project.model.RecoveryBean;
import com.project.model.UserBean;
import com.project.service.AdminDao;
import com.project.service.AdminFunction;
import com.project.service.UserDao;
import com.project.service.Validation;

@Controller
public class MainController {
	@Autowired
	AdminDao adminDao;
	@Autowired
	UserDao userDao;
	@Autowired
	AdminFunction adminFunction;

	@Autowired
	private Validation validation;

	@RequestMapping("/")
	public String chooseRole() {
		String page = "choose";

		return page;

	}

	@RequestMapping("/log/{role}")
	public String login(@PathVariable("role") String role,@ModelAttribute("login")LoginBean login ,HttpSession session, Model m) {
		String page = "login";
		m.addAttribute("err", 0);
		session.setAttribute("role", role);
		System.out.println(role);
		return page;

	}

	@RequestMapping("/sign")
	public String signup(@ModelAttribute("signup") UserBean ub) {
		String page = "signup";
		return page;
	}

	@RequestMapping("/home")
	public String home(@Valid @ModelAttribute("signup") UserBean userBean, BindingResult br, HttpSession session,Model m) {
		String page = "recovery";
		m.addAttribute("rb", new RecoveryBean());
		if (br.hasErrors()) {

			return "signup";

		} else {
			String role = (String) session.getAttribute("role");
			if (role.equals("ad")) {
				adminDao.save(adminFunction.convert(userBean));
			} else {
				userBean.setPassword(adminFunction.encryption(userBean.getPassword()));
				userDao.save(userBean);
				//page = "userHome";
			}
			return page;
		}
	}

	@RequestMapping("/main")
	public String mainPage(@ModelAttribute("login")LoginBean login, HttpSession session, Model model) {

		// System.out.println(login.getEmail()+" "+login.getPassword()+" here");
		String role = (String) session.getAttribute("role");
		String page = "adminHome";
		if (login.getEmail().equals("")) {
			model.addAttribute("err", 2);
			return "login";
		}
		if (login.getPassword().equals("")) {
			model.addAttribute("err", 3);
			return "login";
		}

		if (role.equals("us")) {
			
			UserBean ub = userDao.validateUser(login.getEmail(), adminFunction.encryption(login.getPassword()));
			if (ub == null) {
				model.addAttribute("err", 1);
				return "login";
			}
			page = "userHome";
		}else
		{
			AdminBean ab=adminDao.validateAdmin(login.getEmail(), adminFunction.encryption(login.getPassword()));
			if (ab == null) {
				model.addAttribute("err", 1);
				return "login";
			}
			//page = "userHome";
		}

		return page;

	}// main
	
	@PostMapping("/recoverymap")
	public String recovery(@Valid @ModelAttribute("rb") RecoveryBean recoveryBean,BindingResult bindingResult) {
		String page = "recovery";
		if(bindingResult.hasErrors())
		{
			return "recovery";
		}
	return "choose";
	}
	

}
