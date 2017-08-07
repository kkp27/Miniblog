package com.miniblog.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.miniblog.model.User;
import com.miniblog.repository.UserRepository;

@Service
public class UserServiceImpl implements UserService {

	@Autowired
	UserRepository userrep;
	
//	@Autowired
//	BCryptPasswordEncoder bcryptpwd;
	
	@Override
	public User findUserByEmail(String email) {
		return userrep.findByEmail(email);
	}

	@Override
	public void saveUser(User user) {
	//	user.setPassword(bcryptpwd.encode(user.getPassword()));
		userrep.save(user);
	}

}
