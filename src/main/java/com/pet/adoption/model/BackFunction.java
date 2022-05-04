package com.pet.adoption.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Table(name = "backfunction")
@Entity
@NoArgsConstructor
public class BackFunction {

	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "BACKFUNCTION_GENERATOR")
    @SequenceGenerator(name = "BACKFUNCTION_GENERATOR", sequenceName = "BACKFUNCTION_SEQ", allocationSize = 1)
	private Long funNo;
	private String funName;
	private String funUrl;
}
