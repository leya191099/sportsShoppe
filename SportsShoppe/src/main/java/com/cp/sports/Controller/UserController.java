package com.cp.sports.Controller;

import java.util.List;

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

import com.cp.sports.Entity.User;
import com.cp.sports.Exception.InvalidUsernamePasswordException;
import com.cp.sports.Service.IUserService;

import io.swagger.annotations.Api;


@RestController
@Api(value = "Swagger2DemoRestController")
@RequestMapping("/sports")
public class UserController {
	
	@Autowired
	private IUserService userservice;

	@PostMapping
	public User addUser(@RequestBody User user) {
		return userservice.addUser(user);
	}

	@PutMapping
	public User updateUser(@RequestBody User user) {
		return userservice.updateUser(user);
	}

	@DeleteMapping("/{userID}")
	public User deleteUser(@PathVariable String userID) {
		return userservice.deleteUser(userID);
	}

	@GetMapping("/{userId}")
	public User getUserById(@PathVariable String userId) {
		return userservice.getId(userId);
	}

	@PostMapping("/login")
	public ResponseEntity<Boolean> loginUser(@RequestBody User user){		
		return new ResponseEntity<Boolean>(userservice.signIn(user),HttpStatus.OK);
	}
	
	@PostMapping("/logout")
	public ResponseEntity<Boolean> logoutUser(@RequestBody User user){		
		return new ResponseEntity<Boolean>(userservice.signOut(user),HttpStatus.OK);
	}
	
		
	@PutMapping("/updateoldpassword/{id}/{oldpass}/{newpass}")
	public ResponseEntity<User> updateoldPassword(@PathVariable("id") String id,@PathVariable("oldpass") String oldpass,@PathVariable("newpass") String newpass){		
		return new ResponseEntity<User>(userservice.changePassword(id,oldpass,newpass),HttpStatus.OK);
	}
	
	
	@GetMapping(value="/all")
	public List<User> getAllUsers(){
		return userservice.getUsers();
	}
}
