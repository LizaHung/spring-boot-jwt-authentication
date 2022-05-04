package com.pet.adoption.service;

import java.io.IOException;
import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

import javax.transaction.Transactional;

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
	private EmpAuthorityService empAuthorityService;

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
		Employee savedEmp = employeeRepository.save(emp);
		empAuthorityService.saveFunByRole(savedEmp.getEmpNo(), savedEmp.getEmpRole());
		return savedEmp;
	}

	@Override
	@Transactional
	public Employee updateEmployee(EmployeeParam theEmployee) throws IOException {
		Employee tempEmp = modelMapperUtil.map(theEmployee, Employee.class);
		tempEmp.setEmpAccStatus(EmpAccStatusEnum.VALID);
		if (theEmployee.getEmpPhoto() != null)
			tempEmp.setEmpPhoto(theEmployee.getEmpPhoto().getBytes());
		if (StringUtils.isNoneBlank(theEmployee.getEmpPsw()))
			tempEmp.setEmpPsw(passwordEncoder.encode(theEmployee.getEmpPsw()));
		empAuthorityService.saveFunByRole(tempEmp.getEmpNo(), tempEmp.getEmpRole());
		return employeeRepository.save(tempEmp);
	}

	@Override
	public Employee updateEmployeeAccStatus(Long empNo) {
		Employee emp = employeeRepository.findByEmpNo(empNo).get();
		emp.setEmpAccStatus(EmpAccStatusEnum.INVALID);
		return employeeRepository.save(emp);
	}

}
