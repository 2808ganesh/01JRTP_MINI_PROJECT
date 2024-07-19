package com.example.demo.serviceimpl;

import java.io.File;
import java.io.FileOutputStream;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.List;

import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletResponse;

import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Example;
import org.springframework.stereotype.Service;

import com.example.demo.entity.CitizenPlan;
import com.example.demo.reop.CitizenReop;
import com.example.demo.request.SearchRequest;
import com.example.demo.service.CitizenService;
import com.example.demo.util.EmailUtils;
import com.example.demo.util.ExelGenerator;
import com.example.demo.util.PdfGenerator;
import com.lowagie.text.Document;
import com.lowagie.text.PageSize;
import com.lowagie.text.Paragraph;
import com.lowagie.text.pdf.PdfPTable;
import com.lowagie.text.pdf.PdfWriter;

@Service
public class CitizenServiceImpl implements CitizenService {

	@Autowired
	private CitizenReop repo;
	
	@Autowired
	private ExelGenerator exelGenerator;
	
	@Autowired
	private PdfGenerator pdfGenerator;
	
	@Autowired
	private EmailUtils emailUtils;

	@Override
	public List<String> findCitizenPlan() {
		List<String> allPlanNames = repo.getAllPlanNames();

		return allPlanNames;
	}

	@Override
	public List<String> findCitizenPlanStatus() {

		List<String> allPlanStatus = repo.getAllPlanStatus();

		return allPlanStatus;
	}

	@Override
	public List<CitizenPlan> search(SearchRequest request) {

		CitizenPlan entity = new CitizenPlan();

		if (null != request.getPlanName() && !"".equals(request.getPlanName())) {
			entity.setPlanName(request.getPlanName());
		}

		if (null != request.getPlanStatus() && !"".equals(request.getPlanStatus())) {
			entity.setPlanStatus(request.getPlanStatus());
		}

		if (null != request.getGender() && !"".equals(request.getGender())) {
			entity.setGender(request.getGender());
		}

		if (null != request.getPlanStartDate() && !"".equals(request.getPlanStartDate())) {
			String planStartDate = request.getPlanStartDate();

			DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MMM-dd");

			// convert String to localDate
			LocalDate localDate = LocalDate.parse(planStartDate, formatter);
			entity.setPlanStartDate(localDate);
		}

		if (null != request.getPlanEndDate() && !"".equals(request.getPlanEndDate())) {
			String planEndDate = request.getPlanEndDate();
			DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MMM-dd");

			// convert String to localDate
			LocalDate localDate = LocalDate.parse(planEndDate, formatter);
			entity.setPlanEndDate(localDate);
			
		}

		List<CitizenPlan> all = repo.findAll(Example.of(entity));

		return all;
	}

	@Override
	public boolean exportExel(HttpServletResponse response) throws Exception {
		

		File f = new File("Plans.xls");
		List<CitizenPlan> list = repo.findAll();
		
		exelGenerator.generator(response, list,f);
		
		String subject= "Test Mail Subject";
		String body = "<h1>Test Mail Body</h1>";
		String to = "ambhore.ganesh2808@gmail.com";
		

		emailUtils.sendEmail(subject, body, to,f);
		
		f.delete();
		
		return true;
	}

	@Override
	public boolean exportPdf(HttpServletResponse response) throws Exception {
 

		File f = new File("Plans.pdf");
		List<CitizenPlan> list = repo.findAll();  
		
		pdfGenerator.generator(response, list,f);
		

		String subject= "Test Mail Subject";
		String body = "<h1>Test Mail Body</h1>";
		String to = "ambhore.ganesh2808@gmail.com";
		
		emailUtils.sendEmail(subject, body, to,f);
		
		f.delete();
		
		return true;
	}



}
