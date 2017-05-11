package com.user.dao;



import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

import com.user.domain.User;

public interface UserRepository extends JpaRepository<User, String> {
		
	public User getUserById(String id);
	
	public Page<User> findAll(Pageable pageable );
	
	public Page<User> findUserByUserName(String userName,Pageable pageable);
	
}
