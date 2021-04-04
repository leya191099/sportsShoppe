package com.cp.sports.Service;

import java.util.List;

import com.cp.sports.Entity.User;

public interface IUserService {

	public User addUser(User user);

	public User updateUser(User user);

	public Boolean signIn(User user) ;
	public Boolean signOut(User user);
	public User changePassword(String id, String oldpassword,String newpassword);	


	public User deleteUser(String userID);

	public User getId(String userID);

	public List<User> getUsers();

}
