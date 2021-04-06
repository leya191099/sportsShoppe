package com.cp.sports.Controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import com.cp.sports.Exception.ProductServiceException;


@RestControllerAdvice
/**********
 * @author G.Joslin Description It is a ControllerAdvice which allows to handle
 *         ProductServiceException across the whole application Version 1.0
 *         Created Date 22-March-2021
 **********/
public class ProductControllerAdvice {
	/**********
	 * Method : foundProductException Description : It is used to return the
	 * exception message and its HTTP status
	 * 
	 * @returns ResponseEntity - It returns the exception message and its HTTP
	 *          status
	 * @Param Exception - It is parent class of exception CreatedBy - G.Joslin
	 *        Created Date - 23-MAR-2021
	 **********/
	@ExceptionHandler(ProductServiceException.class)
	public ResponseEntity<String> foundProductException(Exception exception) {
		return new ResponseEntity<String>(exception.getMessage(), HttpStatus.NOT_FOUND);
	}
}
