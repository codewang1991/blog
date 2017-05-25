package com.user.service;

import org.springframework.stereotype.Repository;

import com.user.domain.MyPage;
import com.user.domain.User;
@Repository
public interface UserService {

	public User regUser(User user);
	public User getUserById(String userId);
	public MyPage getAllUserByPage(Integer currentPage,Integer pageSize);
	public MyPage getUserByName(String userName,Integer currentPage,Integer pageSize);
	public void delUser(String id);
	public MyPage getAllUsers(Integer currentPage,Integer pageSize);
}
