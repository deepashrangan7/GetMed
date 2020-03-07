package com.project.controller;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpSession;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

import com.mysql.cj.Session;
import com.project.model.MedicineBean;
import com.project.model.SearchBean;
import com.project.service.MedicineDao;

@Controller
public class UserController {

	@Autowired
	private MedicineDao md;

	@RequestMapping("/uhome")
	public String uhome(Model m) {
		m.addAttribute("sb", new SearchBean());
		m.addAttribute("err",0);
		
		return "userhome";
	}


	@RequestMapping("/viewmedicine")
	public String viewmedicine(@Valid @ModelAttribute("sb") SearchBean sb, BindingResult br, Model m,
			HttpSession session) {
		if (br.hasErrors()) {
			System.out.println("error");
			return "viewmedicine";
		}
		List<MedicineBean> mb;
		if (sb.getType().equals("name")) {
			mb = md.findName(sb.getName().trim());
			if (mb.size() == 0) {
				List<MedicineBean> dummymb = md.findAll();
				for (MedicineBean m1 : dummymb) {
					if (m1.getName().contains(sb.getName())) {
						mb.add(m1);
					}
				}
			}

		} else {

			mb = md.findBrand(sb.getName().trim());

			if (mb.size() == 0) {
				List<MedicineBean> dummymb = md.findAll();
				for (MedicineBean m1 : dummymb) {
					if (m1.getBrand().contains(sb.getName())) {
						mb.add(m1);
					}
				}

			}

		}

		session.setAttribute("mediciness", mb);
		
		session.setAttribute("sb", sb);
		
		return "viewmedicine";

	}

	@ModelAttribute("cities")
	public List<String> getcity() {
		List<String> city;

		city = md.findAllCity();

		return city;

	}

	@RequestMapping("/sort")
	public String sort(String type, String order, Model m,HttpSession session) {
		String page = "viewallmedicine";
		List<MedicineBean> mb = new ArrayList<>();
		if (type.equals("name")) {
			if (order.equals("asc")) {
				mb = md.findNameAsc();

			} else
				mb = md.findNameDesc();
		}

		if (type.equals("brand")) {
			if (order.equals("asc")) {
				mb = md.findBrandAsc();

			} else
				mb = md.findBrandDesc();
		}

		if (type.equals("price")) {
			if (order.equals("asc")) {
				mb = md.findPriceAsc();

			} else
				mb = md.findPriceDesc();
		}

		if (type.equals("city")) {
			if (order.equals("asc")) {
				mb = md.findCityAsc();

			} else
				mb = md.findCityDesc();
		}
		session.setAttribute("medici", mb);
	

		if (m.getAttribute("sb") == null)
			m.addAttribute("sb", new SearchBean());

		return page;

	}
	
	@RequestMapping("/allmed")
	public String allmed(Model m) {
		
		m.addAttribute("medici", md.findAll());
		m.addAttribute("sb",new SearchBean());
		return "viewallmedicine";
	}
	
	@RequestMapping("/sorted")
	public String sortsearch(String type,String order,HttpSession session,Model model)
	{
		
		List<MedicineBean> prevmb=(List<MedicineBean>)session.getAttribute("mediciness");
		List<MedicineBean> done=new ArrayList<MedicineBean>();
		List<MedicineBean> mb=new ArrayList<>();
		
		if (type.equals("name")) {
			if (order.equals("asc")) {
				mb = md.findNameAsc();

			} else
				mb = md.findNameDesc();
		}

		if (type.equals("brand")) {
			if (order.equals("asc")) {
				mb = md.findBrandAsc();

			} else
				mb = md.findBrandDesc();
		}

		if (type.equals("price")) {
			if (order.equals("asc")) {
				mb = md.findPriceAsc();

			} else
				mb = md.findPriceDesc();
		}

		if (type.equals("city")) {
			if (order.equals("asc")) {
				mb = md.findCityAsc();

			} else
				mb = md.findCityDesc();
		}

		for(MedicineBean mm:mb)
		{
			for(int i=0;i<prevmb.size();i++)
			{
				if(mm.getName().equals(prevmb.get(i).getName())	&& mm.getBrand().equals(prevmb.get(i).getBrand()) && mm.getCity().equals(prevmb.get(i).getCity())  && mm.getType().equals(prevmb.get(i).getType()) ) {
					{
						System.out.println(prevmb+" here");
						done.add(mm);
					}
				
			}
				
			}
			
			
		}
		model.addAttribute("sb",new SearchBean());
		session.setAttribute("mediciness", done);
		
		return "viewmedicine";
	}
	
	
	
}// class
