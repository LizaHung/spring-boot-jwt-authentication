package com.pet.adoption.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.domain.Specification;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Query;

import com.pet.adoption.model.Employee;

public interface EmployeeRepository extends JpaRepository<Employee, Long>{

	Optional<Employee> findByEmpName(String empName);

	Optional<Employee> findByEmpNo(Long empNo);

	Optional<Employee> findByEmpAccount(String empAccount);

	List<Employee> findAll(Specification<Employee> spec);
}
