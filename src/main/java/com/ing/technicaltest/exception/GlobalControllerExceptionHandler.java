package com.ing.technicaltest.exception;

import javax.persistence.EntityNotFoundException;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

@ControllerAdvice
public class GlobalControllerExceptionHandler extends ResponseEntityExceptionHandler {

	@SuppressWarnings("rawtypes")
	@ExceptionHandler(EntityNotFoundException.class)
	public ResponseEntity handleEntityNotFoundException(EntityNotFoundException ex, WebRequest request) {
		return new ResponseEntity(HttpStatus.NOT_FOUND);
	}

	@SuppressWarnings("rawtypes")
	@ExceptionHandler(UserNotFoundException.class)
	public ResponseEntity handleUserNotFoundException(UserNotFoundException ex, WebRequest request) {
		return new ResponseEntity(HttpStatus.NOT_FOUND);
	}
}
