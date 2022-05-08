package com.pet.adoption.exception;

import lombok.Data;

@Data
public class ExceptionDto {

	private int status;
	private String message;
	private long timeStamp;
	
}
