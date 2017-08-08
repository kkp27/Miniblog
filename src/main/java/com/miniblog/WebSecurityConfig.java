package com.miniblog;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

import com.miniblog.service.AuthenticationService;

@Configuration
@EnableWebSecurity
public class WebSecurityConfig extends WebSecurityConfigurerAdapter {

	@Autowired
	AuthenticationService usercheck;

	@Override
	protected void configure(HttpSecurity http) throws Exception {
		http
		.csrf().disable()
		.authorizeRequests()
		.antMatchers("/login","/register").permitAll()
		.antMatchers("/blog/*").permitAll()
		.anyRequest().authenticated().and()
		.formLogin()
		.loginPage("/login").defaultSuccessUrl("/blog/list").failureUrl("/loginerror")
		.usernameParameter("email")
		.passwordParameter("password")
		.permitAll()
		.and()
		.logout()
		.permitAll();
	}
	
	@Override
	protected void configure(AuthenticationManagerBuilder auth) throws Exception {
		auth
		  .userDetailsService(usercheck);
	}

}

