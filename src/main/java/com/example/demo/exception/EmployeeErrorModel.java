package com.example.demo.exception;

public class EmployeeErrorModel {

	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public EmployeeErrorModel(int id, String name) {
		super();
		this.id = id;
		this.name = name;
	}
	private int id;
	private String name;
	
}
