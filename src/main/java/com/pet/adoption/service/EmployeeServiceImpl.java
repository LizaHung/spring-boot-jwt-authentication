package com.pet.adoption.service;

import java.io.IOException;
import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.pet.adoption.common.EmpAccStatusEnum;
import com.pet.adoption.dto.param.EmployeeParam;
import com.pet.adoption.model.Employee;
import com.pet.adoption.repository.EmployeeRepository;
import com.pet.adoption.util.ModelMapperUtil;

@Service
public class EmployeeServiceImpl implements EmployeeService {

	@Autowired
	private EmployeeRepository employeeRepository;

	@Autowired
	private PasswordEncoder passwordEncoder;

	@Autowired
	private ModelMapperUtil modelMapperUtil;

	@Override
	public List<Employee> findAllEmployee() {

		return employeeRepository.findAll();
	}

	@Override
	public List<Employee> searchEmployee(Specification<Employee> spec) {
		return employeeRepository.findAll(spec);
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
	public Employee saveEmployee(EmployeeParam theEmployee) throws IOException {
		theEmployee.setEmpPsw(passwordEncoder.encode(theEmployee.getEmpPsw()));
		theEmployee.setEmpAccStatus(EmpAccStatusEnum.VALID.toString());
		Employee emp = modelMapperUtil.map(theEmployee, Employee.class);
		if (theEmployee.getEmpPhoto() != null)
			emp.setEmpPhoto(theEmployee.getEmpPhoto().getBytes());
		return employeeRepository.save(emp);
	}

	@Override
	public Employee updateEmployee(EmployeeParam theEmployee) throws IOException {
		Employee emp = employeeRepository.findByEmpNo(theEmployee.getEmpNo()).get();
		if (theEmployee.getEmpPhoto() != null)
			emp.setEmpPhoto(theEmployee.getEmpPhoto().getBytes());
		if (StringUtils.isNoneBlank(theEmployee.getEmpPsw()))
			emp.setEmpPsw(passwordEncoder.encode(theEmployee.getEmpPsw()));
		return employeeRepository.save(emp);
	}

	@Override
	public Employee updateEmployeeAccStatus(Long empNo) {
		Employee emp = employeeRepository.findByEmpNo(empNo).get();
		emp.setEmpAccStatus(EmpAccStatusEnum.INVALID);
		return employeeRepository.save(emp);
	}

}
