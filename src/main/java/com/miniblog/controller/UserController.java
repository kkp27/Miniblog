package com.miniblog.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
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
		return new ModelAndView("login", "error", "Invalid username or password");
	}

	@RequestMapping(value = "/login", method = RequestMethod.POST)
	public ModelAndView loginCheck(@ModelAttribute User user) {
		User obj = service.findByEmail(user.getEmail());
		if (obj == null) {
			return new ModelAndView("loginerror");
		}
		return new ModelAndView("list/"+user.getUsername());
	}

	@RequestMapping(value = "/register")
	public String register(Model model) {
		model.addAttribute("registration", new User());
		return "register";
	}

	@RequestMapping(value = "/register", method = RequestMethod.POST)
	public ModelAndView registerProcess(@Valid @ModelAttribute("registration") User user, BindingResult result) {
		if (result.hasErrors()) {
			return new ModelAndView("register");
		}

		if (service.findByEmail(user.getEmail()) != null) {
			return new ModelAndView("register", "error1", "Email already exists");
		}
		
		if(! user.getPassword().equals(user.getConfirmPassword())){
			return new ModelAndView("register", "error2" , "Password values do not match");
		}
		service.save(user);
		return new ModelAndView("login", "message", "Registered successfully");
	}
}
