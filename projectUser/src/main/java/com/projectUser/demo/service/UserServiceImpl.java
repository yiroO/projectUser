package com.projectUser.demo.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.projectUser.demo.emtity.User;
import com.projectUser.demo.repository.UserRepository;

@Service
public class UserServiceImpl implements UserService {

	@Autowired
	private UserRepository userRepository;

	@Override
	public List<User> findAll() {
		return (List<User>) userRepository.findAll();
	}
	
	private boolean checkUsernameAviable(User user) throws Exception {
		Optional<User> userfound = userRepository.findByUserName(user.getUserName());
		
		if(userfound.isPresent()) {
			throw new Exception("El usario ya se encuentra registrado ");
		}
		return true;

	}
	
	private boolean checkPasswordValid(User user) throws Exception {
		if(!user.getPassword().equals(user.getConfirmPassword())) {
			throw new Exception("Passwird y ConfirmaPassword, no son iguales");
		}
		return true;	
	}

	@Override
	public User save(User user) throws Exception {
		if(checkUsernameAviable(user) && checkPasswordValid(user)) {
			user = userRepository.save(user);
		}
		return user;
	}
}
