package com.example.demo1.Controller;

import java.time.LocalDateTime;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.web.bind.annotation.AuthenticationPrincipal;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestAttribute;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo1.Dto.EmployeeDto;
import com.example.demo1.Entity.Employee;
import com.example.demo1.Security.JwtTokenUtil;
import com.example.demo1.Service.EmployeeService;
import com.example.demo1.Utility.ResponseStructure;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.tags.Tag;

@RestController
@RequestMapping("/Employee")
@Tag(name = "Employee")

public class EmployeeController {
	@Autowired
	private EmployeeService service;
	@Autowired
	private JwtTokenUtil util;

	@Operation(description = "Create a table and saves a new Employee record. Returns the details of the created Employee", responses = {
			@ApiResponse(description = "Sucess", responseCode = "200"),
			@ApiResponse(description = "Email And PoneNumber Is allready present", responseCode = "400"),
			@ApiResponse(description = "Forbidden", responseCode = "403/401") })
	@PostMapping("/saveEmployee")
	public ResponseEntity<ResponseStructure<String>> saveEmployee(@RequestBody Employee employee) {
		Employee saveEmployee = service.saveEmployee(employee);
		if (saveEmployee != null) {
			String token = util.generateToken(employee.getName());
			ResponseStructure<String> s = new ResponseStructure<>(HttpStatus.OK.value(), token,
					"Token Generated Sucessfully", LocalDateTime.now());
			return new ResponseEntity<ResponseStructure<String>>(s, HttpStatus.OK);
		} else {
			throw new RuntimeException("Token Not Generated");
		}
	}

	@Operation(description = "Getting The Data Of The Employee From The Data Base", responses = {
			@ApiResponse(description = "Sucess", responseCode = "200"),
			@ApiResponse(description = "Failure", responseCode = "400"),
			@ApiResponse(description = "Forbidden", responseCode = "403/401")

	})
	@GetMapping("/getEmployee")
	public ResponseEntity<ResponseStructure<EmployeeDto>> getMethodName(@RequestHeader("Authorization") String token) {

		String name = util.extractUsername(token.substring(7));

		EmployeeDto employee = service.getEmployee(name);
		if (employee == null) {
			return new ResponseEntity<>(new ResponseStructure<>(HttpStatus.NOT_FOUND.value(), "Employee Not Found",
					null, LocalDateTime.now()), HttpStatus.NOT_FOUND);
		}

		ResponseStructure<EmployeeDto> response = new ResponseStructure<>(HttpStatus.OK.value(),
				"Data Fetched Successfully", employee, LocalDateTime.now());
		return new ResponseEntity<>(response, HttpStatus.OK);
	}

	@Operation(description = "Delete The employee recored from the DataBase", responses = {
			@ApiResponse(description = "Sucess", responseCode = "200"),
			@ApiResponse(description = "Failure", responseCode = "400"),
			@ApiResponse(description = "Forbidden", responseCode = "403/401") })
	@DeleteMapping("/delete")
	public ResponseEntity<ResponseStructure<?>> delete(@RequestHeader("Authorization") String token) {
		String name = util.extractUsername(token.substring(7));
		boolean delete = service.delete(name);
		if (!delete) {
			return new ResponseEntity<>(new ResponseStructure<>(HttpStatus.NOT_FOUND.value(), "Employee Not Found",
					null, LocalDateTime.now()), HttpStatus.NOT_FOUND);
		}
		ResponseStructure<EmployeeDto> response = new ResponseStructure<>(HttpStatus.OK.value(),
				"Data deleted Successfully", null, LocalDateTime.now());

		return new ResponseEntity<>(response, HttpStatus.OK);
	}
}
