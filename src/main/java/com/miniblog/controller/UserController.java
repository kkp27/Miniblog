package com.miniblog.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.miniblog.model.User;
import com.miniblog.repository.UserRepository;
import com.miniblog.service.UserService;

@Controller
public class UserController {

	@Autowired
	UserRepository userrep;

	@RequestMapping(value = { "/", "/login" }, method = RequestMethod.GET)
	public String login() {
		return "login";
	}

	@RequestMapping(value = "/login", method = RequestMethod.POST)
	public String loginCheck(@ModelAttribute User user, Model model, @RequestParam("error") String error) {
		User obj = userrep.findByEmail(user.getEmail());
		if (obj == null || error == null) {
			model.addAttribute("error", "Invalid username or password");
			return "redirect:/login";
		}
		return "redirect:/list";
	}

	@RequestMapping(value = "/register", method = RequestMethod.GET)
	public String register() {
		return "register";
	}

	@RequestMapping(value = "/register", method = RequestMethod.POST)
	public String registerProcess(User user, Model model) {
		User obj = userrep.findByEmail(user.getEmail());
		if (obj != null) {
			model.addAttribute("error", "Email already exists");
			return "redirect:/register";
		}
		userrep.save(obj);
		model.addAttribute("message", "Registered successfully");
		return "redirect:/login";
	}
}
