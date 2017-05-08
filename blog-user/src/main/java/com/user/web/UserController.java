package com.user.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.user.domain.User;
import com.user.domain.UserRepository;
@RestController
public class UserController {
	
	@Autowired
	private UserRepository userRepository;
	
	/**
	 * 注册用户
	 * @param user
	 * @return
	 */
	@PostMapping(value="/add")
	public User reg(@RequestBody User user){
		user=userRepository.save(user);
		return user;
	}
}
