package com.pet.adoption.dto;

import java.time.LocalDate;

import lombok.Data;

@Data
public class LoginTokenDto {

	private String token;
	private String refreshToken;
}
