package com.cos.beacon.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.cos.beacon.model.User;

public interface UserRepository extends JpaRepository<User, Integer>{
	
	public User findByUsernameAndPassword(String username, String password);
	
	public User findByUsername(String username);
	
	public User findByPassword(String password);
}
