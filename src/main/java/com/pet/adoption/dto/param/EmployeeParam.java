package com.pet.adoption.dto.param;

import java.time.LocalDate;

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
	private String empName;
	private String empAccount;
	private String empNickname;
	private String empAccStatus;
	private String empEmail;
	private String empPsw;

	private MultipartFile empPhoto;
	private String empRole;
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	private LocalDate empArrDate;
}
