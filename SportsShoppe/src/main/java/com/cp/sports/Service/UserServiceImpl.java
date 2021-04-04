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

@Transactional
@Service
public class UserServiceImpl implements IUserService {

	@Autowired
	IUserRepository repository;

	@Override
	public User addUser(User user) {
		repository.save(user);
		return user;
	}

	@Override
	public User getId(String userID) {
		User user =null;
		try {
			user= repository.findById(userID).get();
		} catch (Exception e) {
			throw new UserException("User with ID: "+userID+" not found!");
		}
		
		return user;
	}

	@Override
	public User updateUser(User user) {
		try {
			getId(user.getUserId());
			repository.saveAndFlush(user);
		} catch (Exception e) {
			 throw new UserException("User Can not be updated!");
		}
		
		return user;
	}


	@Override
	public User deleteUser(String userID) throws UserException {
		 User u = null;
		try {
			u = getId(userID);
			repository.deleteById(userID);
		} catch (Exception e) {
			throw new UserException("User Not Found To Delete!");
		}
		
		return null;
	}

	@Override
	public Boolean signIn(User user) {
		Boolean status = false;
		Optional<User> resultUser = repository.findById(user.getUserId());
		if (!resultUser.isEmpty()) {
			if (resultUser.get().getPassword().equals(user.getPassword())) {
				status = true;
			} else {
				throw new UserException("password not matched");
			}
		} else {
			throw new UserException("User not found");
		}
		return status;

	}

	@Override
	public Boolean signOut(User user) {
		// TODO Auto-generated method stub
		Boolean status = false;
		Optional<User> resultUser = repository.findById(user.getUserId());
		if (!resultUser.isEmpty()) {
			if (resultUser.get().getPassword().equals(user.getPassword())) {
				status = true;
			} else {
				throw new UserException("password not matched");
			}
		} else {
			throw new UserException("User not found");
		}
		return status;
	}
	@Override
	public User changePassword(String id, String oldpassword,String newpassword){
		User changeUser;
		Optional<User> resultUser = repository.findById(id);
		if (!resultUser.isEmpty()) {
			if (resultUser.get().getPassword().equals(oldpassword)) {
				changeUser = new User(id, newpassword, resultUser.get().getRole());
				repository.save(changeUser);
			} else {
				throw new UserException("password not matched");
			}
		} else {
			throw new UserException("User not found");
		}
		return changeUser;
	}
	

	@Override
	public List<User> getUsers() {
		// TODO Auto-generated method stub
		return repository.findAll();
	}

}
