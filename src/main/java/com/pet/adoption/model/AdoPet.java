package com.pet.adoption.model;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.Lob;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.pet.adoption.common.AdoStatusEnum;
import com.pet.adoption.common.LocationEnum;
import com.pet.adoption.common.PetCatEnum;
import com.pet.adoption.common.PetSexEnum;
import com.pet.adoption.common.PetTypeEnum;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Entity(name = "ado_pet")
@Table(name = "ado_pet")
@NoArgsConstructor
public class AdoPet implements Serializable {
	
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "ADOPET_GENERATOR")
    @SequenceGenerator(name = "ADOPET_GENERATOR", sequenceName = "ADOPET_SEQ", allocationSize = 1)
	private Long adoPetNo;
	
	@OneToOne(cascade = CascadeType.ALL)
	@JoinColumn(name="breederNo")
	private Breeder breeder;
	
	@OneToOne
	@JoinColumn(name="empNo")
	private Employee employee;
	
	@Enumerated(EnumType.ORDINAL)
	private AdoStatusEnum adoStatus;
	 
	@Enumerated(EnumType.ORDINAL)
	private PetTypeEnum petType;
	private String petName;
	private String petBreed;
	
	@Enumerated(EnumType.ORDINAL)
	private PetSexEnum petSex;
	private LocalDate petBirth;
	private Double petWeight;
	
	@Enumerated(EnumType.ORDINAL)
	private PetCatEnum petCat;
	private String petChar;
	@Enumerated(EnumType.ORDINAL)
	private LocationEnum location;
	
	@Lob
	private byte[] appForm;
	private LocalDate adoptionDate;
	private Integer age;

	@JsonIgnore
	@OneToMany(cascade = CascadeType.ALL, mappedBy = "adoPetNo")
	private List<AdoPetPic> adoPetPic;
	
	public void add(AdoPetPic pics) {
		System.out.println("add pics" );
		if (adoPetPic == null) {
			adoPetPic = new ArrayList<>();
		}

		adoPetPic.add(pics);
		pics.setAdoPetNo(this.adoPetNo);
	}
}
