package com.example.demo.controller;

import java.util.List;

import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.entity.CitizenPlan;
import com.example.demo.request.SearchRequest;
import com.example.demo.serviceimpl.CitizenServiceImpl;

@Controller
public class CitizenPlanController {

	@Autowired
	private CitizenServiceImpl serviceImpl;
	
	@GetMapping("/pdf")
	public void pdfExport(HttpServletResponse response) throws Exception {
		response.setContentType("application/pdf");
		response.addHeader("content-Disposition", "attachment;filename=plans.pdf");
		
		serviceImpl.exportPdf(response);
	}
	
	@GetMapping("/excel")
	public void excelExport(HttpServletResponse response) throws Exception {
		
		response.setContentType("application/octet-stream");
		
		response.addHeader("content-Disposition","attachment;filename=plans.xls");
		
		serviceImpl.exportExel(response);
	}

	@PostMapping("/search")
	public String handleSearch(@ModelAttribute("search") SearchRequest request, Model model) {

		System.out.println(request);

		List<CitizenPlan> planss = serviceImpl.search(request);
		model.addAttribute("planss", planss);

		init(model);
		return "index";
	}

	@GetMapping("/")
	public String indexPage(Model model) {
//		 SearchRequest searchObj = new SearchRequest();

		model.addAttribute("search", new SearchRequest());
		init(model);
		return "index";
	}

	private void init(Model model) {
//		model.addAttribute("search", new SearchRequest());
		model.addAttribute("plans", serviceImpl.findCitizenPlan());
		model.addAttribute("status", serviceImpl.findCitizenPlanStatus());
	}
}
