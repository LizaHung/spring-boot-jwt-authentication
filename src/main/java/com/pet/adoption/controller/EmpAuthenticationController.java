package com.pet.adoption.controller;

import java.io.IOException;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.pet.adoption.dto.EmployeeDto;
import com.pet.adoption.dto.LoginTokenDto;
import com.pet.adoption.dto.param.EmployeeParam;
import com.pet.adoption.dto.param.LoginParam;
import com.pet.adoption.security.AuthenticationService;
import com.pet.adoption.service.EmployeeService;

@RestController
@RequestMapping("/empAuth")
public class EmpAuthenticationController {

	@Autowired
	private EmployeeService empService;

	@Autowired
	private AuthenticationService authenticationService;

	@PostMapping("/login")
	public LoginTokenDto login(@RequestBody LoginParam employee) {
		return authenticationService.loginAndReturnJWT(employee);
	}
	
//	@PostMapping("/refreshToken")
//	public LoginTokenDto refreshToken(@RequestBody RefreshTokenParam employee) {
//		return authenticationService.refreshToken(employee);
//	}
	
	@PostMapping("/sign-in")
	public EmployeeDto SignIn(@RequestBody EmployeeParam employee) throws IOException {
		ModelMapper modelMapper = new ModelMapper();
		return modelMapper.map(empService.saveEmployee(employee), EmployeeDto.class);
	}
	
	
	
}
