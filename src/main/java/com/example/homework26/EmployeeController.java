package com.example.homework26;

import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/employee")
public class EmployeeController {
	private final EmployeeServiceInterface employeeServiceInterface;

	public EmployeeController(EmployeeServiceInterface employeeServiceInterface) {
		this.employeeServiceInterface = employeeServiceInterface;
	}

	@GetMapping("/add")
	Employee addEmployee(@RequestParam() String firstName, @RequestParam() String lastName) {
		return employeeServiceInterface.addEmployee(firstName, lastName);
	}


	@GetMapping("/delete")
	Employee removeEmployee(@RequestParam() String firstName, @RequestParam() String lastName) {
		return employeeServiceInterface.removeEmployee(firstName, lastName);
	}

	@GetMapping("/find")
	Employee findEmployee(@RequestParam() String firstName, @RequestParam() String lastName) {
	return employeeServiceInterface.findEmployee(firstName, lastName);
	}

	@GetMapping()
	List<Employee> allEmployees() {
		return employeeServiceInterface.allEmployees();
	}


}
