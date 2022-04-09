package com.pet.adoption.security.jwt;

import java.nio.charset.StandardCharsets;
import java.security.Key;
import java.util.Arrays;
import java.util.Date;
import java.util.Set;
import java.util.stream.Collectors;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Component;
import org.springframework.util.StringUtils;

import com.pet.adoption.security.UserPrincipal;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import io.jsonwebtoken.security.Keys;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@Component
public class JwtProviderImpl implements JwtProvider {

	@Value("${jwt.secret}")
	private String JWT_SECRET;

	@Value("${jwt.expiration-in.ms}")
	private Long JWT_EXPIRATION_TIME;

	@Override
	public String generateToken(UserPrincipal user) {

		Key jwtKey = Keys.hmacShaKeyFor(JWT_SECRET.getBytes());

		String role = user.getAuthorities().stream().map(GrantedAuthority::getAuthority)
				.collect(Collectors.joining(","));

		System.out.println("role----" + role);
		log.info("role----{}", role);

		return Jwts.builder()
				.setSubject(user.getUsername())
				.claim("role", role)
				.claim("account", user.getAccount())
				.setExpiration(new Date(System.currentTimeMillis() + JWT_EXPIRATION_TIME))
				.signWith(jwtKey, SignatureAlgorithm.HS512).compact();
	}

	@Override
	public Authentication getAuthentication(HttpServletRequest request) {
		Claims claims = extractClaim(request);
		
		if(claims == null) return null;
		
		String username = claims.getSubject();
		
		if(username == null) return null;
		
		String account = claims.get("account").toString();
		
		Set<GrantedAuthority> authorities = Arrays.stream(claims.get("role").toString().split(","))
											  .map(SimpleGrantedAuthority::new)
											  .collect(Collectors.toSet());
		
		UserDetails userdetail = UserPrincipal.builder()
										  .account(account)
										  .username(username)
										  .authorities(authorities)
										  .build();
		
		return new UsernamePasswordAuthenticationToken(userdetail, null, authorities);
		
	}

	@Override
	public boolean isTokenValid(HttpServletRequest request) {
		
		Claims claims  = extractClaim(request);
		
		if(claims == null || claims.getExpiration().before(new Date())) return false;
		
		return true;
	}

	private Claims extractClaim(HttpServletRequest request) {

		String token = request.getHeader("authorization");


		if (StringUtils.hasLength(token) && token.startsWith("Bearer")) {
			log.info("token----{}",  token.substring(7));
			
			Key jwtKey = Keys.hmacShaKeyFor(JWT_SECRET.getBytes(StandardCharsets.UTF_8));

			return Jwts.parserBuilder()
					.setSigningKey(jwtKey)
					.build()
					.parseClaimsJws(token.substring(7))
					.getBody();
		}

		return null;

	}

}
