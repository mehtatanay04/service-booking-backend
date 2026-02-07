package com.tanay.bookingapp.security;

import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import org.springframework.web.filter.OncePerRequestFilter;

import io.jsonwebtoken.Claims;

import java.io.IOException;

public class JwtAuthFilter extends OncePerRequestFilter {

@Override
protected void doFilterInternal(
HttpServletRequest request,
HttpServletResponse response,
FilterChain filterChain
) throws ServletException, IOException {

String authHeader = request.getHeader("Authorization");

if(authHeader != null && authHeader.startsWith("Bearer ")) {

String token = authHeader.substring(7);
Claims claims = JwtUtil.validateToken(token);

if(claims != null) {
// Token is valid
request.setAttribute("userId", claims.get("id"));
request.setAttribute("role", claims.get("role"));
}
}

filterChain.doFilter(request, response);
}
}
