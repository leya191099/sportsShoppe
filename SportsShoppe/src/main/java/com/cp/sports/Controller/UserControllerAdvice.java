package com.cp.sports.Controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import com.cp.sports.Exception.UserException;


@RestControllerAdvice
public class UserControllerAdvice {

	@ExceptionHandler(UserException.class)
	public ResponseEntity<String> foundUserException(Exception exception){
		return new ResponseEntity<String>(exception.getMessage(),HttpStatus.NOT_FOUND);
	}
}

