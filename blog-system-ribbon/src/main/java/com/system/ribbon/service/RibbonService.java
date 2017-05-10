package com.system.ribbon.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

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
	
}
