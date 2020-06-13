package com.projectUser.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.projectUser.demo.emtity.User;
import com.projectUser.demo.repository.RoleRepository;
import com.projectUser.demo.service.UserService;

@Controller
public class UserController {
	
	@Autowired
	private UserService userservice;
	
	@Autowired
	private RoleRepository rolrepository;

	@GetMapping({"/", "login"})
	public String login() {
		return "index";
	}
	
	@GetMapping("/userform")
	public String formUser(Model model) {
		
		model.addAttribute("userForm", new User());
		model.addAttribute("userList", userservice.findAll());
		model.addAttribute("roles", rolrepository.findAll());
		model.addAttribute("listTab", "active");	
		
		return "user-form/user-view";
	}
}
