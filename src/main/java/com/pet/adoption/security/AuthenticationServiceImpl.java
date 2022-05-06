package com.pet.adoption.security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Service;

import com.pet.adoption.dto.LoginTokenDto;
import com.pet.adoption.dto.param.LoginParam;
import com.pet.adoption.security.jwt.JwtProvider;

@Service
public class AuthenticationServiceImpl implements AuthenticationService {

	@Autowired
	private JwtProvider jwtProvider;

	@Autowired
	private AuthenticationManager authenticationManager;


	@Override
	public LoginTokenDto loginAndReturnJWT(LoginParam employee) {

		LoginTokenDto loginTokenDto = new LoginTokenDto();
		Authentication authentication = authenticationManager
				.authenticate(new UsernamePasswordAuthenticationToken(employee.getEmpAccount(), employee.getEmpPsw()));
		UserPrincipal emp = (UserPrincipal) authentication.getPrincipal();

		String token = jwtProvider.generateToken(emp);
		loginTokenDto.setToken(token);

		return loginTokenDto;
	}

	

}
