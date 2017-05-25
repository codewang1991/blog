package com.user.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.data.domain.Sort.Direction;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.user.dao.UserRepository;
import com.user.domain.MyPage;
import com.user.domain.User;
import com.user.service.UserService;

@Service
public class UserServiceImpl implements UserService{
	@Autowired
	private UserRepository userRepository;
    
	@Transactional
	public User regUser(User user) {
		try{
			user=userRepository.save(user);
		}catch(Exception e){
			e.printStackTrace();
		}
		return user;
	}

	@Override
	public User getUserById(String userId) {
		User user=null;
		try {
			user=userRepository.getUserById(userId);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return user;
	}

	@Override
	public MyPage getAllUserByPage(Integer currentPage, Integer pageSize) {
		 MyPage myPage=null;
		try{
		  Page<User> page=userRepository.findAll(new PageRequest(currentPage-1, pageSize,new Sort(Direction.DESC, "createTime")));
		  myPage=new MyPage(page.getContent(),page.getTotalPages(),page.getTotalElements(),page.getSize(),currentPage);
		}catch(Exception e){
			e.printStackTrace();
		}
		return myPage;
	}

	@Override
	public MyPage getUserByName(String userName, Integer currentPage, Integer pageSize) {
		 MyPage myPage=null;
		 try{
			Page<User> page=userRepository.findUserByUserName(userName,new PageRequest(currentPage-1, pageSize,new Sort(Direction.DESC, "createTime")));
			myPage=new MyPage(page.getContent(),page.getTotalPages(),page.getTotalElements(),page.getSize(),currentPage);
		 }catch(Exception e){
			 e.printStackTrace();
		 }
		return myPage;
	}

	@Override
	public void delUser(String id) {
		try{
			userRepository.delUser(id);
		}catch(Exception e){
			e.printStackTrace();
		}
		
	}

	@Override
	public MyPage getAllUsers(Integer currentPage, Integer pageSize) {
		 MyPage myPage=null;
			try{
			  Page<User> page=userRepository.getAllUsers(new PageRequest(currentPage-1, pageSize,new Sort(Direction.DESC, "createTime")));
			  myPage=new MyPage(page.getContent(),page.getTotalPages(),page.getTotalElements(),page.getSize(),currentPage);
			}catch(Exception e){
				e.printStackTrace();
			}
			return myPage;
	}

	

}
