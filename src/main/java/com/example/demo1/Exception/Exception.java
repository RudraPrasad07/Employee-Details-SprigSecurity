package com.example.demo1.Exception;

import java.time.LocalDateTime;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import com.example.demo1.Utility.ResponseStructure;

@RestControllerAdvice
public class Exception {
	@ExceptionHandler(EmailAllreadyPresent.class)
	private ResponseEntity<ResponseStructure<String>> entityAllreadyPresent(EmailAllreadyPresent e) {
		ResponseStructure<String> s = new ResponseStructure<>(HttpStatus.CONFLICT.value(), e.getMessage(), null,
				LocalDateTime.now());
		return new ResponseEntity<ResponseStructure<String>>(s, HttpStatus.CONFLICT);
	}

	@ExceptionHandler(NumberAllreadypresent.class)
	private ResponseEntity<ResponseStructure<String>> numberAllreadyPresent(NumberAllreadypresent e) {
		ResponseStructure<String> s = new ResponseStructure<>(HttpStatus.FOUND.value(), e.getMessage(), null,
				LocalDateTime.now());
		return new ResponseEntity<ResponseStructure<String>>(s, HttpStatus.FOUND);
	}

}
