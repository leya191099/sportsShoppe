package com.cp.sports.Service;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;


import com.cp.sports.Entity.User;

public class IUserServiceTest {
	@Autowired
	IUserService userService;
	User user1=new User("CAPG123","123password","customer");
	User user2=new User("CAPG125","125password","customer");

	@Test
	void addUser() {
		
		assertEquals("customer",userService.addUser(user1).getRole().toString());
	}
	
	
}
