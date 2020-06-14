package com.projectUser.demo.service;

import java.util.List;

import com.projectUser.demo.emtity.User;

public interface UserService {
	
	public List<User> findAll();

	public User save(User user) throws Exception;

}
