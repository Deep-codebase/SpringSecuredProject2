package com.deep.spring.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.deep.spring.dao.UserDAO;
import com.deep.spring.entity.AuthUser;
import com.deep.spring.service.RegisterService;

@Controller
@RequestMapping("/")
public class WelcomeController {

	@Autowired
	private UserDAO userDAO;
	
	@Autowired
	private RegisterService registerService;

	@GetMapping("/login")
	public String showlogin() {
		return "login";
	}

	
	@GetMapping("/checkuser")
	public String getUserDet() {
		System.out.println("user check");
		AuthUser user = userDAO.loadByEmail("admin@gmail.com");
		System.out.println(user.getName() + " " + user.getLastname());
		return "";
	}

	@GetMapping("/register")
	public String registerUser(Model theModel) {
		AuthUser auser = new AuthUser();
		theModel.addAttribute("createnewUser", auser);
		return "register";
	}

	@PostMapping("/registerUser")
	public String saveUser(@ModelAttribute("createnewUser") AuthUser newuser, Model model) {
		System.out.println(newuser.getName() + " "+ newuser.getEmail());
		registerService.saveUser(newuser);
		model.addAttribute("registersuccess", "Registration Successful!");
		return "register";
	}
}
