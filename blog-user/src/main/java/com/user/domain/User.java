package com.user.domain;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

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
    
	@Column(name="pet_name")
	private String petName;
	
	@Column(name="create_time")
	@Temporal(TemporalType.TIMESTAMP) 
    private Date createTime;
	
	@Column(name="update_time")
	@Temporal(TemporalType.TIMESTAMP) 
	private Date updateTime;
	
	@Column(name="del_flag")
	private Integer delFlag=0;
	
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

	public Date getCreateTime() {
		
		return createTime;
	}

	public void setCreateTime(Date createTime) {
		
		this.createTime = createTime;
	}

	public String getPetName() {
		return petName;
	}

	public void setPetName(String petName) {
		this.petName = petName;
	}

	public Date getUpdateTime() {
		return updateTime;
	}

	public void setUpdateTime(Date updateTime) {
		this.updateTime = updateTime;
	}

	public Integer getDelFlag() {
		if(null==delFlag){
			delFlag=0;
		}
		return delFlag;
	}

	public void setDelFlag(Integer delFlag) {
		if(null==delFlag){
			delFlag=0;
		}
		this.delFlag = delFlag;
	}
    
    

}
