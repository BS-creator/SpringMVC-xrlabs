package com.gongchuangsu.helloweb.service;

import java.util.List;

import com.gongchuangsu.helloweb.model.Login;
import com.gongchuangsu.helloweb.model.User;

public interface IUserService {
	User getUserById(int id);
	String getAdminPositionByEid(String eid);
	String getPasswordByEmail(String email);
	List<User> getAllUsers();
	void addUser(User user);
	boolean userExists(String username);
	boolean validateUser(Login login);
	void updateUser(User user);
	void deleteUserById(int id);
}
