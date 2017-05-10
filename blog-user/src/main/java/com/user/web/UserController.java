package com.user.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.user.dao.UserRepository;
import com.user.domain.User;
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
	@GetMapping(value="/get")
	public User login(@RequestParam String id){
		User u=userRepository.getUserById(id);
		if(u!=null){
			System.out.println("查询成功。。。。。。。。。"+u.getUserName());
		}
		return u;
	}
}
