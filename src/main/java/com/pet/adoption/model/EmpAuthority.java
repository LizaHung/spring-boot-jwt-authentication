package com.pet.adoption.model;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.IdClass;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@Table(name = "empAuthority")
@NoArgsConstructor
@AllArgsConstructor
@IdClass(EmpAuthority.class)
public class EmpAuthority implements Serializable{
	
	@Id
	private Long empNo;
	
	@Id
	private Long funNo;

}


