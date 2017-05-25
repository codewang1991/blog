package com.user.dao;



import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;

import com.user.domain.User;

public interface UserRepository extends JpaRepository<User, String> {
		
	public User getUserById(String id);
	
	public Page<User> findAll(Pageable pageable );
	
	public Page<User> findUserByUserName(String userName,Pageable pageable);
	
	@Transactional
	@Modifying
	@Query("update User a set a.delFlag=1 where a.id=:id")
	public void delUser(@Param("id")String id);
	
	@Query("from User a where a.delFlag=0")
	public Page<User> getAllUsers(Pageable pageable);
}
