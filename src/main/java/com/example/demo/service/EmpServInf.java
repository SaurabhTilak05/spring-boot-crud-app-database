package com.example.demo.service;

import java.util.List;

import com.example.demo.model.Employee;

public interface EmpServInf {

	public boolean isSave(Employee employee);
	public List<Employee> getEmployee();
	public List<Employee> searchEmp(String name);
	public Employee getEmpByid(int id);
	public Employee updateEmp(int id, Employee emp);
	public boolean isDelete(int id);
	
}
