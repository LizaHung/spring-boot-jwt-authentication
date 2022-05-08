package com.pet.adoption.dto.param;

import java.time.LocalDate;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;

import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.web.multipart.MultipartFile;

import lombok.Data;

/**
 * @author <a href="mailto:lizahung1008@gmail.com"> Liza Hung</a>
 *
 */
@Data
public class EmployeeParam {
	
	private Long empNo;
	
	@NotBlank(message = "名稱必填")
	private String empName;
	
	@NotBlank(message = "帳號必填")
	private String empAccount;
	private String empNickname;
	private String empAccStatus;
	
	@Email
	@NotBlank(message = "email必填")
	private String empEmail;
	
	private String empPsw;

	private MultipartFile empPhoto;
	
	@NotBlank(message = "角色必填")
	private String empRole;
	
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	private LocalDate empArrDate;
}
