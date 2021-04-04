package com.cp.sports.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.cp.sports.Entity.Customer;
import com.cp.sports.Exception.CustomerServiceException;
import com.cp.sports.Service.ICustomerService;

import io.swagger.annotations.Api;

@RestController
@Api(value = "Swagger2DemoRestController")
@RequestMapping("/sport")
public class CustomerController {
	@Autowired
	private ICustomerService customerService;
	/************************************************************************************
	 * Method                           : addCustomer 
	 * Description                      : To add the customer to the database
	 * @param customer                  - customer to be added to the database
	 * @param RequestBody               - It maps the HttpRequest body to a transfer or domain object,
                                          enabling automatic deserialization of the inbound HttpRequest 
                                          body onto a Java object.
	 *@returns Customer                 - returns customer after adding the customer to database 
	 * @throws CustomerServiceException - It is raised when customer already exists
	 * CreatedBy                        - S.Abhishek 
	 * Created Date                     - 24-MAR-2021
	 ************************************************************************************/
	
	@PostMapping("/customer")
	public ResponseEntity<Customer> insertCustomer(@RequestBody Customer customer){
		Customer resultcustomer = customerService.addCustomer(customer);
		return new ResponseEntity<Customer>(resultcustomer,HttpStatus.OK);
	}
	
	/************************************************************************************
	 * Method                           : deleteCustomer 
	 * Description                      : To delete the customer from the database
	 * @param customer                  - customer is deleting from the database
	 * @param PathVariable              - It maps the HttpRequest body to a transfer or domain object,
                                          enabling automatic deserialization of the inbound HttpRequest 
                                          body onto a Java object.
	 *@returns void                     - returns void 
	 * @throws CustomerServiceException - It is raised when customer already exists
	 * CreatedBy                        - S.Abhishek 
	 * Created Date                     - 24-MAR-2021
	 ************************************************************************************/
	@DeleteMapping("/customer/{id}")
	public void deleteCustomer(@PathVariable String id) throws CustomerServiceException{
	customerService.removeCustomer(id);
	}
	/************************************************************************************
	 * Method                           : updateCustomer 
	 * Description                      : To update the customer in the database
	 * @param customer                  - customer to be updated
	 *@returns Customer                 - returns customer after updating the customer to database 
	 * @throws CustomerServiceException - It is raised when customer not found
	 * CreatedBy                        - S.Abhishek 
	 * Created Date                     - 23-MAR-2021
	 ************************************************************************************/
	@PutMapping("/customer")
	public ResponseEntity<Customer> updateCustomer(@RequestBody Customer customer) {
		Customer resultCustomer = customerService.updateCustomer(customer.getUserId(),customer);
		return new ResponseEntity<Customer>(resultCustomer, HttpStatus.OK);
	}
	/************************************************************************************
	 * Method                           : findCustomer 
	 * Description                      : To find the customer from the database using id
	 * @param customer                  - To fetch the customer from the database
	 *@returns Customer                 - returns customer after fetching the database
	 * @throws CustomerServiceException - It is raised when customer does not exists
	 * CreatedBy                        - S.Abhishek 
	 * Created Date                     - 23-MAR-2021
	 ************************************************************************************/

	@GetMapping("/customer/{id}")
	public ResponseEntity<Customer> findCustomer(@PathVariable String id) throws CustomerServiceException{
		Customer resultCustomer = customerService.getCustomer(id);
		return new ResponseEntity<Customer>(resultCustomer, HttpStatus.OK);
	}
	/************************************************************************************
	 * Method                           : getAllCustomers
	 * Description                      : To get all the customers from the database
	 *@returns List<Customer>           - returns customers after fetching the database 
	 * @throws CustomerServiceException - It is raised when customer does not found
	 * CreatedBy                        - S.Abhishek 
	 * Created Date                     - 23-MAR-2021
	 ************************************************************************************/

	@GetMapping("/customer/all")
	public ResponseEntity<List<Customer>> getAllCustomer(){
		List<Customer> resultCustomer = customerService.getAllCustomers();
		return new ResponseEntity<List<Customer>>(resultCustomer, HttpStatus.OK);
	}

	

}
