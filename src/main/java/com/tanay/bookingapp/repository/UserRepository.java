package com.tanay.bookingapp.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.tanay.bookingapp.entity.User;

public interface UserRepository extends JpaRepository<User,Long> {
	User findByEmail(String email);
}
