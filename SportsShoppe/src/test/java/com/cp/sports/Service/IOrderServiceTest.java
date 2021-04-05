package com.cp.sports.Service;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertNull;

import java.time.LocalDate;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.cp.sports.Entity.Address;
import com.cp.sports.Entity.Customer;
import com.cp.sports.Entity.Orders;
import com.cp.sports.Service.IOrderService;

@SpringBootTest
public class IOrderServiceTest {
	@Autowired
	IOrderService iOrderService;
	Address addr = new Address("15", "ganesh", "power house", "chirla", "AP", 523157);
	Customer cust = new Customer("105", "Leya", "vtu665@gmail.com", "9845612378", LocalDate.parse("1999-12-12"), addr);
	Orders order = new Orders(10, 500.0, LocalDate.parse("2021-12-12"), cust);

	@Test
	void addOrderTest() {
//iOrderService.addOrder(order);
		assertNotNull(order.getAmount());
		System.out.println(iOrderService.getOrderDetails(10));
		System.out.println(iOrderService.getAllOrders().size());
	}

	@Test
	void updateOrderTest() {
		System.out.println(iOrderService.updateOrder(10, order));
		assertEquals(
				"Orders [OrderId=10, amount=500.0, billingDate=2021-12-12, customer=Customer [userId=105, name=Leya, email=vtu665@gmail.com, contactNo=9845612378, dob=1999-12-12, address=Address [doorNo=15, street=ganesh, area=power house, city=chirla, state=AP, pincode=523157]]]",
				iOrderService.updateOrder(10, order).toString());
	}

	@Test
	void getOrderDetailsTest1() {
//		System.out.println(iOrderService.getOrderDetails(9).getBillingDate());
		assertEquals("2021-12-12", iOrderService.getOrderDetails(10).getBillingDate().toString());
	}

	@Test
	void getOrderDetailsTest2() {
		assertEquals(Double.valueOf(500.0), iOrderService.getOrderDetails(10).getAmount());
	}

	@Test
	void removeOrderTest() {
		Address addr = new Address("13", "ganesh", "power house", "chirla", "AP", 523157);
		Customer cust = new Customer("101", "Leya", "vtu665@gmail.com", "9845612378", LocalDate.parse("1999-12-12"),
				addr);
		Orders order1 = new Orders(2, 500.0, LocalDate.parse("2021-12-12"), cust);
		iOrderService.addOrder(order1);
		assertNull(iOrderService.removeOrder(2));
	}
}
