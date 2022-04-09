package com.pet.adoption.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.pet.adoption.dto.LoginTokenDto;
import com.pet.adoption.dto.param.LoginParam;
import com.pet.adoption.model.Employee;
import com.pet.adoption.security.AuthenticationService;
import com.pet.adoption.service.EmployeeServiceImpl;

@RestController
@RequestMapping("/api/empAuth")
public class EmpAuthenticationController {

	@Autowired
	private EmployeeServiceImpl employeeServiceImpl;

	@Autowired
	private AuthenticationService authenticationService;

	@PostMapping("/login")
	public LoginTokenDto login(@RequestBody LoginParam employee) {
		return authenticationService.loginAndReturnJWT(employee);
	}
	
	
	@PostMapping("/sign-in")
	public Employee SignIn(@RequestBody Employee employee) {
		return employeeServiceImpl.saveEmployee(employee);
	}
	
	
	
}
