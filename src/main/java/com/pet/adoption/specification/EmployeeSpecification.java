package com.pet.adoption.specification;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.criteria.Predicate;

import org.apache.commons.lang3.StringUtils;
import org.springframework.data.jpa.domain.Specification;

import com.pet.adoption.common.EmpAccStatusEnum;
import com.pet.adoption.dto.param.EmployeeParam;
import com.pet.adoption.model.Employee;

public class EmployeeSpecification {

	public static Specification<Employee> searchEmp(EmployeeParam theEmployee) {

		return (root, query, builder) -> {
			final List<Predicate> predicatesList = new ArrayList<>();

			if (theEmployee.getEmpNo() != null) {
				predicatesList.add(builder.equal(root.get("empNo"), theEmployee.getEmpNo()));
			}

			if (StringUtils.isNoneBlank(theEmployee.getEmpName())) {
				predicatesList.add(builder.like(root.get("empName"), "%" + theEmployee.getEmpName() + "%"));
			}

			if (StringUtils.isNoneBlank(theEmployee.getEmpAccount())) {
				predicatesList.add(builder.equal(root.get("empAccount"), theEmployee.getEmpAccount()));
			}

			if (StringUtils.isNoneBlank(theEmployee.getEmpNickname())) {
				predicatesList.add(builder.like(root.get("empNickname"), "%" + theEmployee.getEmpNickname() + "%"));
			}

			if (StringUtils.isNoneBlank(theEmployee.getEmpAccStatus())) {
				predicatesList.add(builder.equal(root.get("empAccStatus"),
						EmpAccStatusEnum.valueOf(theEmployee.getEmpAccStatus())));
			}

			if (StringUtils.isNoneBlank(theEmployee.getEmpEmail())) {
				predicatesList.add(builder.like(root.get("empEmail"), "%" + theEmployee.getEmpEmail() + "%"));
			}

			if (theEmployee.getEmpRole() != null) {
				predicatesList.add(builder.equal(root.get("empRole"), theEmployee.getEmpRole()));
			}

			if (theEmployee.getEmpArrDate() != null) {
				predicatesList.add(builder.equal(root.get("empArrDate"), theEmployee.getEmpArrDate()));
			}

			return builder.and(predicatesList.toArray(new Predicate[predicatesList.size()]));
		};

	}
}
