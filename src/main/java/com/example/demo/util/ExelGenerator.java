package com.example.demo.util;

import java.io.File;
import java.io.FileOutputStream;
import java.util.List;

import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletResponse;

import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.springframework.stereotype.Component;

import com.example.demo.entity.CitizenPlan;

@Component
public class ExelGenerator {

	
	public void generator(HttpServletResponse response, List<CitizenPlan> list, File file) throws Exception {
		
		HSSFWorkbook workbook = new HSSFWorkbook();
		Sheet sheet = workbook.createSheet("plans-data");
		Row headerRow = sheet.createRow(0);
		
		headerRow.createCell(0).setCellValue("ID");
		headerRow.createCell(1).setCellValue("Citizen Value");
		headerRow.createCell(2).setCellValue("Plan Name");
		headerRow.createCell(3).setCellValue("Plan Status");
		headerRow.createCell(4).setCellValue("Plan StartData");
		headerRow.createCell(5).setCellValue("Plan EndDate");
		headerRow.createCell(6).setCellValue("Benifit Amount");
		

//		List<CitizenPlan> list = repo.findAll();
		
		int dataIndexRow=1;
		
		for (CitizenPlan plan : list) {
			Row dataRow = sheet.createRow(dataIndexRow);
			dataRow.createCell(0).setCellValue(plan.getCitizenId());
			dataRow.createCell(1).setCellValue(plan.getCitizenName());
			dataRow.createCell(2).setCellValue(plan.getPlanName());
			dataRow.createCell(3).setCellValue(plan.getPlanStatus());
			
			if(null != plan.getPlanStartDate()) {
			dataRow.createCell(4).setCellValue(plan.getPlanStartDate()+"");
			}else{
				dataRow.createCell(4).setCellValue("N/A");
			}
			
			if(null !=plan.getPlanEndDate()) {
			dataRow.createCell(5).setCellValue(plan.getPlanEndDate()+"");
			}else {
				dataRow.createCell(5).setCellValue("N/A");
			}
			
			if(null !=plan.getBenifitAmount()) {
			dataRow.createCell(6).setCellValue(plan.getBenifitAmount());
			}else {
				dataRow.createCell(6).setCellValue("N/A");
			}
			dataIndexRow++;
		}
		
		FileOutputStream fileOutputStream = new FileOutputStream(new File("plans.xls"));
		workbook.write(fileOutputStream);
		workbook.close();
		
		ServletOutputStream outputStream = response.getOutputStream();
		workbook.write(outputStream);
		workbook.close();
	}
}
