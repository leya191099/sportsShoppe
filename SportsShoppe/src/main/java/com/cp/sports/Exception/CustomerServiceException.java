package com.cp.sports.Exception;
/****************************
 *          @author          G. Jhansi
 *          Description      It is a CustomerServiceException exception class that handles the exception occurs at 
 *                           customer level
  *         Version             1.0
  *         Created Date    22-MARCH-2021
 ****************************/
public class CustomerServiceException extends RuntimeException {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	public CustomerServiceException(String msg) {
		super(msg);
	}

}
