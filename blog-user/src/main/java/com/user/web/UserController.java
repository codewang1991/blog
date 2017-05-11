package com.user.web;
import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.data.domain.Sort.Direction;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.user.dao.UserRepository;
import com.user.domain.MyPage;
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
	@PostMapping(value="/add/user")
	public User reg(@RequestBody User user){
		user.setCreateTime(new Date());
		user=userRepository.save(user);
		return user;
	}
	@GetMapping(value="/get/user/{id}")
	public User login(@PathVariable String id){
		User u=userRepository.getUserById(id);
		return u;
	}
	@GetMapping(value="/get/users")
	public MyPage userList(@RequestParam(name="currentPage",defaultValue="1",required=false)Integer currentPage,
			@RequestParam(name="pageSize",defaultValue="10",required=false)Integer pageSize){
		Page<User> page=userRepository.findAll(new PageRequest(currentPage-1, pageSize,new Sort(Direction.DESC, "createTime")));
		
		return new MyPage(page.getContent(),page.getTotalPages(),page.getTotalElements(),page.getSize(),currentPage);
	}
	@GetMapping(value="/get/user")
	public MyPage queryByUserName(@RequestParam(name="name") String userName,
			@RequestParam(name="currentPage",defaultValue="1",required=false)Integer currentPage,
			@RequestParam(name="pageSize",defaultValue="10",required=false)Integer pageSize){
		Page<User> page=userRepository.findUserByUserName(userName,new PageRequest(currentPage-1, pageSize,new Sort(Direction.DESC, "createTime")));
		return new MyPage(page.getContent(),page.getTotalPages(),page.getTotalElements(),page.getSize(),currentPage);
	}
}
