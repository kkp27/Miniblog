package com.miniblog.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.miniblog.model.Blog;

public interface BlogRepository extends JpaRepository<Blog, String> {

	List<Blog> findByBlogTitle(String title);
	
}
