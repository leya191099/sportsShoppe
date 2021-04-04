package com.cp.sports.Service;

import java.util.List;

import com.cp.sports.Entity.Customer;
import com.cp.sports.Exception.CustomerServiceException;



public interface ICustomerService {
	public Customer addCustomer(Customer customer);

	public void removeCustomer(String custId) throws CustomerServiceException;

	public Customer updateCustomer(String custId, Customer customer);

	public Customer getCustomer(String string) throws CustomerServiceException;

	public List<Customer> getAllCustomers();

}
