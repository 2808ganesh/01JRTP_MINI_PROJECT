package com.example.demo.runner;

import java.time.LocalDate;
import java.util.Arrays;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Component;

import com.example.demo.entity.CitizenPlan;
import com.example.demo.reop.CitizenReop;

@Component
public class DataLoader implements ApplicationRunner {

	@Autowired
	private CitizenReop citizenReop;

	@Override
	public void run(ApplicationArguments args) throws Exception {

		
		citizenReop.deleteAll();
		
		
		// cash plan Data

		CitizenPlan c1 = new CitizenPlan();
		c1.setCitizenName("john");
		c1.setGender("Male");
		c1.setPlanName("Cash");
		c1.setPlanStatus("Approved");
		c1.setPlanStartDate(LocalDate.now());
		c1.setPlanEndDate(LocalDate.now().plusMonths(6));
		c1.setBenifitAmount(5000.00);

		CitizenPlan c2 = new CitizenPlan();
		c2.setCitizenName("smith");
		c2.setGender("Male");
		c2.setPlanName("Cash");
		c2.setPlanStatus("Denied");
		c2.setPlanStartDate(LocalDate.now());
		c2.setPlanEndDate(LocalDate.now().plusMonths(6));
		c2.setDenialReason("Rental Income");

		CitizenPlan c3 = new CitizenPlan();
		c3.setCitizenName("cathy");
		c3.setGender("Fe-male");
		c3.setPlanName("Cash");
		c3.setPlanStatus("Terminated");
		c3.setPlanStartDate(LocalDate.now().minusMonths(4));
		c3.setPlanEndDate(LocalDate.now().plusMonths(6));
		c3.setBenifitAmount(5000.00);
		c3.setTerminateDate(LocalDate.now());
		c3.setTerminationRsn("Employed");

		
		// Food Plan Data

		CitizenPlan c4 = new CitizenPlan();
		c4.setCitizenName("david");
		c4.setGender("Male");
		c4.setPlanName("Food");
		c4.setPlanStatus("Approved");
		c4.setPlanStartDate(LocalDate.now());
		c4.setPlanEndDate(LocalDate.now().plusMonths(6));
		c4.setBenifitAmount(4000.00);

		CitizenPlan c5 = new CitizenPlan();
		c5.setCitizenName("Robert");
		c5.setGender("Male");
		c5.setPlanName("Food");
		c5.setPlanStatus("Denied");
		c5.setPlanStartDate(LocalDate.now());
		c5.setPlanEndDate(LocalDate.now().plusMonths(6));
		c5.setDenialReason("Rental Income");

		CitizenPlan c6 = new CitizenPlan();
		c6.setCitizenName("orlen");
		c6.setGender("Fe-male");
		c6.setPlanName("Food");
		c6.setPlanStatus("Terminated");
		c6.setPlanStartDate(LocalDate.now().minusMonths(4));
		c6.setPlanEndDate(LocalDate.now().plusMonths(6));
		c6.setBenifitAmount(5000.00);
		c6.setTerminateDate(LocalDate.now());
		c6.setTerminationRsn("Employed");

		
		// Medical Plan Data

		CitizenPlan c7 = new CitizenPlan();
		c7.setCitizenName("Charles");
		c7.setGender("Male");
		c7.setPlanName("Medical");
		c7.setPlanStatus("Approved");
		c7.setPlanStartDate(LocalDate.now());
		c7.setPlanEndDate(LocalDate.now().plusMonths(6));
		c7.setBenifitAmount(4000.00);

		CitizenPlan c8 = new CitizenPlan();
		c8.setCitizenName("Michel");
		c8.setGender("Male");
		c8.setPlanName("Medical");
		c8.setPlanStatus("Denied");
		c8.setPlanStartDate(LocalDate.now());
		c8.setPlanEndDate(LocalDate.now().plusMonths(6));
		c8.setDenialReason("Rental Income");

		CitizenPlan c9 = new CitizenPlan();
		c9.setCitizenName("Neel");
		c9.setGender("Fe-male");
		c9.setPlanName("Medical");
		c9.setPlanStatus("Terminated");
		c9.setPlanStartDate(LocalDate.now().minusMonths(4));
		c9.setPlanEndDate(LocalDate.now().plusMonths(6));
		c9.setBenifitAmount(5000.00);
		c9.setTerminateDate(LocalDate.now());
		c9.setTerminationRsn("Gov Job");

		
		// Employment Plan Data

		CitizenPlan c10 = new CitizenPlan();
		c10.setCitizenName("Peter");
		c10.setGender("Male");
		c10.setPlanName("Medical");
		c10.setPlanStatus("Approved");
		c10.setPlanStartDate(LocalDate.now());
		c10.setPlanEndDate(LocalDate.now().plusMonths(6));
		c1.setBenifitAmount(4000.00);

		CitizenPlan c11 = new CitizenPlan();
		c11.setCitizenName("tony");
		c11.setGender("Male");
		c11.setPlanName("Medical");
		c11.setPlanStatus("Denied");
		c11.setPlanStartDate(LocalDate.now());
		c11.setPlanEndDate(LocalDate.now().plusMonths(6));
		c11.setDenialReason("Rental Income");

		CitizenPlan c12 = new CitizenPlan();
		c12.setCitizenName("paul");
		c12.setGender("Fe-male");
		c12.setPlanName("Medical");
		c12.setPlanStatus("Terminated");
		c12.setPlanStartDate(LocalDate.now().minusMonths(4));
		c12.setPlanEndDate(LocalDate.now().plusMonths(6));
		c12.setBenifitAmount(5000.00);
		c12.setTerminateDate(LocalDate.now());
		c9.setTerminationRsn("Gov Job");
		
		List<CitizenPlan> list = Arrays.asList(c1,c2,c3,c4,c5,c6,c7,c8,c9,c10,c11,c12);
		
		citizenReop.saveAll(list);

	}

}
