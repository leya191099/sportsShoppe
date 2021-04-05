package com.cp.sports.Exception;
/************************************************************************************
 *          @author          Leya Varghese
 *          Description      It is a OrderServiceException exception class that handles the exception occurs at 
 *                           service level
  *         Version             1.0
  *         Created Date    22-MARCH-2021
 ************************************************************************************/
public class OrderServiceException extends RuntimeException {

	public OrderServiceException(String message) {
		super(message);
	}
	

}
