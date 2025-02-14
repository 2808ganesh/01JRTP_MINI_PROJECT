package com.example.demo.reop;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.example.demo.entity.CitizenPlan;

@Repository
public interface CitizenReop extends JpaRepository<CitizenPlan, Integer>{

	@Query("select distinct(planName) from CitizenPlan")
	public List<String> getAllPlanNames();
	
	@Query("select distinct(planStatus) from CitizenPlan ")
	public List<String> getAllPlanStatus();
}
