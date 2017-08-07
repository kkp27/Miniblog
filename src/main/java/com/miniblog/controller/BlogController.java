package com.miniblog.controller;

import java.io.IOException;
import java.time.LocalDate;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
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

	@RequestMapping(value = "/blog/list", method = RequestMethod.GET)
	public ModelAndView getAll() {
		List<Blog> blog = service.getAll();
		return new ModelAndView("list", "blog", blog);
	}

	@RequestMapping(value = "/blog/create", method = RequestMethod.GET)
	public ModelAndView create() {
		return new ModelAndView("create");
	}

	@RequestMapping(value = "/blog/list/{title}", method = RequestMethod.GET)
	public ModelAndView findByTitle(@PathVariable("title") String title) {
		List<Blog> blog = service.getByTitle(title);
		return new ModelAndView("list", "blog", blog);
	}

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
		return new ModelAndView("edit", "blog", blog);
	}

	@RequestMapping(value = "/blog/update/{id}", method = RequestMethod.POST)
	public String update(@ModelAttribute Blog blog, @PathVariable("id") Integer id) throws IOException {
		Blog obj = service.getOneById(id);
//		System.out.println(blog);
//		System.out.println(id);
		obj.setBlogTitle(blog.getBlogTitle());
		obj.setBlogPost(blog.getBlogPost());
		obj.setLastModifiedDate(LocalDate.now());
		service.save(obj);
		return "redirect:/blog/list";
	}

	@RequestMapping(value = "/blog/delete/{title}")
	public String delete(@PathVariable("title") String title) throws IOException {
		List<Blog> blog = service.getByTitle(title);
		service.delete(blog);
		return "redirect:/blog/list";
	}

	@RequestMapping(value = "/blog/logout", method=RequestMethod.POST)
	public ModelAndView signout() {
		String message = "You have been logged out successfully";
		return new ModelAndView("login","message",message);
	}
}
