package com.example.demo1.Entity;

import java.sql.Date;

import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
@Tag(name = "Employee Entity class")
public class Employee {
		@Id
		@GeneratedValue(strategy = GenerationType.IDENTITY)
		private int id;
		@Column(nullable = false)
		private String name;
		@Column(nullable = false,unique = true)
		private String email;
		@Column(nullable = false)
		private int age;
		@Column(nullable = false)
		private Date dob;
		private char gender;
		@Column(nullable = false,unique = true)
		private long number;
		
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
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}
	public Date getDob() {
		return dob;
	}
	public void setDob(Date dob) {
		this.dob = dob;
	}
	public char getGender() {
		return gender;
	}
	public void setGender(char gender) {
		this.gender = gender;
	}
	public long getNumber() {
		return number;
	}
	public void setNumber(long number) {
		this.number = number;
	}
		
	public Employee(int id, String name, String email, int age, Date dob, char gender, long number) {
		super();
		this.id = id;
		this.name = name;
		this.email = email;
		this.age = age;
		this.dob = dob;
		this.gender = gender;
		this.number = number;
	}
	public Employee() {}
}
