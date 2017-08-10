package com.miniblog.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.miniblog.model.Blog;

@Repository
public interface BlogRepository extends JpaRepository<Blog, Integer> {

	List<Blog> findByBlogTitle(String title);
	
	@Query("select b from Blog b where b.blogAuthor=:username")	
	List<Blog> findAllByUSer(@Param("username") String username);
	
}
