package com.system.ribbon.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.system.ribbon.bean.User;
import com.system.ribbon.service.RibbonService;

@RestController
public class RibbonController {
	
	@Autowired
	RibbonService ribbonService;
	
	
	@ResponseBody
	@PostMapping(value="/user")
	public User regUser(@RequestBody User u){
		return ribbonService.regUser(u);
	}

	@ResponseBody
	@GetMapping(value="/user/{id}")
	public User queryUser(@PathVariable String id){
		User u=ribbonService.queryUser(id);
		if(u!=null){
			System.out.println("成功。。。。。。。。。。。。。。。。。。。。。。。。。。。。。。。。"+u.getUserName());
		}
		return u;
	}
}
