package com.cp.sports.Service;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertThrows;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.cp.sports.Entity.User;
import com.cp.sports.Exception.UserException;

@SpringBootTest
public class IUserServiceTest {
@Autowired
private IUserService iUserService;
User user1=new User("12345", "admin", "admin");
User user2=new User("12345", "teju", "admin");
@Test
void addUserTest() {
	User user1=new User("100", "admin", "admin");
	assertEquals("admin",iUserService.addUser(user1).getPassword());
	iUserService.deleteUser("100");
}
@Test
void updateUserTest() {
	assertEquals("teju",iUserService.updateUser(user2).getPassword());
}
@Test
void signInTest() {
	assertEquals("tejuadmin",iUserService.changePassword("12345", "teju","tejuadmin").getPassword());
}
@Test
void exceptionTest() {
	assertThrows(UserException.class,()->{ 
		iUserService.deleteUser("10");
		});
}
}