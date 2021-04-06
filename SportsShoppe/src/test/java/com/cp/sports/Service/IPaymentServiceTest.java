package com.cp.sports.Service;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;

import java.time.LocalDate;

import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.cp.sports.Entity.Card;
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
	static ArrayList<Payment> list = new ArrayList<>();
	
	/**********************
	 * Method:addPaymentTest 
	 * Description:To test the addPayment method of the paymentservice 
	 * Created By     - Pranathi Boyina
	 * Created Date   - 22-March-2021
	 **********************/
	@Test
	public void addPaymentTest() {
		LocalDate expiryDate = LocalDate.parse("2025-07-01");
		Card card = new Card(3, "pranathi", "1234567891", expiryDate, "SBI");
		Payment payment1 = new Payment(3, "debit", "success", card);
		assertEquals(payment1.toString(), paymentService.addPayment(payment1).toString());
		list.add(payment1);

	}
	/**********************
	 * Method:removePaymentTest 
	 * Description:To test the removePayment method of the paymentservice 
	 * Created By     - Pranathi Boyina
	 * Created Date   - 22-March-2021
	 **********************/
	@Test
	public void removePaymentTest() {
		LocalDate expiryDate = LocalDate.parse("2025-07-01");
		Card card = new Card(4, "pranathi", "1234567897", expiryDate, "SBI");
		Payment payment1 = new Payment(4, "debit", "success", card);
		assertEquals(payment1.toString(), paymentService.addPayment(payment1).toString());
		assertEquals(payment1.toString(), paymentService.removePayment(4).toString());

	}
	
	/*************************
	 * Method:getPaymentDetailsTest 
	 * Description:To test the getPaymentDetails method of the paymentservice 
	 * Created By     - Pranathi Boyina
	 * Created Date   - 22-March-2021
	 *************************/
	@Test
	public void getPaymentDetailsTest() {
		LocalDate expiryDate = LocalDate.parse("2025-07-01");
		Card card = new Card(5, "pranathi", "1334567897", expiryDate, "BOB");
		Payment payment1 = new Payment(5, "debit", "success", card);
		assertEquals(payment1.toString(), paymentService.addPayment(payment1).toString());
		list.add(payment1);

		assertEquals(payment1.toString(), paymentService.getPaymentDetails(5).toString());
	}
	
	/************************
	 * Method:updatePaymentTest 
	 * Description:To test the updatePayment method of the paymentservice 
	 * Created By     - Pranathi Boyina
	 * Created Date   - 22-March-2021
	 ************************/
	@Test
	public void updatePaymentTest() {
		LocalDate expiryDate = LocalDate.parse("2025-07-01");
		Card card1 = new Card(6, "pranathi", "1224578845", expiryDate, "Canara");
		Payment payment1 = new Payment(6, "debit", "success", card1);
		assertEquals(payment1.toString(), paymentService.addPayment(payment1).toString());
		expiryDate = LocalDate.parse("2025-07-01");
		Card card2 = new Card(7, "pranathi", "1235897824", expiryDate, "Indian");
		Payment payment2 = new Payment(6, "debit", "success", card2);
		list.add(payment2);
		assertEquals(payment2.toString(), paymentService.updatePayment(6, payment2).toString());
	}
	
	/*************************
	 * Method:getAllPaymentDetailsTest 
	 * Description:To test the getAllPaymentDetails method of the paymentservice 
	 * Created By     - Pranathi Boyina
	 * Created Date   - 22-March-2021
	 **************************/
	@Test
	void getAllPaymentDetailsTest() {
		LocalDate expiryDate = LocalDate.parse("2025-07-01");
		Card card = new Card(8, "pranathi", "1234589784", expiryDate, "Union");
		Payment payment1 = new Payment(8, "credit", "success", card);
		assertEquals(payment1.toString(), paymentService.addPayment(payment1).toString());
		list.add(payment1);
		assertEquals(list.toString(), paymentService.getAllPaymentDetails().toString());
	}

}