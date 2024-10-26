package com.example.demo1.Dto;

import java.sql.Date;

import io.swagger.v3.oas.annotations.tags.Tag;
@Tag(name = "Employee DTO Class")
public class EmployeeDto {

	public EmployeeDto(int id, String name, String email, long phoneNumber, Date dob, int age) {
		super();
		this.id = id;
		this.name = name;
		this.email = email;
		this.phoneNumber = phoneNumber;
		this.dob = dob;
		this.age = age;
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
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public long getPhoneNumber() {
		return phoneNumber;
	}
	public void setPhoneNumber(long phoneNumber) {
		this.phoneNumber = phoneNumber;
	}
	public Date getDob() {
		return dob;
	}
	public void setDob(Date dob) {
		this.dob = dob;
	}
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}
	private int id;
	private String name;
	private String email;
	private long phoneNumber;
	private Date dob;
	private int age;
}
