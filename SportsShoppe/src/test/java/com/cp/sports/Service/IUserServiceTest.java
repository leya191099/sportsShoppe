package com.cp.sports.Service;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.cp.sports.Entity.User;

@SpringBootTest
public class IUserServiceTest {
@Autowired
private IUserService iUserService;
User user1=new User("12345", "admin", "admin");
User user2=new User("12345", "teju", "admin");
@Test
void addUserTest() {
	
	assertEquals("admin",iUserService.addUser(user1).getPassword());
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
void deleteTest() {
	assertNull(iUserService.deleteUser("12345"));
}
}