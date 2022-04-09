package com.pet.adoption.security.jwt;

import javax.servlet.http.HttpServletRequest;

import org.springframework.security.core.Authentication;

import com.pet.adoption.security.UserPrincipal;

public interface JwtProvider {
	
	String generateToken(UserPrincipal user);
	
	Authentication getAuthentication(HttpServletRequest request);
	
	boolean isTokenValid(HttpServletRequest request);
}
