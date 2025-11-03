package com.example.demo.repository;

import java.util.List;

import com.example.demo.model.Employee;

public interface EmpRepoInf {

		public boolean isSave(Employee employee);
		public List<Employee> getEmployee();
		public Employee searchEmp(int id);
		public Employee updateEmp(int id,Employee emp);
		public boolean isDelete(int id);
}
