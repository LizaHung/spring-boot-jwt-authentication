package com.pet.adoption.service;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.pet.adoption.model.Employee;
import com.pet.adoption.repository.EmployeeRepository;

@Service
public class EmployeeServiceImpl implements EmployeeService {

	@Autowired
	private EmployeeRepository employeeRepository;
	
	@Autowired
	private PasswordEncoder passwordEncoder;

	@Override
	public List<Employee> findAllEmployee() {

		return employeeRepository.findAll();
	}

	@Override
	public Optional<Employee> findByEmpName(String empName) {
		return employeeRepository.findByEmpName(empName);
	}

	@Override
	public Optional<Employee> findByEmpNo(Long empNo) {
		return employeeRepository.findByEmpNo(empNo);
	}
	
	@Override
	public Optional<Employee> findByEmpAccount(String empAccount) {
		return employeeRepository.findByEmpAccount(empAccount);
	}

	@Override
	public Employee saveEmployee(Employee employee) {
		employee.setEmpPsw(passwordEncoder.encode(employee.getEmpPsw()));
		employee.setEmpArrDate(LocalDate.now());
		employee.setEmpAccStatus(0);
		return employeeRepository.save(employee);
	}

	

}
