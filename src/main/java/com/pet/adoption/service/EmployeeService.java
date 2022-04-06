package com.pet.adoption.service;

import java.util.List;
import java.util.Optional;

import com.pet.adoption.model.Employee;

public interface EmployeeService {
	
	List<Employee> findAllEmployee();
	
	Optional<Employee> findByEmpName(String empName);
	
	Optional<Employee> findByEmpNo(String empNo);
	
	Optional<Employee> findByEmpAccount(String empAccount);
	
	Employee saveEmployee(Employee employee);
}
