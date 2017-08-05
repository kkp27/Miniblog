package com.miniblog.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.miniblog.model.User;
import com.miniblog.repository.UserRepository;

@Controller
public class UserController {

	@Autowired
	UserRepository userrep;

	@RequestMapping(value = "/login")
	public String login() {
		return "login";
	}

	@RequestMapping(value = "/login", method = RequestMethod.POST)
	public ModelAndView loginCheck(@ModelAttribute User user) {
		User obj = userrep.findByEmail(user.getEmail());
		if (obj == null) {
			String error = "Invalid username or password";
			return new ModelAndView("login", "error", error);
		}
		return new ModelAndView("list");
	}

	@RequestMapping(value = "/register")
	public String register() {
		return "register";
	}

	@RequestMapping(value = "/register", method = RequestMethod.POST)
	public ModelAndView registerProcess(@ModelAttribute User user) {
		User obj = userrep.findByEmail(user.getEmail());
		if (obj != null) {
			String error = "Email already exists";
			return new ModelAndView("register", "error", error);
		}
		userrep.save(user);
		String message = "Registered successfully";
		return new ModelAndView("login", "message", message);
	}
}
