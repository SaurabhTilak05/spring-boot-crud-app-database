package com.example.demo.service;

import java.util.List;

import com.example.demo.model.Employee;

public interface EmpServInf {

	public boolean isSave(Employee employee);
	public List<Employee> getEmployee();
}
