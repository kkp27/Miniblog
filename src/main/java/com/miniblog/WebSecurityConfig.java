package com.miniblog;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

import com.miniblog.service.UserDetailsServiceImpl;

//@Configuration
//@EnableWebSecurity
public class WebSecurityConfig extends WebSecurityConfigurerAdapter {
	
//	@Bean
//	public BCryptPasswordEncoder passwordEncoder(){
//		return new BCryptPasswordEncoder();
//	}
	
//	@Autowired
//	UserDetailsServiceImpl userdetail;
	
	@Override
	    protected void configure(HttpSecurity http) throws Exception {
	        http
	            .authorizeRequests()
	            	.antMatchers("/register").permitAll()
	                .antMatchers("/blog/list/","/blog/edit/").permitAll()
	                .anyRequest().authenticated().and()
	            .formLogin()
	                .loginPage("/login")
//	                .usernameParameter("email")
//	                .passwordParameter("password")
	                .permitAll()
	                .and()
	            .logout()	
	            .permitAll();
	        http.headers().frameOptions().disable();
	    }

	    @Autowired
	    public void configAuthentication(AuthenticationManagerBuilder auth) throws Exception {
//	    	auth
//	    	.userDetailsService(userdetail);
	    }
}

