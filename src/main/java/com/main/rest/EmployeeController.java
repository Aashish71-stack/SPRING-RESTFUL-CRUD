package com.main.rest;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.main.model.Employee;
import com.main.service.EmployeeService;

@RestController
@RequestMapping("/api")
public class EmployeeController {

	@Autowired
	private EmployeeService employeeService;
	
//====================================REGISTER EMPLOYEE========================================================================
	@PostMapping(value = "/employees/register")
	public ResponseEntity<Employee> addEmployee(@RequestBody Employee employee)
	{
		Employee registeredEmployee=employeeService.registerEmployee(employee);
		if(registeredEmployee!=null)
		{
			return new ResponseEntity<Employee>(registeredEmployee, HttpStatus.CREATED);
		}
		return new ResponseEntity<Employee>(HttpStatus.BAD_REQUEST);
	}
	
//======================================GET ALL EMPLOYEES=========================================================================
	
	@GetMapping(value = "/employees/admin")
	public ResponseEntity<List<Employee>> getEmployee()
	{
			List<Employee> empList=employeeService.getEmployees();
			if(empList!=null)
			{
				return new ResponseEntity<List<Employee>>(empList, HttpStatus.OK);
			}
			return new ResponseEntity<List<Employee>>(HttpStatus.NO_CONTENT);
	}
	
//=============================================================================================================
	
	
	
}
