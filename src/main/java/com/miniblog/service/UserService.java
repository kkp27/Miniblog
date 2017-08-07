package com.miniblog.service;

import com.miniblog.model.User;

public interface UserService  {

	User findUserByEmail(String email);
	
	void saveUser(User user);
}
