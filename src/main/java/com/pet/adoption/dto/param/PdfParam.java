package com.pet.adoption.dto.param;

import org.springframework.web.multipart.MultipartFile;

import lombok.Data;

/**
 * 
 *
 *@author <a href="mailto:lizahung1008@gmail.com"> Liza Hung</a>
 */

@Data
public class PdfParam {

	private Long adoPetNo;
	private Long memNo;
	private Long empNo;
	private Integer numberOfPets;
	private MultipartFile application;
	private MultipartFile idLeft;
	private MultipartFile idRight;
	private MultipartFile signature;
}
