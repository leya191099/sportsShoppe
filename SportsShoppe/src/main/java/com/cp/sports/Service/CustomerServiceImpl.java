package com.cp.sports.Service;

import java.util.List;
import java.util.Optional;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

import com.cp.sports.dao.ICustomerRepository;
import com.cp.sports.Entity.Customer;
import com.cp.sports.Exception.CustomerServiceException;


/************************************************************************************
 * @author G. Jhansi Description It is a service class that provides the
 *         services to add a customer, remove a customer, update a customer and
 *         view a customer
 * 
 *         Version 1.0 Created Date 24-March-2021
 ************************************************************************************/
@Service
@Repository
@Transactional
public class CustomerServiceImpl implements ICustomerService {
	@Autowired
	private ICustomerRepository customerrepository;

	/************************************************************************************
	 * Method                           :addCustomer 
	 * Description                      :To add the customer to the database
	 * @param customer                  - customer to be added to the database
	 *@returns Customer                 - returns customer after adding the customer to database 
	 * @throws CustomerServiceException - It is raised when customer already exists
	 * CreatedBy                        - G. Jhansi 
	 * Created Date                     - 23-MAR-2021
	 ************************************************************************************/
	@Override
	public Customer addCustomer(Customer customer) {
		// TODO Auto-generated method stub

		Optional<Customer> customer1 = customerrepository.findById(customer.getUserId());
		if (customer1.isEmpty()) {
			return customerrepository.saveAndFlush(customer);
		} else {
			throw new CustomerServiceException("Customer already exists");
		}

	}
	/************************************************************************************
	 * Method                           :removeCustomer 
	 * Description                      :To remove the customer to the database
	 * @param customer                  - customer to be removed from the database
	 *@returns void                     - returns void
	 * @throws CustomerServiceException - It is raised when customer does not exists
	 * CreatedBy                        - S.Abhishek 
	 * Created Date                     - 23-MAR-2021
	 ************************************************************************************/


	@Override
	public void removeCustomer(String custId) {
		// TODO Auto-generated method stub
		Optional<Customer> customer = customerrepository.findById(custId);
		if (customer.isEmpty())
			throw new CustomerServiceException("custId does not exist to delete");
		else
			customerrepository.delete(customer.get());
	}
	/************************************************************************************
	 * Method                           :updateCustomer 
	 * Description                      :To update the customer in the database
	 * @param customer                  - customer to be updated
	 *@returns Customer                 - returns customer after adding the customer to database 
	 * @throws CustomerServiceException - It is raised when customer not found
	 * CreatedBy                        - S.Abhishek 
	 * Created Date                     - 23-MAR-2021
	 ************************************************************************************/


	@Override
	public Customer updateCustomer(String custId, Customer customer) {
		// TODO Auto-generated method stub
		Optional<Customer> customer1 = customerrepository.findById(custId);
		if (customer1.isEmpty()) {
			throw new CustomerServiceException("Customer not found");
		}
		else
		customerrepository.save(customer);
		return customer;
	}

	/************************************************************************************
	 * Method                           :getCustomer 
	 * Description                      :To get the customer from the database
	 * @param customer                  -To fetch the customer from the database
	 *@returns Customer                 - returns customer after fetching the database
	 * @throws CustomerServiceException - It is raised when customer does not exists
	 * CreatedBy                        - S.Abhishek 
	 * Created Date                     - 23-MAR-2021
	 ************************************************************************************/

	@Override
	public Customer getCustomer(String custId) throws CustomerServiceException {
		// TODO Auto-generated method stub
		Optional<Customer> customer = customerrepository.findById(custId);
		if (customer.isEmpty()) {
			throw new CustomerServiceException("Given custId does not exist");
		}
		return customer.get();
	}
	/************************************************************************************
	 * Method                           :getAllCustomers
	 * Description                      :To get all the customers from the database
	 * @param customer                  -To fetch all the customers from the database
	 *@returns Customer                 - returns customers after fetching the database 
	 * @throws CustomerServiceException - It is raised when customer does not found
	 * CreatedBy                        - S.Abhishek 
	 * Created Date                     - 23-MAR-2021
	 ************************************************************************************/

	@Override
	public List<Customer> getAllCustomers() {
		// TODO Auto-generated method stub
		List<Customer> customer = customerrepository.findAll();
		if (customer.isEmpty()) {
			throw new CustomerServiceException("Customers not found");
		}
		return customer;
	}
	}

