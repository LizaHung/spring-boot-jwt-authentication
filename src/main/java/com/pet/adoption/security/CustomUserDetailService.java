package com.pet.adoption.security;

import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.pet.adoption.exception.UserForbiddenException;
import com.pet.adoption.exception.UserNotFoundException;
import com.pet.adoption.model.Employee;
import com.pet.adoption.service.EmployeeService;

@Service
public class CustomUserDetailService implements UserDetailsService {

	@Autowired
	private EmployeeService employeeService;

	@Override
	public UserDetails loadUserByUsername(String empAccount) throws UsernameNotFoundException {
		Employee employee = employeeService.findByEmpAccount(empAccount)
				.orElseThrow(() -> new UserNotFoundException("Employee not found: " + empAccount));

		if (employee.getEmpAccStatus().toString() == "INVALID")
			throw new UserForbiddenException(employee.getEmpName() + " is forbidden");

		Set<GrantedAuthority> authorities = Set.of(new SimpleGrantedAuthority(employee.getEmpRole()));

		return UserPrincipal.builder().password(employee.getEmpPsw()).username(employee.getEmpName())
				.account(employee.getEmpAccount()).empNo(employee.getEmpNo()).authorities(authorities).build();
	}

}
