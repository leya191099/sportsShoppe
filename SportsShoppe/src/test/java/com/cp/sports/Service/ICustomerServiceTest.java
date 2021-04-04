package com.cp.sports.Service;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import java.time.LocalDate;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.assertThrows;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.cp.sports.Exception.CustomerServiceException;
import com.cp.sports.Entity.Address;
import com.cp.sports.Entity.Customer;
@SpringBootTest
public class ICustomerServiceTest {
	@Autowired
	private ICustomerService customerservice;
	Address address=new Address("136","nuaj","aa","vij","ap",55);
	Customer customer=new Customer("vtu102","jhansi","jhansi@gmail","333",LocalDate.parse("2000-02-02"),address);
	@Test
	void AddTest() {
//	customerservice.addCustomer(customer);
		assertEquals("jhansi",customerservice.getCustomer("vtu102").getName());
	}
	@Test
	void deleteTest() {
		assertThrows(CustomerServiceException.class,()->{
			customerservice.removeCustomer("vtu10216");
		});
	}
	@Test
	void getCustomerTest() {
		assertEquals("jhansi",customerservice.getCustomer("1").getName().toString());
	}
}
