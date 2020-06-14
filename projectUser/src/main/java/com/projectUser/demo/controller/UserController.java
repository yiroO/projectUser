package com.projectUser.demo.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
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

	@GetMapping({ "/", "login" })
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

	@PostMapping("/userform")
	public String createUser(@ModelAttribute("userForm") User user, BindingResult result, ModelMap model) {

		if (user.getFirstName().isEmpty() && user.getLastName().isEmpty() && user.getUserName().isEmpty()
				&& user.getPassword().isEmpty()) {
			model.addAttribute("msje", "El formulario no acepta campos vacios");
			model.addAttribute("userForm", user);
			model.addAttribute("formTab", "active");
		} else {
			try {
				userservice.save(user);
				model.addAttribute("userForm", new User());
				model.addAttribute("listTab", "active");
			} catch (Exception e) {
				model.addAttribute("errorMessage", e.getMessage());
				model.addAttribute("userForm", user);
				model.addAttribute("formTab", "active");
				model.addAttribute("userList", userservice.findAll());
				model.addAttribute("roles", rolrepository.findAll());
			}
		}

		model.addAttribute("userList", userservice.findAll());
		model.addAttribute("roles", rolrepository.findAll());

		return "user-form/user-view";
	}
}
