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

import com.pet.adoption.dto.LoginTokenDto;
import com.pet.adoption.security.UserPrincipal;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import io.jsonwebtoken.security.Keys;

@Component
public class JwtProviderImpl implements JwtProvider {

	@Value("${jwt.secret}")
	private String JWT_SECRET;

	@Value("${jwt.expiration-in.ms}")
	private Long JWT_EXPIRATION_TIME;

	@Value("${jwt.refreshtoken.expiration-in.ms}")
	private Long JWT_REFRESH_EXPIRATION_TIME;

	@Override
	public LoginTokenDto generateToken(UserPrincipal user) {

		Key jwtKey = Keys.hmacShaKeyFor(JWT_SECRET.getBytes());

		String role = user.getAuthorities().stream().map(GrantedAuthority::getAuthority)
				.collect(Collectors.joining(","));

		LoginTokenDto loginTokenDto = new LoginTokenDto();
		loginTokenDto.setToken(Jwts.builder().setSubject(user.getUsername()).claim("role", role)
				.claim("account", user.getAccount()).claim("empNo", user.getEmpNo())
				.setExpiration(new Date(System.currentTimeMillis() + JWT_EXPIRATION_TIME))
				.signWith(jwtKey, SignatureAlgorithm.HS512).compact());
		loginTokenDto.setRefreshToken(Jwts.builder().setSubject(user.getUsername()).claim("role", role)
				.claim("account", user.getAccount()).claim("empNo", user.getEmpNo())
				.setExpiration(new Date(System.currentTimeMillis() + JWT_REFRESH_EXPIRATION_TIME))
				.signWith(jwtKey, SignatureAlgorithm.HS512).compact());

		return loginTokenDto;
	}

	@Override
	public Authentication getAuthentication(String token) {
		Claims claims = extractClaim(token);

		if (claims == null)
			return null;

		String username = claims.getSubject();

		if (username == null)
			return null;

		String account = claims.get("account").toString();
		Long empNo = Long.valueOf(claims.get("empNo").toString());

		Set<GrantedAuthority> authorities = Arrays.stream(claims.get("role").toString().split(","))
				.map(SimpleGrantedAuthority::new).collect(Collectors.toSet());

		UserDetails userdetail = UserPrincipal.builder().account(account).username(username).empNo(empNo)
				.authorities(authorities).build();

		return new UsernamePasswordAuthenticationToken(userdetail, null, authorities);

	}

	@Override
	public boolean isTokenValid(HttpServletRequest request) {

		String token = request.getHeader("authorization");

		Claims claims = extractClaim(token);

		if (claims == null || claims.getExpiration().before(new Date()))
			return false;

		return true;
	}

	private Claims extractClaim(String token) {

		if (StringUtils.hasLength(token)) {

			if (token.startsWith("Bearer"))
				token = token.substring(7);

			Key jwtKey = Keys.hmacShaKeyFor(JWT_SECRET.getBytes(StandardCharsets.UTF_8));

			return Jwts.parserBuilder().setSigningKey(jwtKey).build().parseClaimsJws(token).getBody();
		}

		return null;

	}

}
