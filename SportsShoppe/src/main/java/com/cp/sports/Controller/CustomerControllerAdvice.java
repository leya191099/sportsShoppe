package com.cp.sports.Controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import com.cp.sports.Exception.CustomerServiceException;


@RestControllerAdvice
/**********
 * @author G. Jhansi 
 * Description It is a ControllerAdvice which allows to handle CustomerServiceException across the whole application
 * Version 1.0 
 * Created Date 22-March-2021
 **********/
public class CustomerControllerAdvice {
	/**********
	 * Method : foundCustomerException
	 * Description : It is used to return the exception message and its HTTP status
	 * @returns ResponseEntity - It returns the exception message and its HTTP status
	 * @Param Exception - It is parent class of exception
	 * CreatedBy - G. Jhansi
	 * Created Date - 23-MAR-2021
	 **********/
	@ExceptionHandler(CustomerServiceException.class)
	public ResponseEntity<String> foundCustomerException(Exception exception){
		return new ResponseEntity<String>(exception.getMessage(),HttpStatus.NOT_FOUND);
	}
}
