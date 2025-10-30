package com.example.demo.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

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
		// TODO Auto-generated method stub
		return empRepo.getEmployee();
	}
	
	
}

