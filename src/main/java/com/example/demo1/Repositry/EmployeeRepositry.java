package com.example.demo1.Repositry;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.demo1.Dto.EmployeeDto;
import com.example.demo1.Entity.Employee;
import java.util.List;

@Repository
public interface EmployeeRepositry extends JpaRepository<Employee, Integer> {
	boolean existsByEmail(String email);
	boolean existsByNumber(long number);
	
	List<Employee> findByName(String name);
	
}
