package com.project.controller;

import java.util.Optional;

import javax.servlet.http.HttpSession;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.project.model.AdminBean;
import com.project.model.LoginBean;
import com.project.model.RecoveryBean;
import com.project.model.UserBean;
import com.project.service.AdminDao;
import com.project.service.AdminFunction;
import com.project.service.RecoveryDao;
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
	RecoveryDao recoveryDao;
	@Autowired
	private Validation validation;

	@RequestMapping("/")
	public String chooseRole() {
		String page = "choose";

		return page;

	}

	@RequestMapping("/log")
	public String login(String role, @ModelAttribute("login") LoginBean login, HttpSession session, Model m) {
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
	public String home(@Valid @ModelAttribute("signup") UserBean userBean, BindingResult br, HttpSession session,
			Model m) {
		String page = "recovery";
		m.addAttribute("rb", new RecoveryBean());
		if (br.hasErrors()) {

			return "signup";

		} else {
			String role = (String) session.getAttribute("role");
			if (role.equals("ad")) {
				AdminBean ab = adminDao.findAdmin(userBean.getEmailId());
				if (ab == null)
					adminDao.save(adminFunction.convert(userBean));
				else {
					br.addError(new FieldError("email", "emailId", "Email Already Exist"));
					return "signup";
				}
			} else {
				userBean.setPassword(adminFunction.encryption(userBean.getPassword()));
				UserBean ab = userDao.findUser(userBean.getEmailId());

				if (ab == null)
					userDao.save(userBean);
				else {
					br.addError(new FieldError("email", "emailId", "Email Already Exist"));
					return "signup";
				}
				
			}
			return page;
		}
	}

	@RequestMapping("/main")
	public String mainPage(@Valid @ModelAttribute("login") LoginBean login, BindingResult br, HttpSession session,
			Model model) {

		String role = (String) session.getAttribute("role");
		String page = "adminHome";

		if (br.hasErrors()) {
			model.addAttribute("err", 0);
			return "login";
		}
		if (role.equals("us")) {

			UserBean ub = userDao.validateUser(login.getEmail().trim(),
					adminFunction.encryption(login.getPassword().trim()));
			if (ub == null) {
				model.addAttribute("err", 1);
//				System.out.println(login.getEmail()+" "+adminFunction.encryption(login.getPassword().trim()));
				return "login";
			}

			Optional<UserBean> o = userDao.findById(login.getEmail().trim());
			if (o.isPresent())
				session.setAttribute("id", o.get());

			page = "userHome";
		} else {
			AdminBean ab = adminDao.validateAdmin(login.getEmail().trim(),
					adminFunction.encryption(login.getPassword().trim()));
			if (ab == null) {
				model.addAttribute("err", 1);
				System.out.println(1);
				return "login";

			}
			Optional<AdminBean> o = adminDao.findById(login.getEmail().trim());
			if (o.isPresent())
				session.setAttribute("id", o.get());

		}

		return page;

	}// main

	@PostMapping("/recoverymap")
	public String recovery(@Valid @ModelAttribute("rb") RecoveryBean recoveryBean, BindingResult bindingResult,
			HttpSession session) {
		String page = "recovery";
		if (bindingResult.hasErrors()) {
			return "recovery";
		}
		recoveryBean.setDesgination((String) session.getAttribute("role"));
		recoveryDao.save(recoveryBean);
		return "choose";
	}

}
