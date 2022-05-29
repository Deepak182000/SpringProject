package com.springproject.exceptions;

public class EmployeeExistedException extends RuntimeException {
	public EmployeeExistedException() {
		super("Employee already existed in database");
	}

}
