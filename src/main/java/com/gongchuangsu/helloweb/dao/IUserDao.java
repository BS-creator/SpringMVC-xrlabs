package com.gongchuangsu.helloweb.dao;

import java.util.List;

import com.gongchuangsu.helloweb.model.Login;
import com.gongchuangsu.helloweb.model.User;

public interface IUserDao {
	List<User> getAllUsers();
	User getUserById(int id);
	void addUser(User user);
	void updateUser(User user);
	void deleteUser(User user);
	void deleteUserById(int id);
	boolean userExists(String username);
	void register(User user);
	boolean validateUser(Login login);
	User getUserByUsername(String username);
	String getAdminPositionByEid(String eid);
	String getPasswordByEmail(String email);
}
