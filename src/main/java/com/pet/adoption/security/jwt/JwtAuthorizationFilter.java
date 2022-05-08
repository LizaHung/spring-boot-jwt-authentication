package com.pet.adoption.security.jwt;

import java.io.IOException;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.filter.OncePerRequestFilter;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.pet.adoption.exception.ExceptionDto;
import com.pet.adoption.exception.UserForbiddenException;

import io.jsonwebtoken.ExpiredJwtException;

public class JwtAuthorizationFilter extends OncePerRequestFilter {

	@Autowired
	private JwtProvider jwtProvider;

	@Override
	protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain)
			throws ServletException, IOException {

		Authentication authentication;
		try {
			String token = request.getHeader("authorization");
			authentication = jwtProvider.getAuthentication(token);
			if (authentication != null && jwtProvider.isTokenValid(request))
				SecurityContextHolder.getContext().setAuthentication(authentication);
			
			filterChain.doFilter(request, response);
		} catch (ExpiredJwtException e) {
			ExceptionDto error = new ExceptionDto();
			error.setStatus(1403);
			error.setMessage("token expired fff");
			error.setTimeStamp(System.currentTimeMillis());
			
			String errorMsg = new ObjectMapper().writeValueAsString(error);
			response.setStatus(403);
			response.getWriter().write(errorMsg);
			response.getWriter().flush();
		}

		
	}

}
