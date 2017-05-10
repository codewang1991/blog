package com.user.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.annotations.GenericGenerator;

@Entity
@Table(name="t_blog_user")
public class User {
	
	@Id
	@GenericGenerator(name="idGenerator", strategy="uuid") 
    @GeneratedValue(generator="idGenerator")
    private String id;
    @Column(name="user_name",nullable = false)
    private String userName;
    @Column(name="user_pwd")
    private String userPwd;

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getUserPwd() {
		return userPwd;
	}

	public void setUserPwd(String userPwd) {
		this.userPwd = userPwd;
	}
    
    

}
