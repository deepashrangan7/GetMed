package com.project.controller;

import java.util.HashMap;
import java.util.Map;
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

import com.project.MailFunction;
import com.project.model.AdminBean;
import com.project.model.HelpBean;
import com.project.model.LoginBean;
import com.project.model.RecoveryBean;
import com.project.model.SearchBean;
import com.project.service.AdminDao;
import com.project.service.AdminFunction;
import com.project.service.HelpDao;
import com.project.service.PasswordRecoveryFunction;
import com.project.service.Pdf_Function;
import com.project.service.RecoveryDao;

@Controller
public class MainController {
	@Autowired
	AdminDao adminDao;
	@Autowired
	HelpDao helpDao;
	@Autowired
	AdminFunction adminFunction;
	@Autowired
	RecoveryDao recoveryDao;
	@Autowired
	PasswordRecoveryFunction prf;
	@Autowired
	MailFunction mf;
	@Autowired
	Pdf_Function pdf;

	@RequestMapping("/")
	public String chooseRole(HttpSession session) {
		String page = "choose";
		session.setAttribute("add", 0);
//		mf.sendEmail();
		return page;

	}

	@RequestMapping("/logout")
	public String logout(HttpSession session) {
		session.setAttribute("add", 0);
		session.setAttribute("id", null);
		session.setAttribute("role", null);
		session.setAttribute("addm", null);
		session.setAttribute("cart", null);
		session.setAttribute("mediciness", null);
		session.setAttribute("mid", null);
		session.setAttribute("medici", null);

		return "choose";
	}

	@RequestMapping("/log")
	public String login(String role, @ModelAttribute("login") LoginBean login, HttpSession session, Model m) {
		String page = "login";
		m.addAttribute("err", 0);
		session.setAttribute("role", role);
//		System.out.println(role);
		return page;

	}

	@RequestMapping("/sign")
	public String signup(@ModelAttribute("signup") AdminBean ab) {
		String page = "signup";
		return page;
	}

	@RequestMapping("/home")
	public String home(@Valid @ModelAttribute("signup") AdminBean adminBean, BindingResult br, HttpSession session,
			Model m) {

		String page = "recovery";

		m.addAttribute("rb", new RecoveryBean());

		if (br.hasErrors()) {

			return "signup";

		} else {

			String role = (String) session.getAttribute("role");

			if (role.equals("ad")) {
				AdminBean ab = adminDao.findAdmin(adminBean.getEmailId());
				if (ab == null) {
					adminBean.setRole(1);
					adminBean.setPassword(adminFunction.encryption(adminBean.getPassword()));
					session.setAttribute("sign", adminBean);

				} else {

					br.addError(new FieldError("email", "emailId", "Email Already Exist"));

					return "signup";
				}
			} else {
				AdminBean ab = adminDao.findAdmin(adminBean.getEmailId());

				if (ab == null) {
					adminBean.setPassword(adminFunction.encryption(adminBean.getPassword()));
					adminBean.setRole(0);
					session.setAttribute("sign", adminBean);

				} else {
					br.addError(new FieldError("email", "emailId", "Email Already Exist"));
					return "signup";
				}

			}
			return page;
		}
	}

	@RequestMapping("/main")
	public String mainPage(@ModelAttribute("sb") SearchBean sb, @Valid @ModelAttribute("login") LoginBean login,
			BindingResult br, HttpSession session, Model model) {

		String role = (String) session.getAttribute("role");
		 Map<Integer, Integer> cart=new HashMap<Integer, Integer>();
		session.setAttribute("cart", cart);
		String page = "admin";
		session.setAttribute("addm", 0);
		if (br.hasErrors()) {
			model.addAttribute("err", 0);
			session.setAttribute("add", 0);
			return "login";
		}

		if (role.equals("us")) {

			AdminBean ub = adminDao.validateAdmin(login.getEmail().trim(),
					adminFunction.encryption(login.getPassword().trim()));
			if (ub == null || ub.getRole() == 1) {
				model.addAttribute("err", 1);
//				System.out.println(login.getEmail()+" "+adminFunction.encryption(login.getPassword().trim()));
				return "login";
			}

			Optional<AdminBean> o = adminDao.findById(login.getEmail().trim());
			if (o.isPresent())
				session.setAttribute("id", o.get());
			session.setAttribute("uname", o.get().getFirstName() + " " + o.get().getLastName());
			page = "userHome";
		} else {
			AdminBean ab = adminDao.validateAdmin(login.getEmail().trim(),
					adminFunction.encryption(login.getPassword().trim()));
			if (ab == null || ab.getRole() == 0) {
				model.addAttribute("err", 1);
//				System.out.println(1);
				session.setAttribute("add", 0);
				return "login";

			}
			Optional<AdminBean> o = adminDao.findById(login.getEmail().trim());
			if (o.isPresent())
				session.setAttribute("id", o.get());

			Integer not = adminFunction.anyNotification();
			model.addAttribute("noti", not);
			session.setAttribute("notic", 0);
		}
		session.setAttribute("add", 0);
		model.addAttribute("sb", new SearchBean());

		return page;

	}// main

	@PostMapping("/recoverymap")
	public String recovery(@Valid @ModelAttribute("rb") RecoveryBean recoveryBean, BindingResult bindingResult,
			HttpSession session, Model model) {
		String page = "recovery";
		if (bindingResult.hasErrors()) {
			return "recovery";
		}
		AdminBean role = (AdminBean) session.getAttribute("sign");
		adminDao.save((AdminBean) session.getAttribute("sign"));
		recoveryBean.setDesgination(role.getEmailId());
		recoveryDao.save(recoveryBean);
		session.setAttribute("sign", null);
		model.addAttribute("err", 0);
		model.addAttribute("login", new LoginBean());
		session.setAttribute("add", 1);

		return "login";
	}

	@RequestMapping("/forgotpassword")
	public String forgotpassword() {
		System.out.println("asddfg");
		return "updatepassword";
	}

	@RequestMapping("/newpassword")
	public String newpassword(String id, String question, String answer, Model mv, HttpSession session) {

		System.out.println(id + " " + question + " " + answer);

		RecoveryBean recoveryBean = prf.update(id, question, answer);

		if (recoveryBean == null) {
			System.out.println("WRONG");
			mv.addAttribute("result", "wrong");
			return "updatepassword";
		}

		else {
			session.setAttribute("username", recoveryBean.getDesgination());

			System.out.println(recoveryBean.getDesgination());

			return "passwordchanged";
		}

	}

	@RequestMapping("/passwordchanged")
	public String passwordchanged(String pass, String repass, Model m, HttpSession session, Model mo) {

		System.out.println("qwertyuiop:" + pass + "  " + repass);

		if (!(pass.equals(repass))) {
			mo.addAttribute("result", "wrong");
			return "passwordchanged";
		}

		else {
			String s = (String) session.getAttribute("username");
			System.out.println(s);

			prf.updatepassword(adminFunction.encryption(pass), s);

			mo.addAttribute("updatepass", "yes");
			return "choose";

		}

	}

	@RequestMapping("/help")
	public String help(@ModelAttribute("help") HelpBean help) {
		System.out.println("helpper");

		return "help";
	}

	@RequestMapping("/helpper")
	public String helpper(HelpBean help, Model m) {
		System.out.println("success");

		helpDao.save(help);
//		System.out.println("success2");
		m.addAttribute("help", "success");
		mf.sendHelp(help);
		return "redirect:uhome";
	}

	@RequestMapping("/pdf")
	public String pdf()
	{
	System.out.println("asddfg");


	return "choosepdf";
	}

	@RequestMapping("/generatepdf")
	public String generatepdf(String typepdf,Model m)
	{
	pdf.pdf(typepdf);
	m.addAttribute("pdf","YOUR REPORT IS GENERATED SUCCESSFULLY.");

	return "admin";
	}
	
	
	@RequestMapping("/forgotusername")
	public String forgotusername()
	{
	System.out.println("asddfg");
	return "showuserid";
	}

	@RequestMapping("/showuserid")
	public String showuserid(String answer1,String answer2,String answer3,Model m)
	{
	RecoveryBean rb = recoveryDao.Validateusername(answer1, answer2, answer3);

	if(rb==null)
	{
	m.addAttribute("result", "wrong");
	return "showuserid";
	}
	else
	{
	m.addAttribute("result", "correct");
	m.addAttribute("mid",rb.getDesgination());
	System.out.println(rb.getDesgination());
	return "choose";
	}



	}
	
}
