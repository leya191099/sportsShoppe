package com.cp.sports.Service;

import java.util.List;
import java.util.Optional;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

import com.cp.sports.Entity.User;
import com.cp.sports.Exception.UserException;
import com.cp.sports.dao.IUserRepository;


@Service
@Transactional
@Repository
/**********
 * @author Tejaswini.T Description It is a service class that provides the
 *         services to add update ,remove, get, add, sign in, sign out ,change
 *         password Version 1.0 Created Date 24-March-2021
 **********/

public class UserServiceImpl implements IUserService {

	@Autowired
	private IUserRepository iUserRepository;
	private User user;

	/**********
	 * Method :addUser Description :To add the user to the database
	 * 
	 * @param user - user to be added to the database
	 * @returns user - returns user after adding the user to database
	 * @throws UserServiceException - It is raised when user already exists
	 *                              CreatedBy - Tejaswini.T Created Date -
	 *                              23-MAR-2021
	 **********/

	@Override
	public User addUser(User user) {
		Optional<User> user1 = iUserRepository.findById(user.getUserId());
		if (user1.isEmpty())
			return iUserRepository.saveAndFlush(user);
		else
			throw new UserException("User already exists");
	}

	/**********
	 * Method :getId Description :To get the user from the database
	 * 
	 * @param user - To fetch the user from the database
	 * @returns user - returns user after fetching the database
	 * @throws UserServiceException - It is raised when user does not exists
	 *                              CreatedBy - Tejaswini.T Created Date -
	 *                              23-MAR-2021
	 **********/

	@Override
	public User getId(String userID) {
		Optional<User> user = iUserRepository.findById(userID);
		if (user.isEmpty())
			throw new UserException("User with ID: " + userID + " not found!");
		else
			return user.get();
	}

	/**********
	 * Method :updateUser Description :To update the user in the database
	 * 
	 * @param user - user to be updated
	 * @returns user - returns user after adding the user to database
	 * @throws UserServiceException - It is raised when updated user not found
	 *                              CreatedBy -Tejaswini.T Created Date -
	 *                              23-MAR-2021
	 **********/

	@Override
	public User updateUser(User user) {
		Optional<User> user1 = iUserRepository.findById(user.getUserId());
		if (user1.isEmpty())
			throw new UserException("user not found");
		else
			iUserRepository.save(user);
		return user;
	}

	/**********
	 * Method :deleteUser Description :To delete the user from the database
	 * 
	 * @param user - user to be removed from the database
	 * @returns u - returns u
	 * @throws UserServiceException - It is raised when user does not exists
	 *                              CreatedBy - Tejaswini.T Created Date -
	 *                              23-MAR-2021
	 **********/

	@Override
	public User deleteUser(String userID) throws UserException {
		Optional<User> user = iUserRepository.findById(userID);
		if (!user.isEmpty())
			iUserRepository.delete(user.get());
		else
			throw new UserException("User Not Found To Delete!");
		return user.get();
	}

	/**********
	 * Method : User signIn Description :To check whether the given Id and Password
	 * is same or not
	 * 
	 * @param user - User got successfully signed in
	 * @returns status - returns status
	 * @throws UserServiceException - It is raised when password or Id does not
	 *                              match CreatedBy - Tejaswini.T Created Date -
	 *                              23-MAR-2021
	 **********/

	@Override
	public User signIn(User user) {
		
		Optional<User> resultUser = iUserRepository.findById(user.getUserId());
		if (!resultUser.isEmpty()) {
			if (resultUser.get().getPassword().equals(user.getPassword())) {
				return resultUser.get();
			} else {
				throw new UserException("password not matched");
			}
			
		} else {
			throw new UserException("User not found");
			
		}
		
		
	}

	/**********
	 * Method : User signOut Description :To check whether the given Id and Password
	 * is matching or not
	 * 
	 * @param user - User got successfully signedOut
	 * @returns status - returns status
	 * @throws UserServiceException - It is raised when password or Id does not
	 *                              match CreatedBy - Tejaswini.T Created Date -
	 *                              23-MAR-2021
	 **********/

	@Override
	public User signOut(User user) {
		// TODO Auto-generated method stub
		Optional<User> resultUser = iUserRepository.findById(user.getUserId());
		if (!resultUser.isEmpty()) {
			if (resultUser.get().getPassword().equals(user.getPassword())) {
				return resultUser.get();
			} else {
				throw new UserException("password not matched");
			}
		} else {
			throw new UserException("User not found");
		}
		
	}

	/**********
	 * Method : User changePassword Description :To change password by updating in
	 * the database
	 * 
	 * @param id,oldpassword,new password- To change the old password to new
	 *                           password for the user with id -
	 * @returns user - returns user after adding the user to database
	 * @throws UserServiceException - It is raised when password does not match and
	 *                              user not found CreatedBy - Tejaswini.T Created
	 *                              Date - 23-MAR-2021
	 **********/

	@Override
	public User changePassword(String id, String oldpassword, String newpassword) {
		User changeUser;
		Optional<User> resultUser = iUserRepository.findById(id);
		if (!resultUser.isEmpty()) {
			if (resultUser.get().getPassword().equals(oldpassword)) {
				changeUser = new User(id, newpassword, resultUser.get().getRole());
				iUserRepository.save(changeUser);
			} else {
				throw new UserException("password not matched");
			}
		} else {
			throw new UserException("User not found");
		}
		return changeUser;
	}

	/**********
	 * Method : getUsers Description :To get the Users from the database
	 * 
	 * @param user - To get all the users by using userId -
	 * @returns users - returns users
	 * @throws UserServiceException - It is raised when users not found CreatedBy -
	 *                              Tejaswini.T Created Date - 23-MAR-2021
	 **********/

	@Override
	public List<User> getUsers() {
		// TODO Auto-generated method stub
		List<User> users = iUserRepository.findAll();
		if (users.isEmpty()) {
			throw new UserException("Users not found");
		}
		return users;

	}
}