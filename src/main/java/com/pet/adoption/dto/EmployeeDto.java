package com.pet.adoption.dto;

import java.time.LocalDate;

import javax.persistence.Lob;
import javax.persistence.Transient;

import lombok.Data;

@Data
public class EmployeeDto {

	private Long empNo;
	private String empName;
	private String empAccount;
	private String empNickname;
	private String empAccStatus;
	private String empEmail;
	private String empRole;
	private LocalDate empArrDate;
}
