package com.pet.adoption.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.pet.adoption.model.Employee;
import com.pet.adoption.service.EmployeeService;

@RestController
@RequestMapping("/api")
public class EmployeeController {

	@Autowired
	private EmployeeService empService;

	@PostMapping("/employees")
	public Employee addEmployee(@RequestBody Employee theEmployee) {
		return empService.saveEmployee(theEmployee);
	}

	@PutMapping("/employees")
	public Employee updateEmployee(@RequestBody Employee theEmployee) {
		return empService.saveEmployee(theEmployee);
	}

	@GetMapping("/employees/{empName}")
	public Employee getEmployee(@PathVariable String empName) {
		if (empService.findByEmpName(empName).isEmpty()) {
			throw new RuntimeException("Employee Number not found- " + empName);
		}
		return empService.findByEmpName(empName).get();
	}

	@GetMapping("/employees")
	public List<Employee> getAllEmployee() {
		return empService.findAllEmployee();
	}

}
