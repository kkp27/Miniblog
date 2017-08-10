package com.miniblog.controller;

import java.io.IOException;
import java.time.LocalDate;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.miniblog.model.Blog;
import com.miniblog.service.BlogService;

@Controller
public class BlogController {
	
	@Autowired
	BlogService service;

	@RequestMapping(value = "/blog/list/{username}", method = RequestMethod.GET)
	public ModelAndView getAllUSer(@PathVariable("username") String username) {
		System.out.println(username);
		List<Blog> blog = service.getAllByUser(username);
		if(blog == null){
			String message = "No content !!";
			return new ModelAndView("list", "message", message);
		}
		return new ModelAndView("list", "blog", blog);
	}

	@RequestMapping(value = "/blog/create", method = RequestMethod.GET)
	public ModelAndView create() {
		return new ModelAndView("create");
	}

//	@RequestMapping(value = "/blog/list/{title}", method = RequestMethod.GET)
//	public ModelAndView findByTitle(@PathVariable("title") String title) {
//		System.out.println(title);
//		List<Blog> blog = service.getByTitle(title);
//		if(blog == null){
//			String message = "No record found";
//			return new ModelAndView("list", "message", message);
//		}
//		return new ModelAndView("list", "blog", blog);
//	}

	@RequestMapping(value = "/blog/save", method = RequestMethod.POST)
	public String save(@ModelAttribute Blog blog) throws IOException {
		blog.setCreatedDate(LocalDate.now());
		blog.setLastModifiedDate(LocalDate.now());
		service.save(blog);
		return "redirect:/blog/list";
	}

	@RequestMapping(value = "/blog/edit/{title}")
	public ModelAndView edit(@PathVariable("title") String title) {
		List<Blog> blog = service.getByTitle(title);
		if(blog == null){
			String message = "Error !!";
			return new ModelAndView("list", "message", message);
		}
		return new ModelAndView("edit", "blog", blog);
	}

	@RequestMapping(value = "/blog/update/{id}", method = RequestMethod.POST)
	public String update(@ModelAttribute Blog blog, @PathVariable("id") Integer id, Model model) throws IOException {
		Blog obj = service.getOneById(id);
		if(obj == null){
			model.addAttribute("message", "Error !!");
			return "redirect:/blog/list";
		}
		obj.setBlogTitle(blog.getBlogTitle());
		obj.setBlogPost(blog.getBlogPost());
		obj.setLastModifiedDate(LocalDate.now());
		service.save(obj);
		return "redirect:/blog/list";
	}

	@RequestMapping(value = "/blog/delete/{title}")
	public String delete(@PathVariable("title") String title, Model model) throws IOException {
		List<Blog> blog = service.getByTitle(title);
		if(blog == null){
			model.addAttribute("message", "No record found");
			return "redirect:/blog/list";
		}
		service.delete(blog);
		return "redirect:/blog/list";
	}

	@RequestMapping(value = "/blog/logout", method=RequestMethod.POST)
	public ModelAndView signout() {
		String message = "You have been logged out successfully";
		return new ModelAndView("login","message",message);
	}
}
