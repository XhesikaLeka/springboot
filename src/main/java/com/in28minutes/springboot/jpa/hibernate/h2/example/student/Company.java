package com.in28minutes.springboot.jpa.hibernate.h2.example.student;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Company {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long id;
	private String name;
	private int number_of_employees;
	
	public Company() {
		super();
	}
	public Company(String name, int number_of_employees) {
		super();
		this.name = name;
		this.number_of_employees = number_of_employees;
	}
	public Company(Long id, String name, int number_of_employees) {
		super();
		this.id = id;
		this.name = name;
		this.number_of_employees = number_of_employees;
	}
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getNumber_of_employees() {
		return number_of_employees;
	}
	public void setNumber_of_employees(int number_of_employees) {
		this.number_of_employees = number_of_employees;
	}
	@Override
	public String toString() {
		return "Company [id=" + id + ", name=" + name + ", number_of_employees=" + number_of_employees + "]";
	}
	

	

	

}
