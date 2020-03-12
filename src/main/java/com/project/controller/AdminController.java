package com.project.controller;

import java.util.List;
import java.util.Optional;

import javax.servlet.http.HttpSession;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

import com.project.model.AdminBean;
import com.project.model.MedicineBean;
import com.project.model.TypeBean;
import com.project.service.AdminFunction;
import com.project.service.MedicineDao;

@Controller
public class AdminController {
	@Autowired
	private MedicineDao medicineDao;
	@Autowired
	private AdminFunction adminFunction;

	@RequestMapping("/viewstock")
	public String viewstock(TypeBean type, Model model, HttpSession session) {
		if (session.getAttribute("id") == null)
			return "choose";
		List<MedicineBean> mb;
		if (type.getType() == null || type.getType().equals("all")) {
			mb = medicineDao.findAll();
			type.setType("all");
		} else
			mb = medicineDao.findType(type.getType());
		model.addAttribute("mediciness", mb);
		model.addAttribute("ts", type);
		return "viewstock";
	}

	@RequestMapping("/adhome")
	public String adminMainPage(Model model, HttpSession session) {
		if (session.getAttribute("id") == null)
			return "choose";

		AdminBean ab = (AdminBean) session.getAttribute("id");

		List<MedicineBean> md = medicineDao.findAll();

		model.addAttribute("medicines", md);
		return "adminHome";
	}

	@RequestMapping("/editedview")
	public String editedview(Integer mid, Model model, HttpSession session) {
		if (session.getAttribute("id") == null)
			return "choose";
		Optional<MedicineBean> o = medicineDao.findById(mid);

		if (o.isPresent())
			model.addAttribute("meds", o.get());
		return "editview";
	}

	@RequestMapping("/addm")
	public String adminMainPage(@ModelAttribute("addmed") MedicineBean medicineBean, HttpSession session) {
		if (session.getAttribute("id") == null)
			return "choose";

		return "addmedicine";
	}

	@RequestMapping("/addmedicine")
	public String addMedicine(@Valid @ModelAttribute("addmed") MedicineBean medicineBean, BindingResult br,
			HttpSession session, Model model) {
		if (session.getAttribute("id") == null)
			return "choose";

		String page = "adminHome";
		if (br.hasErrors()) {
//			System.out.println("error in med");
			return "addmedicine";
		}
		String role = (String) session.getAttribute("role");
		medicineBean.setSales(0);
		MedicineBean mmm = medicineDao.weatherAny(medicineBean.getName(), medicineBean.getBrand(),
				medicineBean.getType());
		if (mmm == null)
			medicineDao.save(medicineBean);
		else {
			Optional<MedicineBean> o = medicineDao.findById(mmm.getMid());
			if (o.isPresent()) {
				MedicineBean mbm = o.get();

				mbm.setStock(medicineBean.getStock() + mbm.getStock());
				mbm.setExpiryDate(medicineBean.getExpiryDate());
				mbm.setPrice(medicineBean.getPrice());

				medicineDao.save(mbm);

			}

		}
		session.setAttribute("addm", 1);
		return "admin";
	}

	@RequestMapping("/editMedicine")
	public String editPage(Integer mid, @ModelAttribute("editmed") MedicineBean mb, Model model, HttpSession session) {
		if (session.getAttribute("id") == null)
			return "choose";

		String page = "editMedicine";
		Optional<MedicineBean> mbean = medicineDao.findById(mid);
		MedicineBean medicineBean;
		if (mbean.isPresent()) {
			medicineBean = mbean.get();
			model.addAttribute("editmed", medicineBean);
			session.setAttribute("mid", mid);
		}
		return page;

	}

	@RequestMapping("/save")
	public String edited(@Valid @ModelAttribute("editmed") MedicineBean mb, BindingResult br, HttpSession session) {
		if (session.getAttribute("id") == null)
			return "choose";

		String page = "admin";
		if (br.hasErrors()) {
			return "editMedicine";
		}
		Integer mid = ((Integer) session.getAttribute("mid"));
		if (mid != null) {
			Optional<MedicineBean> mbean = medicineDao.findById(mid);
			MedicineBean medicineBean = null;
			if (mbean.isPresent()) {
				medicineBean = mbean.get();
				mb.setSales(medicineBean.getSales());
				mb.setMid(medicineBean.getMid());

				medicineDao.save(mb);
			}
		}
		session.setAttribute("addm", 2);
		return "admin";

	}

	@RequestMapping("/adminhomepage")
	public String adminhome(HttpSession session, Model m) {
		if (session.getAttribute("id") == null)
			return "choose";
		session.setAttribute("addm", 0);
		Integer not = adminFunction.anyNotification();
		m.addAttribute("noti", not);
		session.setAttribute("notic",0);
		return "admin";
	}

	@RequestMapping("/updatemedicine")
	public String upadate(Integer mid, HttpSession session, Model model) {
		if (session.getAttribute("id") == null)
			return "choose";

		Optional<MedicineBean> o = medicineDao.findById(mid);
		MedicineBean med = null;
		if (o.isPresent())
			med = o.get();

		System.out.println("med updatemela" + med);
//		session.setAttribute("midd", mid);
		session.setAttribute("toupdate", med);
		model.addAttribute("update", med);
		return "updateMedicine";
	}

	@RequestMapping("/update")
	public String updated(@Valid @ModelAttribute("update") MedicineBean medicineBean, BindingResult br,
			HttpSession session, Model model) {
		if (session.getAttribute("id") == null)
			return "choose";

		MedicineBean med = (MedicineBean) session.getAttribute("toupdate");
		String page = "admin";
		medicineBean.setType(med.getType());
		medicineBean.setMid(med.getMid());
		medicineBean.setSales(med.getSales());
		if (br.hasErrors()) {
			model.addAttribute("update", medicineBean);
			return "updateMedicine";
		}

		medicineDao.save(medicineBean);

		session.setAttribute("addm", 3);
		return "admin";
	}

	@RequestMapping("/viewupdate")
	public String viewUpdate(HttpSession session, Model model) {
		if (session.getAttribute("id") == null)
			return "choose";

		List<MedicineBean> mb = medicineDao.findAll();
		model.addAttribute("medicines", mb);

		return "viewupdate";
	}

	@RequestMapping("/notification")
	public String notifypage(HttpSession session,Model m) {
		String page="notificationpage";
		
		List<MedicineBean> obj=adminFunction.getnotificaton();
		session.setAttribute("notic", 1);
		Integer not = adminFunction.anyNotification();
		m.addAttribute("noti", not);
		
		m.addAttribute("nott",obj);
		return page;
	}
	
}
