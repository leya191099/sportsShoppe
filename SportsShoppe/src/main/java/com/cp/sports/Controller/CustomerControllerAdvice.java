package com.cp.sports.Controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import com.cp.sports.Exception.CustomerServiceException;


@RestControllerAdvice
public class CustomerControllerAdvice {

	@ExceptionHandler(CustomerServiceException.class)
	public ResponseEntity<String> foundPaymentException(Exception exception){
		return new ResponseEntity<String>(exception.getMessage(),HttpStatus.NOT_FOUND);
	}
}
