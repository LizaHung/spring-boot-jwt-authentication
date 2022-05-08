package com.pet.adoption.dto.param;

import javax.validation.constraints.NotBlank;

import lombok.Data;

/**
*
* @author <a href="mailto:lizahung1008@gmail.com"> Liza Hung</a>
*/

@Data
public class ForgotPswParam {
	@NotBlank(message = "email必填")
	private String email;
	
	@NotBlank(message = "帳號必填")
	private String account;

}
