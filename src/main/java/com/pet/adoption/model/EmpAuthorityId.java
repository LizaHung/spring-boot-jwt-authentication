package com.pet.adoption.model;

import java.io.Serializable;

import javax.persistence.Embeddable;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;

import lombok.Data;

@Embeddable
@Data
public class EmpAuthorityId  implements Serializable {

	@OneToOne
	@JoinColumn(name = "empNo")
	private Employee empNo;
	
	@OneToOne
	@JoinColumn(name = "funNo")
	private BackFunction funNo;
}
