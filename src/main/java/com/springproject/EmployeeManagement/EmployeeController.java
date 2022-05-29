package com.springproject.EmployeeManagement;

import java.util.Optional;
import org.springframework.web.bind.annotation.*;
import org.springframework.data.domain.Sort;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import com.springproject.exceptions.EmployeeExistedException;
import com.springproject.exceptions.EmployeeNotFoundException;

@RestController

public class EmployeeController {
	private final EmployeeRepository employeeRepository;

	
	public EmployeeController(EmployeeRepository employeeRepository ) {
		this.employeeRepository = employeeRepository;
	}
	
	@GetMapping("/employees")
	Iterable<Employee> getAllEmployees() {
		return employeeRepository.findAll(Sort.by(Sort.Order.desc("salary"), Sort.Order.asc("name")));
	}
	
	@PostMapping("/employees")
	Employee newEmployee(@RequestBody Employee newEmployee) {
		if(employeeRepository.existsById(newEmployee.getId()))
			throw new EmployeeExistedException();
		else return employeeRepository.save(newEmployee);
	}
	
	@GetMapping("/employees/{id}")
	Employee getEmployee(@PathVariable Long id) {
		return employeeRepository.findById(id)
				.orElseThrow(() -> new EmployeeNotFoundException(id));
	}
	
	@DeleteMapping("/employees/{id}")
	void deleteEmployee(@PathVariable Long id) {
		employeeRepository.deleteById(id);
	}
	
	@PutMapping("/employees/upSalary/{id}/{salary}")
	ResponseEntity<Employee> updateSalary(@PathVariable long id, @PathVariable int salary) {
		Employee employee = getEmployee(id);
		employee.setSalary(salary);
		employeeRepository.save(employee);
		return ResponseEntity.ok(employee);
		
		
	}
	

}
