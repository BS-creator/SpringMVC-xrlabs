package com.gongchuangsu.helloweb.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.gongchuangsu.helloweb.dao.IUserDao;
import com.gongchuangsu.helloweb.model.Login;
import com.gongchuangsu.helloweb.model.User;

@Service
public class UserService implements IUserService{
	@Autowired
	private IUserDao userDao;
	
	@Override
	public User getUserById(int id) {
		User user = userDao.getUserById(id);
		return user;
	}

	@Override
	public List<User> getAllUsers() {
		return userDao.getAllUsers();
	}

	@Override
	public void addUser(User user) {
		userDao.addUser(user);
	}

	@Override
	public boolean userExists(String username) {
		return userDao.userExists(username);
	}

	@Override
	public void updateUser(User user) {
		userDao.updateUser(user);
	}

	@Override
	public void deleteUserById(int id) {
		userDao.deleteUserById(id);
	}
	
	@Override
	public boolean validateUser(Login login) {
		return userDao.validateUser(login);
	}

	@Override
	public String getAdminPositionByEid(String eid) {
		return userDao.getAdminPositionByEid(eid);
	}

	@Override
	public String getPasswordByEmail(String email) {
		return userDao.getPasswordByEmail(email);
	}

}
