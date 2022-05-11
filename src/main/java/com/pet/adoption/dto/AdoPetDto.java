package com.pet.adoption.dto;

import java.time.LocalDate;
import java.util.List;

import com.pet.adoption.model.AdoPetPic;
import com.pet.adoption.model.Breeder;

import lombok.Data;

@Data
public class AdoPetDto {

	private EmployeeDto employee;
	private Long adoPetNo;
	private Breeder breeder;
	private String adoStatus;
	private String petType;
	private String petName;
	private String petBreed;
	private String petSex;
	private LocalDate petBirth;
	private Double petWeight;
	private String petCat;
	private String petChar;
	private String location;
	private LocalDate adoptionDate;
	private Double age;
	private List<AdoPetPic> adoPetPic;
}
