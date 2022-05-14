package com.pet.adoption.controller;

import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.util.List;

import javax.servlet.ServletOutputStream;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.http.HttpServletResponse;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.io.ResourceLoader;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.pet.adoption.dto.EmployeeDto;
import com.pet.adoption.dto.param.EmployeeParam;
import com.pet.adoption.exception.UserNotFoundException;
import com.pet.adoption.model.Employee;
import com.pet.adoption.service.EmployeeService;
import com.pet.adoption.specification.EmployeeSpecification;
import com.pet.adoption.util.ModelMapperUtil;

@RestController
@RequestMapping("/employees")
@MultipartConfig(fileSizeThreshold = 1024 * 1024, maxFileSize = 5 * 1024 * 1024, maxRequestSize = 5 * 5 * 1024 * 1024)
public class EmployeeController {

	@Autowired
	private EmployeeService empService;

	@Autowired
	private ModelMapperUtil modelMapperUtil;
	

	@PostMapping
	public EmployeeDto addEmployee(@Valid EmployeeParam theEmployee) throws IOException {
		return modelMapperUtil.map(empService.saveEmployee(theEmployee), EmployeeDto.class);
	}

	@GetMapping("/searchEmp")
	public List<EmployeeDto> searchEmployee(EmployeeParam theEmployee) {
		Specification<Employee> spec = EmployeeSpecification.searchEmp(theEmployee);
		List<Employee> employees = empService.searchEmployee(spec);
		return modelMapperUtil.mapList(employees, EmployeeDto.class);
	}

	@PutMapping
	public EmployeeDto updateEmployee(@Valid EmployeeParam theEmployee) throws IOException {
		return modelMapperUtil.map(empService.updateEmployee(theEmployee), EmployeeDto.class);
	}
	@PatchMapping("{empNo}")
	public EmployeeDto updateEmployeeAccStatus(@PathVariable Long empNo) {
		return modelMapperUtil.map(empService.updateEmployeeAccStatus(empNo), EmployeeDto.class);
	}

	@GetMapping("/{empNo}")
	public EmployeeDto getEmployee(@PathVariable Long empNo) {
		return modelMapperUtil.map(empService.findByEmpNo(empNo), EmployeeDto.class);
	}

	@GetMapping
	public List<EmployeeDto> getAllEmployee() {
		return modelMapperUtil.mapList(empService.findAllEmployee(), EmployeeDto.class);
	}

	@GetMapping("/show/{empNo}")
	public void getEmpPhoto(HttpServletResponse res, @PathVariable("empNo") Long empNo) throws IOException {
		empService.getEmptPhoto(res, empNo);
	}

}
