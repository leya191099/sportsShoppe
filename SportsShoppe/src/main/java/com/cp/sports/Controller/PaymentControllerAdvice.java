package com.cp.sports.Controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import com.cp.sports.Exception.PaymentServiceException;



@RestControllerAdvice
/************************
* @author        Pranahti Boyina  
* Description    It is a Controller class that provides the
*                Handler methods to add,remove,update and get payment
* Version        1.0 
* Created Date   23-March-2021
*************************/
public class PaymentControllerAdvice {
	/******************************
	 * Method:foundPaymentException 
	 * Description:It is used to return the exception message and its HTTP status
	 * @returns ResponseEntity       - It returns the exception message and its HTTP status
	 * @Param Exception              - It is parent class of exception
	 * CreatedBy                     - Pranathi Boyina
	 * Created Date                  - 23-MAR-2021
	 ******************************/

	@ExceptionHandler(PaymentServiceException.class)
	public ResponseEntity<String> foundPaymentException(Exception exception){
		return new ResponseEntity<String>(exception.getMessage(),HttpStatus.NOT_FOUND);
	}
}