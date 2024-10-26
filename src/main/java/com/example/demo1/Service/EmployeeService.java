package com.example.demo1.Service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo1.Dto.EmployeeDto;
import com.example.demo1.Entity.Employee;
import com.example.demo1.Exception.EmailAllreadyPresent;
import com.example.demo1.Exception.NumberAllreadypresent;
import com.example.demo1.Repositry.EmployeeRepositry;

@Service
public class EmployeeService {
	@Autowired
	private EmployeeRepositry repositry;
	
	public Employee saveEmployee(Employee employee) {
		if(repositry.existsByEmail(employee.getEmail())) {
			throw new EmailAllreadyPresent("Email Allready Present");
		}
		
		if(repositry.existsByNumber(employee.getNumber())) {
		throw new NumberAllreadypresent("Number Allready Present");
		}
		return repositry.save(employee);
	}
	
	public EmployeeDto getEmployee(String name) {
		List<Employee> byName = repositry.findByName(name);
		if(byName!=null && !byName.isEmpty()) {
			Employee e=byName.get(0);
			return new EmployeeDto(e.getId(),e.getName(),e.getEmail(),e.getNumber(),e.getDob(),e.getAge());
		}
		else {
		return null;
		}
	}
	
	public boolean delete(String name) {
	    EmployeeDto employeeDto = getEmployee(name);
	    if (employeeDto == null) {
	        return false; 
	    }

	    
	    repositry.deleteById(employeeDto.getId());
	    return true; 
	}


}
