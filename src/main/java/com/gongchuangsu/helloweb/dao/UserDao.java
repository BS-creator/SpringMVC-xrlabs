package com.gongchuangsu.helloweb.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate4.HibernateTemplate;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.gongchuangsu.helloweb.model.Login;
import com.gongchuangsu.helloweb.model.User;
import com.gongchuangsu.helloweb.model.UserRole;

@Transactional
@Repository
public class UserDao implements IUserDao {
	@Autowired
	private HibernateTemplate hibernateTemplate;

	@SuppressWarnings("unchecked")
	@Override
	public List<User> getAllUsers() {
		String hql = "from User as u order by u.id";
		return (List<User>) hibernateTemplate.find(hql);
	}

	@Override
	public User getUserById(int id) {
		return hibernateTemplate.get(User.class, id);
	}

	@Override
	public void addUser(User user) {
		hibernateTemplate.save(user);
//		UserRole userRole = new UserRole();
//		userRole.setUsername(user.getName());
//		userRole.setRole("ROLE_USER");
//		hibernateTemplate.save("UserRole", userRole);
	}

	@Override
	public void updateUser(User user) {
		User u = getUserById(user.getId());
		u.setName(user.getName());
		u.setEid(user.getEid());
		u.setPassword(user.getPassword());
		u.setEmail(user.getEmail());
		hibernateTemplate.update(u);
	}

	@Override
	public void deleteUser(User user) {
		hibernateTemplate.delete(user);
	}

	@Override
	public void deleteUserById(int id) {
		hibernateTemplate.delete(getUserById(id));
	}

	@SuppressWarnings("unchecked")
	@Override
	public boolean userExists(String username) {
		String hql = "from User u where u.username = ?";
		List<User> users = (List<User>) hibernateTemplate.find(hql, username);
		return users.size() > 0 ? true : false;
	}

	@Override
	public void register(User user) {
		// TODO Auto-generated method stub

	}

	@SuppressWarnings("unchecked")
	@Override
	public boolean validateUser(Login login) {
		String hql = "from User where employeeId='" + login.getEmployeeId() + "' and password='"+login.getPassword()+"'";
		List<User> users = (List<User>) hibernateTemplate.find(hql);
		if(users.size() == 0) {
			return false;
		}else {
			System.out.println(users.get(0).getName());
		}
		return true;
		
	}

	@Override
	public User getUserByUsername(String username) {
		// TODO Auto-generated method stub
		String hql = "from User u where u.username = ?";
		List<User> users = (List<User>) hibernateTemplate.find(hql, username);
		return users.size() > 0 ? users.get(0) : null;
	}

	@SuppressWarnings("unchecked")
	@Override
	public String getAdminPositionByEid(String eid) {
		// TODO Auto-generated method stub
		String hql = "from User u where u.eid='"+eid+"'";
		List<User> users = (List<User>) hibernateTemplate.find(hql);
		return users.size() > 0 ? users.get(0).getAdmin_position() : null;
	}

	@SuppressWarnings("unchecked")
	@Override
	public String getPasswordByEmail(String email) {
		String hql = "from User u where u.email='"+email+"'";
		List<User> users = (List<User>) hibernateTemplate.find(hql);
		System.out.println(users.size());
		return users.size() > 0 ? users.get(0).getPassword() : null;
	}
}
