package com.miniblog.controller;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.miniblog.model.Blog;
import com.miniblog.repository.BlogRepository;

@Controller
public class BlogController {

	private static final SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");

	@Autowired
	BlogRepository blogrep;

	@RequestMapping(value = { "/", "/blog/list" }, method = RequestMethod.GET)
	public ModelAndView findAll() {
		List<Blog> blog = blogrep.findAll();
		return new ModelAndView("list", "blog", blog);
	}

	@RequestMapping(value = "/blog/create", method = RequestMethod.GET)
	public ModelAndView create() {
		return new ModelAndView("create");
	}

	@RequestMapping(value = "/blog/list/{title}", method = RequestMethod.GET)
	public ModelAndView findByTitle(@PathVariable("title") String title) {
		List<Blog> blog = blogrep.findByBlogTitle(title);
		return new ModelAndView("list", "blog", blog);
	}

	@RequestMapping(value = "/blog/save", method = RequestMethod.POST)
	public void save(@ModelAttribute Blog blog, HttpServletResponse response) throws IOException {
		blog.setCreatedDate(sdf.format(new Date()));
		blog.setLastModifiedDate(sdf.format(new Date()));
		blogrep.save(blog);
		response.sendRedirect("/blog/list");
	}

	@RequestMapping(value = "/blog/edit/{title}")
	public ModelAndView edit(@PathVariable("title") String title) {
		List<Blog> blog = blogrep.findByBlogTitle(title);
		return new ModelAndView("edit", "blog", blog);
	}

	@RequestMapping(value = "/blog/update", method = RequestMethod.POST)
	public void update(@ModelAttribute Blog blog, HttpServletResponse response) throws IOException {
			Blog obj = blogrep.findOne(blog.getBlogTitle());
			obj.setBlogTitle(blog.getBlogTitle());
			obj.setBlogAuthor(blog.getBlogAuthor());
			obj.setBlogPost(blog.getBlogPost());
			obj.setCreatedDate(blog.getCreatedDate());
			obj.setLastModifiedDate(sdf.format(new Date()));
			blogrep.save(obj);
			response.sendRedirect("/blog/list");
	}

	@RequestMapping(value = "/blog/delete/{title}")
	public void delete(@PathVariable("title") String title, HttpServletResponse response) throws IOException {
		List<Blog> blog = blogrep.findByBlogTitle(title);
		blogrep.delete(blog);
		response.sendRedirect("/blog/list");
	}

	@RequestMapping(value = "/blog/logout", method=RequestMethod.POST)
	public ModelAndView signout() {
		return new ModelAndView("login");
	}
}
