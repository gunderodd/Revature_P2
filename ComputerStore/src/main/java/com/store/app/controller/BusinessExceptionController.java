package com.store.app.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.ExceptionHandler;

import com.store.app.exception.BusinessException;

@CrossOrigin(origins = "*")
@ControllerAdvice
public class BusinessExceptionController {
	Logger L = LoggerFactory.getLogger(BusinessExceptionController.class);
	
	@ExceptionHandler(value = BusinessException.class)
	public ResponseEntity<String> exception(BusinessException e) {
		L.warn(e.getMessage());
		return new ResponseEntity<String>(e.getMessage(), HttpStatus.BAD_REQUEST);
	}
}