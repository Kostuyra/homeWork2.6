package com.example.homework26;
import java.util.List;


public interface EmployeeServiceInterface {

	Employee addEmployee(String firstName, String lastName);

	Employee removeEmployee(String firstName, String lastName);

	Employee findEmployee(String firstName, String lastName);

	List<Employee> allEmployees();
}
