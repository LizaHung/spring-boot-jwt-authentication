package com.pet.adoption.dto;

import java.time.LocalDate;

import lombok.Data;

@Data
public class LoginTokenDto {

	private String empName;
	private String empAccount;
	private String empRole;
	private String token;
	private Long empNo;
}
