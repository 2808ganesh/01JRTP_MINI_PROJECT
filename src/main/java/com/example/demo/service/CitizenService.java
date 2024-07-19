package com.example.demo.service;

import java.util.List;

import javax.servlet.http.HttpServletResponse;

import com.example.demo.entity.CitizenPlan;
import com.example.demo.request.SearchRequest;

public interface CitizenService {

	public List<String> findCitizenPlan();
	
	public List<String> findCitizenPlanStatus();
	
	public List<CitizenPlan> search(SearchRequest request);
	
	public boolean exportExel(HttpServletResponse response) throws Exception;
	
	public boolean exportPdf(HttpServletResponse response) throws Exception;
	
}
