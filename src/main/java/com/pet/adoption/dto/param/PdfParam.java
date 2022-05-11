package com.pet.adoption.dto.param;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;

import org.hibernate.validator.constraints.Length;
import org.springframework.web.multipart.MultipartFile;

import lombok.Data;

/**
 * 
 *
 *@author <a href="mailto:lizahung1008@gmail.com"> Liza Hung</a>
 */

@Data
public class PdfParam {

	@NotNull(message = "寵物編號必填")
	private Long adoPetNo;
	
	@NotBlank(message = "姓名必填")
	private String applicant;
	
	@NotBlank(message = "email必填")
	private String email;
	
	@NotBlank(message = "電話必填")
	@Length(min = 10, max = 10, message ="電話號碼只能為10位")
	@Pattern(regexp = "^[(0-9)]{10}$", message ="電話請輸入09開頭，且長度必須為10" )
	private String phone;
	
	private Long empNo;
	
	private MultipartFile idLeft;
	private MultipartFile idRight;
	private MultipartFile signature;
	
}
