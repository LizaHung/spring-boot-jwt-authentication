package com.pet.adoption.dto.param;

import java.time.LocalDate;
import java.util.List;

import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.web.multipart.MultipartFile;

import lombok.Data;

@Data
public class AdoPetParam {
	
	private Long adoPetNo;
	private Long memNo;
	private Long empNo;
	private Integer adoStatus;
	private String petType;
	private String petName;
	private String petBreed;
	private String petSex;
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	private LocalDate petBirth;
	private Double petWeight;
	private String petCat;
	private String petChar;
	private String location;
	private MultipartFile application;
	private Integer age;
	private MultipartFile[] photos;
	private List<Long> delImageList;
	
	
}
