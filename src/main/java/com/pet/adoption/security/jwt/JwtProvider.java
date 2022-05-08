package com.pet.adoption.security.jwt;

import javax.servlet.http.HttpServletRequest;

import org.springframework.security.core.Authentication;

import com.pet.adoption.dto.LoginTokenDto;
import com.pet.adoption.security.UserPrincipal;

public interface JwtProvider {
	
	LoginTokenDto generateToken(UserPrincipal user);
	
	Authentication getAuthentication(String refreshToken);
	
	boolean isTokenValid(HttpServletRequest request);

}
