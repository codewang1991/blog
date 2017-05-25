package com.system.ribbon.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.system.ribbon.bean.MyPage;
import com.system.ribbon.bean.User;
@Service
public class RibbonService {
    
	@Autowired
	private RestTemplate restTemplate;
	
	public User regUser(User u){
		return restTemplate.postForObject("http://SERVICE-USER/user/add/user", u, User.class);
	} 
	
	public User queryUser(String id){
		return restTemplate.getForObject("http://SERVICE-USER/user/get/user/"+id, User.class);
	} 
	
	public MyPage queryUserByName(String name,int currentPage,int pageSize){
		return restTemplate.getForObject("http://SERVICE-USER/user/get/user?name="+name+
				"&currentPage="+currentPage+"&pageSize="+pageSize, MyPage.class);
	} 
	
	public MyPage getAllUsers(int currentPage,int pageSize){
		return restTemplate.getForObject("http://SERVICE-USER/user/get/users?currentPage="+currentPage+
				"&pageSize="+pageSize, MyPage.class);
	} 
	
	public void delUser(String id){
		restTemplate.delete("http://SERVICE-USER/user/del/user?id="+id);
	}
	
}
