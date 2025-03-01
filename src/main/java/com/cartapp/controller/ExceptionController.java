package com.cartapp.controller;

import java.time.LocalDateTime;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.method.annotation.MethodArgumentTypeMismatchException;

import com.cartapp.exception.ResourceBadRequest;
import com.cartapp.exception.ResourceNotFound;
import com.cartapp.model.Error;

@ControllerAdvice
public class ExceptionController {
	
	private static final Logger logger = LoggerFactory.getLogger(Error.class);
	
	@ExceptionHandler(exception = ResourceNotFound.class)
	public ResponseEntity<Error> NotFoundException(ResourceNotFound ex) {
		logger.error(ex.getLocalizedMessage());
		Error errorResponse = new Error(ex.getMessage(), "Resource not found", HttpStatus.NOT_FOUND.value(), LocalDateTime.now());
		return new ResponseEntity<Error>(errorResponse, HttpStatus.NOT_FOUND);
	}
	
	@ExceptionHandler(exception = ResourceBadRequest.class)
	public ResponseEntity<Error> BadRequestException(ResourceBadRequest ex) {
		logger.error(ex.getLocalizedMessage());
		Error errorResponse = new Error(ex.getMessage(), "Bad request", HttpStatus.BAD_REQUEST.value(), LocalDateTime.now());
		return new ResponseEntity<Error>(errorResponse, HttpStatus.BAD_REQUEST);
	}
	
	@ExceptionHandler(exception = MethodArgumentTypeMismatchException.class)
	public ResponseEntity<Error> ResorceTypeMismatch(MethodArgumentTypeMismatchException ex) {
		logger.error(ex.getLocalizedMessage());
		Error errorResponse = new Error(ex.getLocalizedMessage(),  "Argument type mismatch", HttpStatus.BAD_REQUEST.value(), LocalDateTime.now());
		return new ResponseEntity<Error>(errorResponse, HttpStatus.BAD_REQUEST);
	}
}
