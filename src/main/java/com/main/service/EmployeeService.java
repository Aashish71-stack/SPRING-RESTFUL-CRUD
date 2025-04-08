package com.main.service;

import java.util.List;

import com.main.model.Employee;

public interface EmployeeService {

	Employee registerEmployee(Employee employee);

	List<Employee> getEmployees();

}
