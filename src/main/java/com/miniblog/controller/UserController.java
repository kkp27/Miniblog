package com.miniblog.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.miniblog.model.User;
import com.miniblog.service.UserService;

@Controller
public class UserController {

	@Autowired
	UserService service;

	@RequestMapping(value = { "/", "/login" })
	public ModelAndView login() {
		return new ModelAndView("login");
	}

	 @RequestMapping(value = "/loginerror")
	 public ModelAndView loginerror() {
	 return new ModelAndView("login","error","Invalid username or password");
	 }

	@RequestMapping(value = "/login", method = RequestMethod.POST)
	public ModelAndView loginCheck(@ModelAttribute User user, Model model) {
		User obj = service.findByEmail(user.getEmail());
		if (obj == null) {
			return new ModelAndView("loginerror");
		}
		return new ModelAndView("list", "uname", user.getEmail());
	}

	@RequestMapping(value = "/register")
	public ModelAndView register() {
		return new ModelAndView("register");
	}

	@RequestMapping(value = "/register", method = RequestMethod.POST)
	public ModelAndView registerProcess(@ModelAttribute User user) {
		if (service.findByEmail(user.getEmail()) != null) {
			return new ModelAndView("register", "error", "Email already exists");
		}
		service.save(user);
		return new ModelAndView("login", "message", "Registered successfully");
	}
}
