package com.example.demo.util;

import java.io.File;
import java.io.FileOutputStream;
import java.util.List;

import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Component;

import com.example.demo.entity.CitizenPlan;
import com.lowagie.text.Document;
import com.lowagie.text.PageSize;
import com.lowagie.text.Paragraph;
import com.lowagie.text.pdf.PdfPTable;
import com.lowagie.text.pdf.PdfWriter;

@Component
public class PdfGenerator {

	public void generator(HttpServletResponse response, List<CitizenPlan> list,File f) throws Exception {
		
		Document document = new Document(PageSize.A4); 
		PdfWriter.getInstance(document, response.getOutputStream());
		PdfWriter.getInstance(document,new FileOutputStream(f));
		
		document.open();
		
		Paragraph p = new Paragraph("Citizen Plan Info");
		p.setAlignment(Paragraph.ALIGN_CENTER);
	    document.add(p);
	    
	    PdfPTable table = new PdfPTable(6);
	    table.setSpacingBefore(9);
	    
	    table.addCell("Citizen ID");
	    table.addCell("Citizen Name");
	    table.addCell("Plan Name");
	    table.addCell("Plan Status");
	    table.addCell("PlanStartDate");
	    table.addCell("PlanEndDate");
	    
//	    List<CitizenPlan> list = repo.findAll();
	    
	    for (CitizenPlan citizenPlan : list) {

		    table.addCell(String.valueOf(citizenPlan.getCitizenId()));
		    table.addCell(citizenPlan.getCitizenName());
		    table.addCell(citizenPlan.getPlanName());
		    table.addCell(citizenPlan.getPlanStatus());
		    table.addCell(citizenPlan.getPlanStartDate()+"");
		    table.addCell(citizenPlan.getPlanEndDate()+"");
		}
	    
	    document.add(table);
		document.close();
	}
}
