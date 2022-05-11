package com.pet.adoption.model;

import java.time.LocalDate;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor
public class Breeder {

	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "breederBER_GENERATOR")
    @SequenceGenerator(name = "breederBER_GENERATOR", sequenceName = "breeder_SEQ", allocationSize = 1)
	private Long breederNo;
	private String breederName;
	private String breederPhone;
	private String breederEmail;
}
