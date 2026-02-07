package com.tanay.bookingapp.controller;

import jakarta.servlet.http.HttpServletRequest;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/test")
public class TestSecureController {

@GetMapping("/secure")
public String secure(HttpServletRequest request) {

Object userId = request.getAttribute("userId");

if(userId == null) {
return "Unauthorized - No JWT token";
}

return "Access granted. User ID = " + userId;
}
}
