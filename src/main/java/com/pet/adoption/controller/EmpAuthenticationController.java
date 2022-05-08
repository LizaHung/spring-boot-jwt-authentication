package com.pet.adoption.controller;

import java.io.IOException;

import javax.mail.MessagingException;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.pet.adoption.dto.EmployeeDto;
import com.pet.adoption.dto.LoginTokenDto;
import com.pet.adoption.dto.param.EmployeeParam;
import com.pet.adoption.dto.param.ForgotPswParam;
import com.pet.adoption.dto.param.LoginParam;
import com.pet.adoption.dto.param.RefreshTokenParam;
import com.pet.adoption.repository.ChangePswParam;
import com.pet.adoption.security.AuthenticationService;
import com.pet.adoption.service.EmployeeService;
import com.pet.adoption.util.ModelMapperUtil;

@RestController
@RequestMapping("/empAuth")
public class EmpAuthenticationController {

	@Autowired
	private EmployeeService empService;

	@Autowired
	private AuthenticationService authenticationService;
	
	@Autowired
	private ModelMapperUtil modelMapperUtil;

	@PostMapping("/login")
	public LoginTokenDto login(@Valid @RequestBody LoginParam employee) {
		return authenticationService.loginAndReturnJWT(employee);
	}

	@PostMapping("/refreshToken")
	public LoginTokenDto refreshToken(@RequestBody RefreshTokenParam refreshTokenParam) {
		return authenticationService.refreshToken(refreshTokenParam);
	}

	@PostMapping("/sign-in")
	public EmployeeDto SignIn(@Valid @RequestBody EmployeeParam employee) throws IOException {
		return modelMapperUtil.map(empService.saveEmployee(employee), EmployeeDto.class);
	}

	@PostMapping("/forgot")
	public void forgetPsw(@Valid @RequestBody ForgotPswParam forgotPswParam) throws IOException, MessagingException {
		empService.validEmp(forgotPswParam);
	}

	@PostMapping("/change")
	public EmployeeDto ChangePsw(@RequestBody ChangePswParam changePswParam) throws IOException, MessagingException {
		return modelMapperUtil.map(empService.ChangePsw(changePswParam), EmployeeDto.class);
	}

}
