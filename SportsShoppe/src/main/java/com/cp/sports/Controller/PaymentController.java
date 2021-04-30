package com.cp.sports.Controller;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.cp.sports.Entity.Payment;
import com.cp.sports.Exception.PaymentServiceException;
import com.cp.sports.Service.IPaymentService;

import io.swagger.annotations.Api;

@Api(value = "Swagger2DemoRestController")
@RestController
@RequestMapping("/")
@CrossOrigin(origins = "http://localhost:4200")
/**********************************************************************
* @author        Pranahti Boyina  
* Description    It is a Controller class that provides the
*                Handler methods to add,remove,update and get payment
* Version       1.0 
* Created Date  23-March-2021
***********************************************************************/
public class PaymentController {

	@Autowired
    private IPaymentService paymentService;
	/**********************************************************************************************
	 * Method:addPayment 
	 * Description:To add the payment to the database
	 * @param payment                  - payment to be added to the database
	 * @param RequestBody              - It maps the HttpRequest body to a transfer or domain
	 *                                   object, enabling automatic deserialization of the inbound
	 *                                   HttpRequest body onto a Java object.
	 * @returns Payment                - returns payment after adding to database
	 * @throws PaymentServiceException - It is raised when payment already exists
	 * CreatedBy                       - Pranathi Boyina
	 * Created Date                    - 23-MAR-2021
	 **********************************************************************************************/
	@PostMapping("/addPayment")
	public ResponseEntity<Payment> addPayment(@RequestBody Payment payment) {
		Payment resultpayment = paymentService.addPayment(payment);
		return new ResponseEntity<Payment>(resultpayment, HttpStatus.OK);
	}
	/**********************************************************************************************
	 * Method:removePayment 
	 * Description:To remove the payment from the database
	 * @param paymentId                -payment with the paymentId is deleted from the database
	 * @param PathVariable             - It maps the HttpRequest body to a transfer or domain
	 *                                   object, enabling automatic deserialization of the inbound
	 *                                   HttpRequest body onto a Java object.
	 * @returns payment                - returns payment after removing from the database
	 * @throws PaymentServiceException - It is raised when payment already exists
	 * CreatedBy                       - Pranathi Boyina 
	 * Created Date                    - 23-MAR-2021
	**********************************************************************************************/
	
	@DeleteMapping("/removePayment/{id}")
	public ResponseEntity<Payment> removePayment(@PathVariable long id){
		Payment resultpayment =paymentService.removePayment(id);
		return new ResponseEntity<Payment>(resultpayment, HttpStatus.OK);
	}
	
     /**********************************************************************************************
	 * Method:updatePayment 
	 * Description:To update the payment in the database
	 * @param payment                  - payment to be updated
	 * @param RequestBody              - It maps the HttpRequest body to a transfer or domain
	 *                                   object, enabling automatic deserialization of the inbound
	 *                                   HttpRequest body onto a Java object.
	 * @returns Payment                - returns Payment after updating the payment to database
	 * @throws PaymentServiceException - It is raised when payment not found 
	 * CreatedBy                       - Pranathi Boyina 
	 * Created Date                    - 23-MAR-2021
	 **********************************************************************************************/
	
	@PutMapping("/updatePayment")
	public ResponseEntity<Payment> updatePayment(@RequestBody Payment payment) {
		Payment resultPayment = paymentService.updatePayment(payment.getPaymentId(), payment);
		return new ResponseEntity<Payment>(resultPayment, HttpStatus.OK);
	}
	/**********************************************************************************************
	 * Method:getPaymentDetails
	 * Description:To find the payment from the database using Id
	 * @param paymentId                - To fetch the payment from the database using Id
	 * @param PathVariable             - It maps the HttpRequest body to a transfer or domain
	 *                                   object, enabling automatic deserialization of the inbound
	 *                                   HttpRequest body onto a Java object.
	 * @returns Payment                - returns payments after fetching the database
	 * @throws PaymentServiceException - It is raised when paymentId does not exists
	 * CreatedBy                       - Pranathi Boyina 
	 * Created Date                    - 23-MAR-2021
	 **********************************************************************************************/
	
	@GetMapping("/getPaymentDetails/{id}")
	public ResponseEntity<Payment> GetPaymentDetails(@PathVariable long id){
		Payment resultPayment = paymentService.getPaymentDetails(id);
		return new ResponseEntity<Payment>(resultPayment, HttpStatus.OK);
	}
	/**********************************************************************************************
	 * Method:getAllPaymentDetails
	 * Description:To get all the payment from the database
	 * @param null                     - 
	 * @returns List<payment>          - returns all payments from the database
	 * @throws PaymentServiceException - It is raised when payment table is empty
	 * CreatedBy                       - Pranathi Boyina  
	 * Created Date                    - 23-MAR-2021
	 **********************************************************************************************/
	
	@GetMapping("/getAllPaymentDetails/all")
	public ResponseEntity<List<Payment>> getAllPayment() {
		List<Payment> resultPayment = paymentService.getAllPaymentDetails();
		return new ResponseEntity<List<Payment>>(resultPayment, HttpStatus.OK);
	}

}
