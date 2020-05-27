package com.gongchuangsu.helloweb.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;

import com.gongchuangsu.helloweb.model.User;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;

import com.gongchuangsu.helloweb.service.IEmailService;
import com.gongchuangsu.helloweb.service.ISessionService;
// import com.gongchuangsu.helloweb.service.IUserService;

@Controller
public class AdminController {
	@Autowired
	private IUserService userService;

	@Autowired
	private IEmailService emailService;

	@RequestMapping(value = "/admin", method = RequestMethod.GET)
	public String admin(Model model) {

		List<User> users = userService.getAllUsers();
		model.addAttribute("users", users);
		return "admin";
	}

	@RequestMapping(value = "/api/get_all_users", method = RequestMethod.GET)
	public String get_all_users(Model model) {

		List<User> users = userService.getAllUsers();
		model.addAttribute("users", users);
		return "admin";
	}

	@RequestMapping(value = "/add_admin", method = RequestMethod.GET)
	public String add_admin(Model model) {
		model.addAttribute("user", new User());
		return "add_admin";
	}

	@RequestMapping(value = "/edit_admin/{id}", method = RequestMethod.GET)
	public String edit_admin(@PathVariable int id, Model model) {
		User user = userService.getUserById(id);
		model.addAttribute("user", user);
		return "edit_admin";
	}

	@RequestMapping(value = "/delete_admin/{id}", method = RequestMethod.GET)
	public String delete_admin(@PathVariable int id, Model model) {
		userService.deleteUserById(id);
		return "redirect:/admin";
	}

	@CrossOrigin
	@RequestMapping(value = "/editsave", method = { RequestMethod.POST, RequestMethod.PUT })
	public String edit_save(@ModelAttribute("user") User user) {
		userService.updateUser(user);
		return "redirect:/admin";
	}

	@CrossOrigin
	@RequestMapping(value = "/adminsave", method = { RequestMethod.POST, RequestMethod.PUT })
	public String admin_save(@ModelAttribute("user") User user) {
		user.setAdmin_position("ROLE_admin");
		user.setEnabled(1);
		userService.addUser(user);
		return "redirect:/admin";
	}

	@CrossOrigin
	@RequestMapping(value = "/handle_resetpassword", method = RequestMethod.POST)
	public String handle_resetpassword(HttpServletRequest request, HttpServletResponse response) {
		String email=request.getParameter("email");
		String password = userService.getPasswordByEmail(email);
		System.out.println(password);
		emailService.sendMail(email);
		return "redirect:/login?password="+password+"";
	}
}
