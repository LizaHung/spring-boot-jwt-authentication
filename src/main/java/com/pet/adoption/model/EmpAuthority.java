package com.pet.adoption.model;

import java.io.Serializable;

import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@Table(name = "empAuthority")
@NoArgsConstructor
public class EmpAuthority implements Serializable{
	
	@EmbeddedId
	private EmpAuthorityId id;

}


