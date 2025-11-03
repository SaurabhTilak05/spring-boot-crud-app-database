package com.example.demo.repository;

import java.sql.*;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.PreparedStatementSetter;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import com.example.demo.model.*;

@Repository("empRepo")
public class EmpRepoImp implements EmpRepoInf{
	
	@Autowired
	JdbcTemplate template;
	
	public boolean isSave(Employee employee)
	{
		int value=template.update("insert into employee values('0',?,?,?,?)", new PreparedStatementSetter() {
			
			@Override
			public void setValues(PreparedStatement ps) throws SQLException {
				ps.setString(1, employee.getName());
				ps.setString(2, employee.getEmail());
				ps.setString(3, employee.getContact());
				ps.setString(4, employee.getSalary());
				
			}
		});
		return value>0? true:false;
		
	}

	@Override
	public List<Employee> getEmployee() {
		List<Employee> list=template.query("select * from employee ", new RowMapper<Employee>() {

			@Override
			public Employee mapRow(ResultSet rs, int rowNum) throws SQLException {
				
				Employee emp = new Employee();
				emp.setId(rs.getInt(1));
				emp.setName(rs.getString(2));
				emp.setEmail(rs.getString(3));
				emp.setContact(rs.getString(4));
				emp.setSalary(rs.getString(5));
				return emp;
			}
		});
		return list.size()>0?list:null;
	}

	@Override
	public Employee searchEmp(int id) {
		List<Employee> list=template.query("select *from employee where id=?",new RowMapper<Employee>() {

			@Override
			public Employee mapRow(ResultSet rs, int rowNum) throws SQLException {
				 Employee e = new Employee();
	                e.setId(rs.getInt("id"));
	                e.setName(rs.getString("name"));
	                e.setEmail(rs.getString("email"));
	                e.setContact(rs.getString("contact"));
	                e.setSalary(rs.getString("salary"));
	                return e;
			}
		}, id
		);
		return list.isEmpty() ? null : list.get(0);
		
		
	}

	@Override
	public Employee updateEmp(int id, Employee emp) {
		
		int value=template.update("UPDATE employee SET name = ?, email = ?, contact = ?, salary=?  WHERE id = ?", new Object[] {emp.getName(), emp.getEmail(),emp.getContact(),emp.getSalary(),id});
		return value>0 ? emp:null;
	
	}

	@Override
	public boolean isDelete(int id) {
		int value=template.update("delete from employee where id=?",+id);
		return value>0 ?true:false;
	}
	
}
