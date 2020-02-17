package com.gongchuangsu.helloweb.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.web.authentication.logout.SecurityContextLogoutHandler;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.gongchuangsu.helloweb.model.Login;
import com.gongchuangsu.helloweb.model.User;
import com.gongchuangsu.helloweb.service.IUserService;

@Controller
public class LoginController {
	@Autowired
	private IUserService userService;
	
//	@RequestMapping(value = "login", method = {RequestMethod.POST,RequestMethod.GET})
//	public void login(){
//		
//	}

	@RequestMapping(value = "login", method = { RequestMethod.POST, RequestMethod.GET })
	public ModelAndView showLogin(HttpServletRequest request, HttpServletResponse response) {
		ModelAndView mav = new ModelAndView("login");
		mav.addObject("login", new Login());
		return mav;
	}
	@RequestMapping(value = "/process_login_custom", method = RequestMethod.POST)
	public String loginProcess(HttpServletRequest request, HttpServletResponse response,
		@ModelAttribute("login") Login login) {
		ModelAndView mav = null;
        UsernamePasswordAuthenticationToken authentication = (UsernamePasswordAuthenticationToken) SecurityContextHolder.getContext().getAuthentication();
		if (userService.validateUser(login)) {
			String role = userService.getAdminPositionByEid(login.getEmployeeId());
			System.out.println(role);
			if(role.equals("admin")) {
				return "redirect:/admin";
			}else {
				return "redirect:/admin";
			}
		} else {
			mav = new ModelAndView("login");
			mav.addObject("message", "Username or Password is wrong!!");
			return "redirect:/login?valid=false";
		}
	}

	

	@RequestMapping(value="/logout", method = RequestMethod.GET)
	public String logoutPage (HttpServletRequest request, HttpServletResponse response) {
	    Authentication auth = SecurityContextHolder.getContext().getAuthentication();
	    if (auth != null){    
	        new SecurityContextLogoutHandler().logout(request, response, auth);
	    }
	    return "redirect:/login";//You can redirect wherever you want, but generally it's a good practice to show login screen again.
	}
	
	@RequestMapping(value="/register", method=RequestMethod.GET)
	public String showRegistrationForm(Model model){
		model.addAttribute(new User());
		return "register";
	}
	
	@RequestMapping(value="/register", method=RequestMethod.POST)
	public String processRegistration(
			@Valid User user, Errors errors){
		if(errors.hasErrors())
			return "register";
		if(userService.userExists(user.getName()))
			return "redirect:/register?userExists=true";
		userService.addUser(user);
		return "redirect:.";
	}
}
