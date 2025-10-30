package com.example.demo.repository;

import java.util.List;

import com.example.demo.model.Employee;

public interface EmpRepoInf {

		public boolean isSave(Employee employee);
		public List<Employee> getEmployee();
}
