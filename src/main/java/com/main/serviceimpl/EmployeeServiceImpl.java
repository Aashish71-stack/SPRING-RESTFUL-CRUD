package com.main.serviceimpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;

import com.main.model.Employee;
import com.main.repository.EmployeeRepository;
import com.main.service.EmployeeService;

@Service
public class EmployeeServiceImpl implements EmployeeService {

	@Autowired
	private EmployeeRepository employeeRepository;
	
	@Autowired
	private JavaMailSender javaMailSender;
	
	@Value("${spring.mail.username}")
	public String mailSender;
	
//===============================================================================================================

	@Override
	public Employee registerEmployee(Employee employee) {

		Employee registeredEmployee = employeeRepository.save(employee);
	
		if(registeredEmployee!=null)
		{
			SimpleMailMessage mailMessage=new SimpleMailMessage();
			String msg="REGISTRATION SUCEESFULLY !!";
			mailMessage.setFrom(mailSender);
			mailMessage.setTo(employee.getEmailId());
			mailMessage.setText("WELCOME TO COMPANY"+employee.getEmpName());
			mailMessage.setSubject(mailSender);
			
			javaMailSender.send(mailMessage);
			
			return registeredEmployee;
		}
		
		return registeredEmployee;
	}
//===================================================================================================================	
	
	@Override
	public List<Employee> getEmployees() {

		List<Employee> list = employeeRepository.findAll();
		if(list!=null)
		{
			return list;
		}
		return null;
	}
	
//=================================================================================================================================================	
	
	
	
	
	
	
	
}
