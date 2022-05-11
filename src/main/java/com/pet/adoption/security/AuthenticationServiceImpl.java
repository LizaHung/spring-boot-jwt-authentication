package com.pet.adoption.security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Service;

import com.pet.adoption.dto.LoginTokenDto;
import com.pet.adoption.dto.param.LoginParam;
import com.pet.adoption.dto.param.RefreshTokenParam;
import com.pet.adoption.security.jwt.JwtProvider;

import io.jsonwebtoken.ExpiredJwtException;

@Service
public class AuthenticationServiceImpl implements AuthenticationService {

	@Autowired
	private JwtProvider jwtProvider;

	@Autowired
	private AuthenticationManager authenticationManager;

	@Override
	public LoginTokenDto loginAndReturnJWT(LoginParam employee) {
		Authentication authentication = authenticationManager
				.authenticate(new UsernamePasswordAuthenticationToken(employee.getEmpAccount(), employee.getEmpPsw()));
		UserPrincipal emp = (UserPrincipal) authentication.getPrincipal();
		return jwtProvider.generateToken(emp);
	}

	@Override
	public LoginTokenDto refreshToken(RefreshTokenParam refreshTokenParam) throws ExpiredJwtException {
		Authentication authentication = jwtProvider.getAuthentication(refreshTokenParam.getRefreshToken());
		UserPrincipal emp = (UserPrincipal) authentication.getPrincipal();
		return jwtProvider.generateToken(emp);
	}

}
