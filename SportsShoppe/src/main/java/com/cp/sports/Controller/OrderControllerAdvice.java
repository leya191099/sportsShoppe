package com.cp.sports.Controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import com.cp.sports.Exception.OrderServiceException;

@RestControllerAdvice
/****************************
 * @author Leya Varghese 
 * Description It is a ControllerAdvice which allows to handle exceptions across the whole application
 *Version 1.0 
 *Created Date 22-March-2021
 ****************************/
public class OrderControllerAdvice {
	/****************************
	 * Method : foundOrderException
	 * Description : It is used to return the exception message and its HTTP status
	 * @returns ResponseEntity - It returns the exception message and its HTTP status
	 * @Param Exception - It is parent class of exception
	 * CreatedBy - Leya Varghese
	 * Created Date - 23-MAR-2021
	 ****************************/
	@ExceptionHandler(OrderServiceException.class)
	public ResponseEntity<String> foundOrderException(Exception exception){
		return new ResponseEntity<String>(exception.getMessage(),HttpStatus.NOT_FOUND);
	}
}
