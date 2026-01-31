package com.tanay.bookingapp.service;

import org.springframework.stereotype.Service;

import com.tanay.bookingapp.entity.User;
import com.tanay.bookingapp.repository.UserRepository;

@Service
public class UserService {
	private final UserRepository userRepository;
	
	public UserService(UserRepository userRepository) {
		this.userRepository = userRepository;
	}
	
	public User registerUser(User user) {
		User existingUser = userRepository.findByEmail(user.getEmail());
		if(existingUser != null) {
			throw new RuntimeException("Email already registered");
		}
		return userRepository.save(user);
	}
}

