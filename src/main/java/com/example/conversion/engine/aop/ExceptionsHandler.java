package com.example.conversion.engine.aop;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import com.example.conversion.engine.exception.GoneException;

@ControllerAdvice
public class ExceptionsHandler {
	
	@ExceptionHandler(GoneException.class)
	public ResponseEntity<?> handleGoneException(GoneException exception){
		return new ResponseEntity<>(exception.getMessage(), HttpStatus.GONE);
	}
}
