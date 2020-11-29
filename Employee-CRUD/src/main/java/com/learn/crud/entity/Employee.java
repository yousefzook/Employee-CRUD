package com.learn.crud.entity;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "employeeCollection")
public class Employee {

	@Id
	private int id;
	private String name;
	private String dob;

	public Employee(int id, String name, String dob) {
		this.id = id;
		this.name = name;
		this.dob = dob;
	}

	public int getId() {
		return id;
	}

	public String getName() {
		return name;
	}
	
	public String getDoB() {
		return dob;
	}

	public void setName(String name) {
		this.name = name;
	}

	public void setDoB(String dob) {
		this.dob = dob;
	}

}
