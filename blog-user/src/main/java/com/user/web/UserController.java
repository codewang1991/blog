package com.user.web;
import java.util.Date;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.user.domain.MyPage;
import com.user.domain.User;
import com.user.service.UserService;
@RestController
public class UserController {
	@Autowired
	private UserService userService;
	
	private Logger log=Logger.getLogger(UserController.class);
	/**
	 * 注册用户
	 * @param user
	 * @return
	 */
	@PostMapping(value="/add/user")
	public User reg(@RequestBody User user){
		user.setCreateTime(new Date());
		user=userService.regUser(user);
		return user;
	}
	@GetMapping(value="/get/user/{id}")
	public User getUser(@PathVariable String id){
		User u=userService.getUserById(id);
		return u;
	}
	@GetMapping(value="/get/users")
	public MyPage userList(@RequestParam(name="currentPage",defaultValue="1",required=false)Integer currentPage,
			@RequestParam(name="pageSize",defaultValue="10",required=false)Integer pageSize){
		
		return userService.getAllUsers(currentPage, pageSize);
	}
	@GetMapping(value="/get/user")
	public MyPage queryByUserName(@RequestParam(name="name") String userName,
			@RequestParam(name="currentPage",defaultValue="1",required=false)Integer currentPage,
			@RequestParam(name="pageSize",defaultValue="10",required=false)Integer pageSize){
		return userService.getUserByName(userName, currentPage, pageSize);
	}
	@GetMapping(value="/del/user")
	public void delUser(@RequestParam(name="id")String id){
		userService.delUser(id);
	}
}
