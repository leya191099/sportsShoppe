package com.cp.sports.Controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import com.cp.sports.Exception.CoupanServiceException;

@RestControllerAdvice
public class CoupanControllerAdvice {

	@ExceptionHandler(CoupanServiceException.class)
	public ResponseEntity<String> foundCoupanException(Exception exception){
		return new ResponseEntity<String>(exception.getMessage(),HttpStatus.NOT_FOUND);
	}
}
