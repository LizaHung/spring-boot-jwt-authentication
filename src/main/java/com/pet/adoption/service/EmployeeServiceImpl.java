package com.pet.adoption.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.pet.adoption.model.Employee;
import com.pet.adoption.repository.EmployeeRepository;

@Service
public class EmployeeServiceImpl implements EmployeeService {

	@Autowired
	private EmployeeRepository employeeRepository;

	@Override
	public List<Employee> findAllEmployee() {

		return employeeRepository.findAll();
	}

	@Override
	public Optional<Employee> findByEmpName(String empName) {
		return employeeRepository.findByEmpName(empName);
	}

	@Override
	public Optional<Employee> findByEmpNo(String empNo) {
		return employeeRepository.findByEmpNo(empNo);
	}
	
	@Override
	public Optional<Employee> findByEmpAccount(String empAccount) {
		return employeeRepository.findByEmpAccount(empAccount);
	}

	@Override
	public Employee saveEmployee(Employee employee) {
		return employeeRepository.save(employee);
	}

	

}
