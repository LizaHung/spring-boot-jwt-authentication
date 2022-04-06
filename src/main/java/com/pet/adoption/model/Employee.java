package com.pet.adoption.model;

import java.io.Serializable;
import java.time.LocalDate;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.persistence.Transient;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Table(name = "employee")
@Entity
@NoArgsConstructor
public class Employee implements Serializable{

	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "EMPLOYEE_GENERATOR")
    @SequenceGenerator(name = "EMPLOYEE_GENERATOR", sequenceName = "EMPLOYEE_SEQ", allocationSize = 1)
	private String empNo;
	private String empName;
	private String empAccount;
	private String empPsw;
	private String empNickname;
	private Integer empAccStatus;
	private String empEmail;
	private byte[] empPhoto;
	private String empRole;
	private LocalDate empArrDate;

	@Transient
	private String token;

}
