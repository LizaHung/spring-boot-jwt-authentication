package com.pet.adoption.model;

import java.io.Serializable;
import java.time.LocalDate;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@Table(name = "pet")
@NoArgsConstructor
public class Pet implements Serializable{
	
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "PET_GENERATOR")
    @SequenceGenerator(name = "PET_GENERATOR", sequenceName = "PET_SEQ", allocationSize = 1)
	private String petNo;
	
	@ManyToOne(cascade=CascadeType.ALL)
	@JoinColumn(name="memNo")
	private Member member;
	
	private String petName;
	private Integer petType;
	private Integer petCat;
	private Integer petSex;
	private LocalDate petBirth;
	private String petChar;
	private byte[] petPhoto;
	private Integer isDel;

}
