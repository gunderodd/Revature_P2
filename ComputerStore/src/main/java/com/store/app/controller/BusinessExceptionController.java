package com.store.app.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.ExceptionHandler;

import com.store.app.exception.BusinessException;

@CrossOrigin(origins = "*")
@ControllerAdvice
public class BusinessExceptionController {
	
	@ExceptionHandler(value = BusinessException.class)
	public ResponseEntity<String> exception(BusinessException e) {
		return new ResponseEntity<String>(e.getMessage(), HttpStatus.BAD_REQUEST);
	}
}
