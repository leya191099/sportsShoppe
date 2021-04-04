package com.cp.sports.Controller;

import java.util.List;

import javax.transaction.Transactional;

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

import com.cp.sports.Entity.Payment;
import com.cp.sports.Exception.PaymentServiceException;
import com.cp.sports.Service.IPaymentService;

import io.swagger.annotations.Api;

@Api(value = "Swagger2DemoRestController")
@RestController
public class PaymentController {
	@Autowired
	private IPaymentService paymentService;
	
	@PostMapping("/addPayment")
	public ResponseEntity<Payment> addPayment(@RequestBody Payment payment) {
		Payment resultpayment = paymentService.addPayment(payment);
		return new ResponseEntity<Payment>(resultpayment, HttpStatus.OK);
	}

	@DeleteMapping("/removePayment/{id}")
	public Payment removePayment(@PathVariable long id) throws PaymentServiceException {
		return paymentService.removePayment(id);
	}

	@PutMapping("/updatePayment")
	public ResponseEntity<Payment> updatePayment(@RequestBody Payment payment) {
		Payment resultPayment = paymentService.updatePayment(payment.getPaymentId(), payment);
		return new ResponseEntity<Payment>(resultPayment, HttpStatus.OK);
	}

	@GetMapping("/getPaymentDetails/{id}")
	public ResponseEntity<Payment> GetPaymentDetails(@PathVariable long id) throws PaymentServiceException {
		Payment resultPayment = paymentService.getPaymentDetails(id);
		return new ResponseEntity<Payment>(resultPayment, HttpStatus.OK);
	}

	@GetMapping("/getAllPaymentDetails")
	public ResponseEntity<List<Payment>> getAllPayment() {
		List<Payment> resultPayment = paymentService.getAllPaymentDetails();
		return new ResponseEntity<List<Payment>>(resultPayment, HttpStatus.OK);
	}



}
