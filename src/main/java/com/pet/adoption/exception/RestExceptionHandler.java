package com.pet.adoption.exception;

import org.springframework.core.annotation.Order;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.validation.BindException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.multipart.MaxUploadSizeExceededException;

import io.jsonwebtoken.ExpiredJwtException;

@Order(0)
@ControllerAdvice
public class RestExceptionHandler {

	@ExceptionHandler(BindException.class)
	public ResponseEntity<ExceptionDto> handleException(BindException exception) {
		StringBuilder errorMsg = new StringBuilder();
		exception.getBindingResult().getAllErrors().forEach((error) -> {
			errorMsg.append(error.getDefaultMessage() + " ");
		});
		ExceptionDto error = new ExceptionDto();
		error.setStatus(HttpStatus.BAD_REQUEST.value());
		error.setMessage(errorMsg.toString());
		error.setTimeStamp(System.currentTimeMillis());
		return new ResponseEntity<>(error, HttpStatus.BAD_REQUEST);
	}

	@ExceptionHandler({ UserNotFoundException.class, BadCredentialsException.class })
	public ResponseEntity<ExceptionDto> handleException(Exception exception) {
		ExceptionDto error = new ExceptionDto();
		error.setStatus(HttpStatus.UNAUTHORIZED.value());
		String errorMsg = exception.getMessage().equals("Bad credentials") ? "帳號或密碼有誤，請重新數入" : exception.getMessage();
		error.setMessage(errorMsg);
		error.setTimeStamp(System.currentTimeMillis());
		return new ResponseEntity<>(error, HttpStatus.UNAUTHORIZED);
	}
	

	@ExceptionHandler(ExpiredJwtException.class) //refresh token expire
	public ResponseEntity<ExceptionDto> handleException(ExpiredJwtException exception) {
		ExceptionDto error = new ExceptionDto();
		error.setStatus(HttpStatus.UNAUTHORIZED.value());
		error.setTimeStamp(System.currentTimeMillis());
		return new ResponseEntity<>(error, HttpStatus.UNAUTHORIZED);
	}

	@ExceptionHandler(UserForbiddenException.class)
	public ResponseEntity<ExceptionDto> handleException(UserForbiddenException exception) {
		ExceptionDto error = new ExceptionDto();
		error.setStatus(HttpStatus.FORBIDDEN.value());
		error.setMessage(exception.getMessage());
		error.setTimeStamp(System.currentTimeMillis());
		return new ResponseEntity<>(error, HttpStatus.FORBIDDEN);
	}

	@ExceptionHandler(MaxUploadSizeExceededException.class)
	public ResponseEntity<ExceptionDto> handleException(MaxUploadSizeExceededException exception) {
		ExceptionDto error = new ExceptionDto();
		error.setStatus(HttpStatus.INTERNAL_SERVER_ERROR.value());
		error.setMessage("上傳文件大小超出限制");
		error.setTimeStamp(System.currentTimeMillis());
		return new ResponseEntity<>(error, HttpStatus.INTERNAL_SERVER_ERROR);
	}

}
