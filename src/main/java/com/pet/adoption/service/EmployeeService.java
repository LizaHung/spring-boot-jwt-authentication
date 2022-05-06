package com.pet.adoption.service;

import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.util.List;
import java.util.Optional;

import javax.mail.MessagingException;

import org.springframework.data.jpa.domain.Specification;
import org.springframework.web.bind.annotation.PathVariable;

import com.pet.adoption.dto.EmployeeDto;
import com.pet.adoption.dto.param.EmployeeParam;
import com.pet.adoption.dto.param.ForgotPswParam;
import com.pet.adoption.model.Employee;
import com.pet.adoption.repository.ChangePswParam;

public interface EmployeeService {
	
	List<Employee> findAllEmployee();
	
	Optional<Employee> findByEmpName(String empName);
	
	Optional<Employee> findByEmpNo(Long empNo);
	
	Optional<Employee> findByEmpAccount(String empAccount);
	
	Employee saveEmployee(EmployeeParam employee) throws IOException;
	
	Employee updateEmployee(EmployeeParam employee) throws IOException;
	
	Employee updateEmployeeAccStatus(Long empNo);

	List<Employee> searchEmployee(Specification<Employee> spec);
	
	void validEmp(ForgotPswParam forgotPswParam) throws MessagingException, UnsupportedEncodingException;

	Employee ChangePsw(ChangePswParam forgotPswParam);
}
