package com.miniblog.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.miniblog.model.Blog;

public interface BlogRepository extends JpaRepository<Blog, String> {

	List<Blog> findByBlogTitle(String blogtitle);

//	@Modifying
//	@Query("delete from blog where blogTitle=?")
	void delete(String title);
	
}
