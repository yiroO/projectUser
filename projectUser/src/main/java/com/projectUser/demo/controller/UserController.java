package com.projectUser.demo.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@Controller
public class UserController {

	@GetMapping({"/", "login"})
	public String login() {
		return "index";
	}
	
	@GetMapping("/userform")
	public String formUser() {
		return "user-form/user-view";
	}
}
