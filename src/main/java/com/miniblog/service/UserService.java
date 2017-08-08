package com.miniblog.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.miniblog.model.User;
import com.miniblog.repository.UserRepository;

@Service
public class UserService {

	@Autowired
	UserRepository userrep;
	
	public User findByEmail(String email){
		return userrep.findByEmail(email);
	}
	
	public void save(User user){
		userrep.save(user);
	}
}
