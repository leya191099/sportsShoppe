package com.cp.sports.Controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import com.cp.sports.Exception.ProductServiceException;


@RestControllerAdvice
public class ProductControllerAdvice {

	@ExceptionHandler(ProductServiceException.class)
	public ResponseEntity<String> foundProductException(Exception exception){
		return new ResponseEntity<String>(exception.getMessage(),HttpStatus.NOT_FOUND);
	}
}
