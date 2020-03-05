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
import com.project.model.UserBean;
import com.project.service.MedicineDao;

@Controller
public class AdminController {
	@Autowired
	private MedicineDao medicineDao;

	@RequestMapping("/adhome")
	public String adminMainPage(Model model, HttpSession session) {

		AdminBean ab = (AdminBean) session.getAttribute("id");

		List<MedicineBean> md = medicineDao.findByAdminId(ab.getEmailId().trim());
		System.out.println(md);
		model.addAttribute("medicines", md);
		return "adminHome";
	}

	@RequestMapping("/addm")
	public String adminMainPage(@ModelAttribute("addmed") MedicineBean medicineBean) {
		return "addmedicine";
	}

	@RequestMapping("/addmedicine")
	public String addMedicine(@Valid @ModelAttribute("addmed") MedicineBean medicineBean, BindingResult br,
			HttpSession session, Model model) {
		String page = "adminHome";
		if (br.hasErrors()) {
			System.out.println("error in med");
			return "addmedicine";
		}
		String role = (String) session.getAttribute("role");
		System.out.println(role + " in admin");
		if (role.equals("ad")) {
			AdminBean ab = (AdminBean) session.getAttribute("id");
//			System.out.println(ab);
			medicineBean.setAdminId(ab.getEmailId());

		} else {
			UserBean ub = (UserBean) session.getAttribute("id");
			medicineBean.setAdminId(ub.getEmailId());

		}
		medicineDao.save(medicineBean);

		return "admin";
	}

	@RequestMapping("/editMedicine")
	public String editPage(Integer mid,@ModelAttribute("editmed")MedicineBean mb,Model model) {
		String page = "editMedicine";
	Optional<MedicineBean> mbean=	medicineDao.findById(mid);
	MedicineBean medicineBean;
	if(mbean.isPresent())
	{
		medicineBean=mbean.get();
		model.addAttribute("editmed", medicineBean);
		model.addAttribute("mid", mid);
	}
	return page;

	}

	@RequestMapping("/save")
	public String edited(@ModelAttribute("editmed")MedicineBean mb,BindingResult br,Model model)
	{
		System.out.println("from map "+mb);
		String page="admin";
		if(br.hasErrors())
		{
			return "editMedicine";
		}
		Integer mid=((Integer)model.getAttribute("mid"));
		if(mid!=null)
		{Optional<MedicineBean> mbean=	medicineDao.findById(mid);
		MedicineBean medicineBean=null;
		if(mbean.isPresent())
		{	medicineBean=mbean.get();
//			medicineBean.setAdminId(mb.getAdminId());
			medicineBean.setBrand(mb.getBrand());
			medicineBean.setCity(mb.getCity());
			medicineBean.setDisease(mb.getDisease());
			medicineBean.setName(mb.getName());
			medicineBean.setType(mb.getType());
			medicineBean.setExpiryDate(mb.getExpiryDate());
//			medicineBean.setMid(mb.getMid());
			medicineBean.setPrice(mb.getPrice());
			medicineBean.setSales(mb.getSales());
			medicineBean.setStock(mb.getStock());
			
			System.out.println(medicineBean);
			
			//			model.addAttribute("editmed", medicineBean);
//			model.addAttribute("mid", mid);
			medicineDao.save(medicineBean);
		}}
		return page;
		
	}
	
}
