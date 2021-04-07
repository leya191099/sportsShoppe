package com.cp.sports.Service;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertThrows;

import java.time.LocalDate;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.cp.sports.Entity.Address;
import com.cp.sports.Entity.Customer;
import com.cp.sports.Entity.Orders;
import com.cp.sports.Exception.OrderServiceException;
import com.cp.sports.Service.IOrderService;

@SpringBootTest
public class IOrderServiceTest {
	@Autowired
	IOrderService iOrderService;
	Address addr = new Address("15", "ganesh", "power house", "chirla", "AP", 523157);
	Customer cust = new Customer("105", "Leya", "vtu665@gmail.com", "9845612378", LocalDate.parse("1999-12-12"), addr);
	Orders order = new Orders(10, 500.0, LocalDate.parse("2021-12-12"), cust);
	/****************************
	 * Method :addOrderTest
	 * Description :To test the addOrder method of IOrderService
	 * CreatedBy - Leya Varghese 
	 * Created Date-23-MAR-2021
	 ****************************/
	@Test
	void addOrderTest() {
		Address addr = new Address("21", "ganeshnagar", "power house", "chirla", "AP", 523157);
		Customer cust = new Customer("1", "Leya11", "vtu665@gmail.com", "9845612378", LocalDate.parse("1999-12-12"),
				addr);
		Orders order = new Orders(1, 500.0, LocalDate.parse("2021-12-12"), cust);
         iOrderService.addOrder(order);
		assertNotNull(order.getAmount());
		iOrderService.removeOrder(1);
	}
	/****************************
	 * Method :updateOrderTest
	 * Description :To test the updateOrder method of IOrderService
	 * CreatedBy - Leya Varghese 
	 * Created Date-23-MAR-2021
	 ****************************/
	@Test
	void updateOrderTest() {
		System.out.println(iOrderService.updateOrder(10, order));
		assertEquals(
				"Orders [OrderId=10, amount=500.0, billingDate=2021-12-12, customer=Customer [userId=105, name=Leya, email=vtu665@gmail.com, contactNo=9845612378, dob=1999-12-12, address=Address [doorNo=15, street=ganesh, area=power house, city=chirla, state=AP, pincode=523157]]]",
				iOrderService.updateOrder(10, order).toString());
	}
	/****************************
	 * Method :getOrderDetailsTest1
	 * Description :To test the getOrderDetails method of IOrderService
	 * CreatedBy - Leya Varghese 
	 * Created Date-23-MAR-2021
	 ****************************/
	@Test
	void getOrderDetailsTest1() {
//		System.out.println(iOrderService.getOrderDetails(9).getBillingDate());
		assertEquals("2021-12-12", iOrderService.getOrderDetails(10).getBillingDate().toString());
	}
	/****************************
	 * Method :getOrderDetailsTest2
	 * Description :To test the getOrderDetails method of IOrderService
	 * CreatedBy - Leya Varghese 
	 * Created Date-23-MAR-2021
	 ****************************/
	@Test
	void getOrderDetailsTest2() {
		assertEquals(Double.valueOf(500.0), iOrderService.getOrderDetails(10).getAmount());
	}
	/****************************
	 * Method :removeOrderTest
	 * Description :To test the removeOrder method of IOrderService
	 * CreatedBy - Leya Varghese 
	 * Created Date-23-MAR-2021
	 ****************************/
	@Test
	void removeOrderTest() {
		Address addr = new Address("13", "ganesh", "power house", "chirla", "AP", 523157);
		Customer cust = new Customer("101", "Leya", "vtu665@gmail.com", "9845612378", LocalDate.parse("1999-12-12"),
				addr);
		Orders order1 = new Orders(2, 500.0, LocalDate.parse("2021-12-12"), cust);
		iOrderService.addOrder(order1);
		assertEquals(500.0,iOrderService.removeOrder(2).getAmount());
	}
	/****************************
	 * Method :exceptionTest
	 * Description :To test exception handling of IOrderService
	 * CreatedBy - Leya Varghese 
	 * Created Date-23-MAR-2021
	 ****************************/
	@Test
	void exceptionTest() {
		assertThrows(OrderServiceException.class,()->{
			iOrderService.removeOrder(2);
		});
	}
	/****************************
	 * Method :getOrderDetailsTest3
	 * Description :To test the getOrderDetails method of IOrderService
	 * CreatedBy - Leya Varghese 
	 * Created Date-23-MAR-2021
	 ****************************/
	@Test
	void getOrderDetailsTest3() {
		System.out.println(iOrderService.getOrderDetails(10).getCustomer());
	assertEquals("Customer [userId=105, name=Leya, email=vtu665@gmail.com, contactNo=9845612378, dob=1999-12-12, address=Address [doorNo=15, street=ganesh, area=power house, city=chirla, state=AP, pincode=523157]]", iOrderService.getOrderDetails(10).getCustomer().toString());
	}
	/****************************
	 * Method :getOrderDetailsTest4
	 * Description :To test the getOrderDetails method of IOrderService
	 * CreatedBy - Leya Varghese 
	 * Created Date-23-MAR-2021
	 ****************************/
	@Test
	void getOrderDetailsTest4() {
		System.out.println(iOrderService.getOrderDetails(10).getCustomer());
	assertEquals("9845612378", iOrderService.getOrderDetails(10).getCustomer().getContactNo().toString());
	}
	/****************************
	 * Method :getOrderDetailsTest5
	 * Description :To test the getOrderDetails method of IOrderService
	 * CreatedBy - Leya Varghese 
	 * Created Date-23-MAR-2021
	 ****************************/
	@Test
	void getOrderDetailsTest5() {
		System.out.println(iOrderService.getOrderDetails(10).getCustomer());
	assertEquals("vtu665@gmail.com", iOrderService.getOrderDetails(10).getCustomer().getEmail().toString());
	}
	/****************************
	 * Method :exceptionTest2
	 * Description :To test exception handling of IOrderService
	 * CreatedBy - Leya Varghese 
	 * Created Date-23-MAR-2021
	 ****************************/
	@Test
	void exceptionTest2() {
		assertThrows(OrderServiceException.class,()->{
		iOrderService.addOrder(order);
		});
	}
}
