package com.pet.adoption.dto.param;

import java.time.LocalDate;
import java.util.List;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Past;

import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.web.multipart.MultipartFile;

import lombok.Data;

@Data
public class AdoPetParam {

	private Long adoPetNo;
	private Long memNo;
	private Long empNo;
	private Integer adoStatus;

	@NotBlank(message = "類別必填")
	private String petType;

	@NotBlank(message = "名稱必填")
	private String petName;

	@NotBlank(message = "品種必填")
	private String petBreed;

	@NotBlank(message = "性別必填")
	private String petSex;

	@Past(message = "日期有誤")
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	private LocalDate petBirth;

	@NotNull(message = "體重必填")
	private Double petWeight;

	@NotBlank(message = "分類必填")
	private String petCat;
	private String petChar;
	private String location;
	private MultipartFile application;
	private MultipartFile[] photos;
	private List<Long> delImageList;

}
