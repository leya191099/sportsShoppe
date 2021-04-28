package com.cp.sports.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
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
import com.cp.sports.Exception.UserException;
import com.cp.sports.Service.IUserService;

import io.swagger.annotations.Api;


@RestController
@Api(value = "Swagger2DemoRestController")
@RequestMapping("/sports")
@CrossOrigin(origins = "http://localhost:4200")
//Class Level Comment
/**********
* @author Tejaswini.T Description It is a Controller class that provides the
*         Handler methods for adding new users
* 
*         Version 1.0 Created Date 22-March-2021
**********/

public class UserController {
	
	@Autowired
	private IUserService userservice;

	/**********
	 * Method : addUser
	 *  Description : To add the user to the database
	 * 
	 * @param user     - user to be added to the database
	 * @param RequestBody - It maps the HttpRequest body to a transfer or domain object, enabling automatic deserialization of the inbound HttpRequest body onto a Java object.
	 * @returns user - returns user after adding the user to database
	 * @throw userServiceException - It is raised when user already exists
	 * CreatedBy -Tejaswini .T
	 *  Created Date - 24-MAR-2021
	 **********/

	@PostMapping("/user")
	public ResponseEntity<User> addUser(@RequestBody User user) {
		return new ResponseEntity<User>(userservice.addUser(user),HttpStatus.OK);
	}

	/**********
	 * Method : updateUser
	 *  Description : To update the user in the database
	 * @param user - user to be updated
	 * @returns user - returns user after updating the user to database
	 * @throws UserServiceException - It is raised when user not found 
	 * CreatedBy - Tejaswini.T
	 * Created Date - 23-MAR-2021
	 **********/
	@PutMapping("/user")
	public ResponseEntity<User> updateUser(@RequestBody User user) {
		return new ResponseEntity<User>(userservice.updateUser(user),HttpStatus.OK);
	}

	/**********
	 * Method : deletUser
	 * Description : To delete the user from the database
	 * @param user       - user is deleting from the database
	 * @param PathVariable - It maps the HttpRequest body to a transfer or domain object, enabling automatic deserialization of the inbound HttpRequest body onto a Java object.
	 * @returns void - returns void
	 * @throw UserServiceException - It is raised when user already exists
	 * CreatedBy - Tejaswini.T
	 *  Created Date - 24-MAR-2021
	 **********/
	@DeleteMapping("/user/{userID}")
	public ResponseEntity<User> deleteUser(@PathVariable String userID) throws UserException{
		return new ResponseEntity<User>(userservice.deleteUser(userID),HttpStatus.OK);
	}

	/**********
	 * Method: finduser
	 * Description : To find the user from the database using id 
	 * @param User - To fetch the user from the database
	 * @returns User - returns user after fetching the database
	 * @throws UserServiceException - It is raised when user does not exists
	 * CreatedBy - Tejaswini.T 
	 * Created Date -23-MAR-2021
	 **********/

	@GetMapping("/user/{userId}")
	public ResponseEntity<User> getUserById(@PathVariable String userId) throws UserException {
		return new ResponseEntity<User>(userservice.getId(userId),HttpStatus.OK);
	}
	
	/**********
	 * Method  :loginUser 
	 * Description : User can signIn from the database
	 * @param User - To fetch the user from the database
	 * @returns User - returns user after fetching the database
	 * CreatedBy - Tejaswini.T 
	 * Created Date -23-MAR-2021
	 **********/

	@PostMapping("/user/login")
	public ResponseEntity<Boolean> loginUser(@RequestBody User user){		
		return new ResponseEntity<Boolean>(userservice.signIn(user),HttpStatus.OK);
	}
	
	/**********
	 * Method  :logOutUser 
	 * Description : User can signOut from the database
	 * @param User - To fetch the user from the database
	 * @returns User - returns user after fetching the database
	 * CreatedBy - Tejaswini.T 
	 * Created Date -23-MAR-2021
	 **********/
	
	@PostMapping("/user/logout")
	public ResponseEntity<Boolean> logoutUser(@RequestBody User user){		
		return new ResponseEntity<Boolean>(userservice.signOut(user),HttpStatus.OK);
	}
	
	/**********
	 * Method : UpdateOldPassword
	 * Description : To update the password of the user 
	 * @param user       -updating the password from the database
	 * @param PathVariable - It maps the HttpRequest body to a transfer or domain object, enabling automatic deserialization of the inbound HttpRequest body onto a Java object.
	 * @returns void - returns void
	 * CreatedBy - Tejaswini.T
	 *  Created Date - 24-MAR-2021
	 **********/
		
	@PutMapping("/user/updateoldpassword/{id}/{oldpass}/{newpass}")
	public ResponseEntity<User> updateoldPassword(@PathVariable("id") String id,@PathVariable("oldpass") String oldpass,@PathVariable("newpass") String newpass){		
		return new ResponseEntity<User>(userservice.changePassword(id,oldpass,newpass),HttpStatus.OK);
	}
	
	/**********
	 * Method : getAllUser
	 *  Description : To get all the user from the database
	 * 
	 * @returns List<User> - returns user after fetching the database
	 * @throws UserServiceException - It is raised when user does not found
	 * CreatedBy - Tejaswini.T
	 * Created Date - 23-MAR-2021
	 **********/
	
	@GetMapping("/viewall")
	public List<User> getAllUsers(){
		return userservice.getUsers();
	}
}