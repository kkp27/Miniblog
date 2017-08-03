package com.miniblog.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.miniblog.model.Blog;
import java.lang.String;
import java.util.List;

public interface BlogRepository extends JpaRepository<Blog, String> {

	List<Blog> findByBlogTitle(String blogtitle);
}
