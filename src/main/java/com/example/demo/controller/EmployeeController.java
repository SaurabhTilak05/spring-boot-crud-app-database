package com.example.demo.controller;

import java.util.*;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.model.Employee;
import com.example.demo.service.*;

@RestController
@RequestMapping("/employee")
@CrossOrigin
public class EmployeeController {
	
	@Autowired
	private EmpServImp empService;
	
	@PostMapping("/save")
	public Map<String,String> isSave(@RequestBody Employee employee)
	{
		boolean b=empService.isSave(employee);
		 Map<String, String> map = new HashMap<>();
		    map.put("message", b ? "Employee saved successfully!" : "Failed to save employee!");
		    return map;
	}
	
	@GetMapping("/viewall")
	public List<Employee> getAllEmployee(){		
		return empService.getEmployee();
	}

	@GetMapping("/searchbyname/{name}")
	public List<Employee> getEmpById(@PathVariable("name") String name) {
		
		return empService.searchEmp(name);
	}
	
	
	@GetMapping("/getById/{id}")
	public Employee getEmployeeByid(@PathVariable("id") Integer id)
	{
		Employee em=empService.getEmpByid(id);
		return em;
	}
	
	@PutMapping("/updatebyid/{id}")
	public Employee updateEmpById(@PathVariable("id") Integer id, @RequestBody Employee emp) {
		Employee emp1= empService.updateEmp(id, emp);
		return emp1 ;
	}
	@DeleteMapping("/delbyid/{id}")
	public String DeleteEmpById(@PathVariable("id") Integer id) {
		boolean b= empService.isDelete(id);
		return b ? "Employee Delete successfully!" : "Failed to Delete employee!";
	}
	
}
