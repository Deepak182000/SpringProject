package com.springproject.exceptions;

public class EmployeeNotFoundException extends RuntimeException {
public EmployeeNotFoundException(Long id) {
	super("could not found employee with id "+id );
}
}
