package com.cp.sports.Controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import com.cp.sports.Exception.UserException;


@RestControllerAdvice

/******
 * @author Tejaswini.T
 * Description It is a ControllerAdvice which allows to handle UserServiceException across the whole application
 * Version 1.0 
 * Created Date 22-March-2021
 ******/
public class UserControllerAdvice {
	
	/*******
	 * Method : foundUserException
	 * Description : It is used to return the exception message and its HTTP status
	 * @returns ResponseEntity - It returns the exception message and its HTTP status
	 * @Param Exception - It is parent class of exception
	 * CreatedBy - Tejaswini.T
	 * Created Date - 23-MAR-2021
	 *******/

	@ExceptionHandler(UserException.class)
	public ResponseEntity<String> foundUserException(Exception exception){
		return new ResponseEntity<String>(exception.getMessage(),HttpStatus.NOT_FOUND);
	}
}
