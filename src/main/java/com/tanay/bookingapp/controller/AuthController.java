package com.tanay.bookingapp.controller;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.tanay.bookingapp.dto.UserResponseDTO;
import com.tanay.bookingapp.entity.User;
import com.tanay.bookingapp.service.UserService;

@RestController
@RequestMapping("/api/auth")
public class AuthController {
	private final UserService userService;
	public AuthController (UserService userService) {
		this.userService = userService;
		}
	
	@PostMapping("/register")
	public UserResponseDTO register(@RequestBody User user) {
		User savedUser = userService.registerUser(user);
		
		return new UserResponseDTO(
				savedUser.getId(),
				savedUser.getName(),
				savedUser.getEmail(),
				savedUser.getRole()
				);
	}
	
}
