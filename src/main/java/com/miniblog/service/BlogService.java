package com.miniblog.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.miniblog.model.Blog;
import com.miniblog.repository.BlogRepository;

@Service
public class BlogService  {

	@Autowired
	BlogRepository blogrep;
	
	public List<Blog> getAll(){
		List<Blog> blog = blogrep.findAll();
		return blog;
	}
	
	public List<Blog> getByTitle(String title){
		List<Blog> blog = blogrep.findByBlogTitle(title);
		return blog;
	}
	
	public void save(Blog blog){
		blogrep.saveAndFlush(blog);
	}
	
	public void delete(List<Blog> blog){
		blogrep.delete(blog);
	}

}

