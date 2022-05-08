package com.pet.adoption.dto.param;

import javax.validation.constraints.NotBlank;

import lombok.Data;

@Data
public class LoginParam {
	
	@NotBlank(message = "帳號必填")
	private String empAccount;
	
	@NotBlank(message = "密碼必填")
	private String empPsw;
}
