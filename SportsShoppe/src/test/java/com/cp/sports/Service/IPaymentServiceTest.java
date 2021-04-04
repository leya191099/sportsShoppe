package com.cp.sports.Service;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;

import java.time.LocalDate;

import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;


import com.cp.sports.Entity.Payment;




import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;

import java.time.LocalDate;
import java.util.ArrayList;

import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;



@SpringBootTest
public class IPaymentServiceTest {

	@Autowired
	private IPaymentService paymentService;
	ArrayList<Payment> list=new ArrayList<>();
	@Test
	public void addPaymentTest() {
		LocalDate expiryDate=LocalDate.parse("2025-07-01");
		Payment payment1=new Payment(3,"debit","paid",3,"pranathi","124",expiryDate,"SBI");
		assertEquals(payment1.toString(),paymentService.addPayment(payment1).toString());
		list.add(payment1);
		paymentService.removePayment(3);
	}
	
	@Test
	public void removePaymentTest() {
		LocalDate expiryDate=LocalDate.parse("2025-07-01");
		Payment payment1=new Payment(4,"debit","paid",4,"pranathi","124",expiryDate,"SBI");
		assertEquals(payment1.toString(),paymentService.addPayment(payment1).toString());
		assertEquals(payment1.toString(),paymentService.removePayment(4).toString());
//		assertEquals(null,paymentService.removePayment(4));
	}
	@Test
	public void getPaymentTest() {
		LocalDate expiryDate=LocalDate.parse("2025-07-01");
		Payment payment1=new Payment(5,"debit","paid",5,"pranathi","124",expiryDate,"SBI");
		assertEquals(payment1.toString(),paymentService.addPayment(payment1).toString());
		list.add(payment1);
		assertEquals(payment1.toString(),paymentService.getPaymentDetails(5).toString());
		paymentService.removePayment(5);
	}
	@Test
	public void updatePaymentTest() {
		LocalDate expiryDate=LocalDate.parse("2025-07-01");
		Payment payment1=new Payment(6,"debit","paid",6,"pranathi","124",expiryDate,"SBI");
		assertEquals(payment1.toString(),paymentService.addPayment(payment1).toString());
		expiryDate=LocalDate.parse("2025-07-01");
		Payment payment2=new Payment(6,"debit","paid",7,"pranathi","124",expiryDate,"SBI");
		list.add(payment2);
		assertEquals(payment2.toString(),paymentService.updatePayment(6,payment2).toString());
		paymentService.removePayment(6);
	}
	
	@Test
	void getPaymentDetailsTest() {
		LocalDate expiryDate=LocalDate.parse("2025-07-01");
		Payment payment1=new Payment(8,"debit","paid",8,"pranathi","124",expiryDate,"SBI");
		assertEquals(payment1.toString(),paymentService.addPayment(payment1).toString());
		list.add(payment1);
		assertEquals(list.toString(), paymentService.getAllPaymentDetails().toString());
		paymentService.removePayment(8);
	}
	
	
}

