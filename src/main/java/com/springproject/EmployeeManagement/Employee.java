package com.springproject.EmployeeManagement;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;




@Entity

public class Employee {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long id;
	private String name;
	private String designation;
	private int salary;
	
	protected Employee() {
	
	}

	public Employee(String name, String designation, int salary) {
		this.name = name;
		this.designation = designation;
		this.salary = salary;
	}
	@Override
	public String toString() {
		return "Employee{" +
	"id=" + id + 
	", name='" + name + '\'' + 
	", designation=\'" + designation + '\'' + 
	", salary=" + salary +
	'}';
	}
	

	public long getId() {
		return id;
	}


	public String getName() {
		return name;
	}


	public int getSalary() {
		return salary;
	}

	public void setSalary(int salary) {
		this.salary = salary;
	}

	public String getDesignation() {
		return designation;
	}

	
}
