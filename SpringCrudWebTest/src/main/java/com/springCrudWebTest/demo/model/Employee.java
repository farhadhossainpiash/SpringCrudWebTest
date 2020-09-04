package com.springCrudWebTest.demo.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="employees")
public class Employee {
   
    @Id
    @GeneratedValue (strategy = GenerationType.IDENTITY)
	private int id;
	private String name;
	private String address;
	private String email;
	
	
	public Employee() {
		super();
		
	}


	public Employee(String name, String address, String email) {
		super();
		this.name = name;
		this.address = address;
		this.email = email;
	}



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


	public String getAddress() {
		return address;
	}


	public void setAddress(String address) {
		this.address = address;
	}


	public String getEmail() {
		return email;
	}


	public void setEmail(String email) {
		this.email = email;
	}
	
}