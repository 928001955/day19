package com.travelSky.entity;

public class Employee {
	private int id;
	private String name;
	private String gender;
	private String title;
	private String email;
	private double salary;

	public Employee(int id, String name, String gender, String title, String email, double salary) {
		super();
		this.id = id;
		this.name = name;
		this.gender = gender;
		this.title = title;
		this.email = email;
		this.salary = salary;
	}

	public Employee() {
		super();
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

	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public double getSalary() {
		return salary;
	}

	public void setSalary(double salary) {
		this.salary = salary;
	}

}
