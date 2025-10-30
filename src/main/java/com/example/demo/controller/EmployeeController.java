package com.example.demo.controller;

import java.util.*;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.model.Employee;
import com.example.demo.service.*;

@RestController
public class EmployeeController {
	
	@Autowired
	private EmpServImp empService;
	
	@PostMapping("/save")
	public String isSave(@RequestBody Employee employee)
	{
		boolean b=empService.isSave(employee);
		return b ? "Employee saved successfully!" : "Failed to save employee!";
	}
	
	@GetMapping("/viewall")
	public List<Employee> getAllEmployee(){
		return empService.getEmployee();
		
	}
//
//	@GetMapping("/searchbyid/{id}")
//	public Employee getEmpById(@PathVariable("id") Integer id, @RequestBody Employee emp) {
//		return emp;
//	}
//	
//	@PutMapping("/updatebyid/{id}")
//	public Employee updateEmpById(@PathVariable("id") Integer id, @RequestBody Employee emp) {
//		return emp;
//	}
}
