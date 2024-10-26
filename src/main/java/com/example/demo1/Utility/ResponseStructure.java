package com.example.demo1.Utility;

import java.time.LocalDateTime;


public class ResponseStructure<T> {

	
	public ResponseStructure(int statuscode, String message, T data, LocalDateTime time) {
	
		Statuscode = statuscode;
		this.message = message;
		Data = data;
		this.time = time;
	}
	public int getStatuscode() {
		return Statuscode;
	}
	public void setStatuscode(int statuscode) {
		Statuscode = statuscode;
	}
	public String getMessage() {
		return message;
	}
	public void setMessage(String message) {
		this.message = message;
	}
	public T getData() {
		return Data;
	}
	public void setData(T data) {
		Data = data;
	}
	public LocalDateTime getTime() {
		return time;
	}
	public void setTime(LocalDateTime time) {
		this.time = time;
	}
	private int Statuscode;
	private String message;
	private T Data;
	private LocalDateTime time;
}
