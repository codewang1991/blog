package com.user.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.user.domain.User;

public interface UserRepository extends JpaRepository<User, String> {
		
	public User getUserById(String id);
}
