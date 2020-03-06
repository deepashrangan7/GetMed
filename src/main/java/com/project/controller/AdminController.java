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

import com.project.service.MedicineDao;

@Controller
public class AdminController {
	@Autowired
	private MedicineDao medicineDao;

	@RequestMapping("/adhome")
	public String adminMainPage(Model model, HttpSession session) {
		if(session.getAttribute("id")==null)
			return "choose";
		
		AdminBean ab = (AdminBean) session.getAttribute("id");

		List<MedicineBean> md = medicineDao.findByAdminId(ab.getEmailId().trim());
//		System.out.println(md);
		model.addAttribute("medicines", md);
		return "adminHome";
	}

	@RequestMapping("/addm")
	public String adminMainPage(@ModelAttribute("addmed") MedicineBean medicineBean,HttpSession session) {
		if(session.getAttribute("id")==null)
			return "choose";
		
		return "addmedicine";
	}

	@RequestMapping("/addmedicine")
	public String addMedicine(@Valid @ModelAttribute("addmed") MedicineBean medicineBean, BindingResult br,
			HttpSession session, Model model) {
		if(session.getAttribute("id")==null)
			return "choose";
		
		String page = "adminHome";
		if (br.hasErrors()) {
//			System.out.println("error in med");
			return "addmedicine";
		}
		String role = (String) session.getAttribute("role");
		System.out.println(role + " in admin");
		if (role.equals("ad")) {
			AdminBean ab = (AdminBean) session.getAttribute("id");
//			System.out.println(ab);
			medicineBean.setAdminId(ab.getEmailId());

		} 
		medicineDao.save(medicineBean);
		session.setAttribute("addm", 1);
		return "admin";
	}

	@RequestMapping("/editMedicine")
	public String editPage(Integer mid, @ModelAttribute("editmed") MedicineBean mb, Model model,HttpSession session) {
		if(session.getAttribute("id")==null)
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
	public String edited(@ModelAttribute("editmed") MedicineBean mb, BindingResult br,HttpSession session) {
		if(session.getAttribute("id")==null)
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

				mb.setAdminId(medicineBean.getAdminId());
				mb.setMid(medicineBean.getMid());
				
				medicineDao.save(mb);
			}
		}
			session.setAttribute("addm", 2);
			return page;

	}
	
	@RequestMapping("/adminhomepage")
	public String adminhome (HttpSession session)
	{
		session.setAttribute("addm",0);
		
		return "admin";
	}
	
	@RequestMapping("/updatemedicine")
	public String upadate(Integer mid,HttpSession session,Model model)
	{
		if(session.getAttribute("id")==null)
			return "choose";
		

		Optional<MedicineBean> o=medicineDao.findById(mid);
		MedicineBean med=null;
		if(o.isPresent())
			med=o.get();
		
		System.out.println("med updatemela"+med);
//		session.setAttribute("midd", mid);
		session.setAttribute("toupdate", med);
		model.addAttribute("update",med);
		return "updateMedicine";
	}
	
	@RequestMapping("/update")
	public String updated(@ModelAttribute("update")MedicineBean medicineBean,BindingResult br,HttpSession session,Model model)
	{
		if(session.getAttribute("id")==null)
			return "choose";
		
		MedicineBean med=(MedicineBean)session.getAttribute("toupdate");
		String page="admin";
		medicineBean.setType(med.getType());
		medicineBean.setMid(med.getMid());
	
		medicineBean.setAdminId(med.getAdminId());
	
		if(br.hasErrors())
		{
			model.addAttribute("update",medicineBean);
			return "updateMedicine";
		}
		System.out.println("keela "+medicineBean);
		
		//medicineBean.setSales(med.getSales());
		//medicineBean.setMid(med.get);
		
		medicineDao.save(medicineBean);
		
		session.setAttribute("addm", 3);
		return page;
	}
	@RequestMapping("/viewupdate")
	public String viewUpdate(HttpSession session,Model model)
	{
		if(session.getAttribute("id")==null)
			return "choose";
		
		AdminBean ab=(AdminBean)session.getAttribute("id");
	List<MedicineBean>	mb=medicineDao.findByAdminId(ab.getEmailId());
		model.addAttribute("medicines",mb);
	
		return "viewupdate";
	}
	
}
