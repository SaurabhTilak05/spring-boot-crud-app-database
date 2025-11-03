package com.example.demo.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.exception.EmployeeNotFoundException;
import com.example.demo.model.*;
import com.example.demo.repository.*;

@Service(value = "empService")
public class EmpServImp implements EmpServInf {

	@Autowired
	private EmpRepoImp empRepo;
	@Override
	public boolean isSave(Employee employee) {
	
		return empRepo.isSave(employee);
	}
	@Override
	public List<Employee> getEmployee() {
		   try {
	            List<Employee> list = empRepo.getEmployee();

	            if (list == null || list.isEmpty()) {
	                throw new EmployeeNotFoundException("No employees found in the database");
	            }

	            return list;
	        } 
	        catch (EmployeeNotFoundException e) {
	            System.out.println(e.getMessage());
	            throw e; // Custom exception (handled globally)
	        } 
	        catch (Exception ex) {
	            System.out.println("Unexpected error: " + ex.getMessage());
	            throw new RuntimeException("Internal server error", ex);
	        }
	}
	@Override
	public Employee searchEmp(int id) {
		Employee emp=empRepo.searchEmp(id);
		if(emp!=null)
		{
			return emp;
		}
		throw new EmployeeNotFoundException("Employee Not Found of this Id:"+id);
	}
	@Override
	public Employee updateEmp(int id, Employee emp) {
		Employee emp1=empRepo.updateEmp(id, emp);
		if(emp1!=null)
		{
			return emp;
		}
		
		throw new EmployeeNotFoundException("Employee Not present of this id "+id);
	}
	@Override
	public boolean isDelete(int id) {
		// TODO Auto-generated method stub
		return empRepo.isDelete(id);
	}
	
	
}

