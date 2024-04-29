package com.sis_auth_service.configuration;



import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;
import org.springframework.stereotype.Component;

import com.sis_auth_service.filter.PreFilter;
@Component
@Configuration
@EnableWebSecurity
public class Config extends WebSecurityConfigurerAdapter {
	@Autowired
	private PreFilter filters;
	 
	@Bean
	public AuthenticationManager authenticationManager() throws Exception
	{
		return super.authenticationManager();
	}
	@Override
	protected void configure(AuthenticationManagerBuilder auth) throws Exception {
		 super.configure(auth);
	}
 
	@Override
	protected void configure(HttpSecurity http) throws Exception {
		// TODO Auto-generated method stub
		http.cors(c->c.disable())
		.csrf(cr->cr.disable())
		.authorizeHttpRequests(auth->auth.antMatchers("/auth/**").permitAll()
				.antMatchers("/user/**").hasRole("USER")
				.antMatchers("/admin/**","/user/**").hasRole("ADMIN")
				.anyRequest().authenticated())
		.sessionManagement(session->session.sessionCreationPolicy(SessionCreationPolicy.STATELESS));
		
		http.addFilterBefore(filters, UsernamePasswordAuthenticationFilter.class);
		
	
	}
}
