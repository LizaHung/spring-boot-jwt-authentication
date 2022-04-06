package com.pet.adoption.model;

import java.io.Serializable;

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
@Table(name = "petpic")
@NoArgsConstructor
public class PetPic implements Serializable{

	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "PETPIC_GENERATOR")
    @SequenceGenerator(name = "PETPIC_GENERATOR", sequenceName = "PETPIC_SEQ", allocationSize = 1)
	private String petPicNo;
	
	@ManyToOne(cascade=CascadeType.ALL)
	@JoinColumn(name="petNo")
	private Pet pet;
	
	private byte[] petPic;
}
