package com.example.homework26;

import com.example.homework26.exception.EmployeeAlreadyAddedException;
import com.example.homework26.exception.EmployeeNotFoundException;
import com.example.homework26.exception.EmployeeStorageIsFullException;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class EmployeeService implements EmployeeServiceInterface {
	private final List<Employee> employees;
	private static final int countEmployees = 10;

	public EmployeeService() {
		this.employees = new ArrayList<>();
	}

	@Override
	public Employee addEmployee(String firstName, String lastName) {
		checkSizeArray();
		Employee employee = new Employee(firstName, lastName);
		if (checkExistEmployee(employee)) {
			throw new EmployeeAlreadyAddedException(employee);
		}
		employees.add(employee);
		return employee;
	}

	@Override
	public Employee removeEmployee(String firstName, String lastName) {
		Employee employee = new Employee(firstName, lastName);
		if (!checkExistEmployee(employee)) {
			throw new EmployeeNotFoundException(employee);
		}
		employees.remove(employee);
		return employee;
	}

	@Override
	public Employee findEmployee(String firstName, String lastName) {
		Employee employee = new Employee(firstName, lastName);
		if (!checkExistEmployee(employee)) {
			throw new EmployeeNotFoundException(employee);
		}
		return employee;
	}

	@Override
	public List<Employee> allEmployees() {
		return employees;
	}

	private boolean checkExistEmployee(Employee employee) {
		return employees.contains(employee);
	}

	private boolean checkSizeArray() {
		if (employees.size() == countEmployees) {
			throw new EmployeeStorageIsFullException();
		}
		return true;
	}

}
