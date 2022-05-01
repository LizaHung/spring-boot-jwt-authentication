package com.pet.adoption.model;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.Lob;
import javax.persistence.OneToOne;
import javax.persistence.SequenceGenerator;

import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.Data;

@Data
@Entity
public class AdoPetPic implements Serializable{
	
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "ADOPETPIC_GENERATOR")
    @SequenceGenerator(name = "ADOPETPIC_GENERATOR", sequenceName = "ADOPETPIC_SEQ", allocationSize = 1)
	private Long adoPicNo;
	
//	@OneToOne
//	@JoinColumn(name="adoPetNo")
//	private AdoPet adoPet;
	
	private Long adoPetNo;
	
	@Lob
	@JsonIgnore
	private byte[] adoPetPic;
}
