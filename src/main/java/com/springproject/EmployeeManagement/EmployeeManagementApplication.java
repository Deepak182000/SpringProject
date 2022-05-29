package com.springproject.EmployeeManagement;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class EmployeeManagementApplication {
	
	private static final Logger log = LoggerFactory.getLogger(EmployeeManagementApplication.class);

	public static void main(String[] args) {
		SpringApplication.run(EmployeeManagementApplication.class, args);
	}
	
	@Bean
	public CommandLineRunner loadDatabase(EmployeeRepository repository ) {
		return (args) -> {
			
			repository.save(new Employee("Suren", "Manager", 10000));
			repository.save(new Employee("Maran", "Attendar", 5000));
			repository.save(new Employee("Magesh", "Attendar", 5500));
			repository.save(new Employee("Vishal", "Manager", 4500));
			repository.save(new Employee("Bala", "Attendar", 15000));
			
			log.info("All Employees");
			log.info("---------------------");
			for (Employee employee : repository.findAll()) {
				log.info(employee.toString());
			}
			
			Employee employee = repository.findById(3L);
			log.info("Employee found with findbyId(3L):");
			log.info("----------------------");
			log.info(employee.toString());
	
		};
	}
	

}
