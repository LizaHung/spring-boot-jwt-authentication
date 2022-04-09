package com.pet.adoption.model;

import java.io.Serializable;
import java.sql.Date;
import java.time.LocalDate;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@Table(name = "member")
@NoArgsConstructor
public class Member implements Serializable {
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "MEMBER_GENERATOR")
    @SequenceGenerator(name = "MEMBER_GENERATOR", sequenceName = "MEM_SEQ", allocationSize = 1)
	private Long memNo;
	private String memName;
	private LocalDate memBirth;
	private Integer memSex;
	private String memPhone;
	private String memEmail;
	private String memAddress;
	private String memLngLat;
	private String memId;
	private String memPsw;
	private Integer memPoint;
	private Integer memAuthority;
	private Integer memStatus;
	private String memNickname;
	private byte[] memPhoto;
}
