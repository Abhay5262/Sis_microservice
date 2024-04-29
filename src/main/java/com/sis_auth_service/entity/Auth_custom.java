package com.sis_auth_service.entity;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.crypto.password.PasswordEncoder;

public class Auth_custom implements UserDetails {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private Auth_entity auth_entity;
	
	@Autowired
	private PasswordEncoder encoder;
	public Auth_custom (Auth_entity  auth_entity) {
		this.auth_entity=auth_entity;
	}
	@Override
	public Collection<? extends GrantedAuthority> getAuthorities() {
		// TODO Auto-generated method stub
		List<SimpleGrantedAuthority>authorities=new ArrayList<>();
		authorities.add(new SimpleGrantedAuthority(auth_entity.getRole()));
		return authorities;
	}
	@Override
	public String getPassword() {
		// TODO Auto-generated method stub
		return encoder.encode(auth_entity.getPassword());
	}
	@Override
	public String getUsername() {
		// TODO Auto-generated method stub
		return auth_entity.getUser_id();
	}
	@Override
	public boolean isAccountNonExpired() {
		// TODO Auto-generated method stub
		return true;
	}
	@Override
	public boolean isAccountNonLocked() {
		// TODO Auto-generated method stub
		return true;
	}
	@Override
	public boolean isCredentialsNonExpired() {
		// TODO Auto-generated method stub
		return true;
	}
	@Override
	public boolean isEnabled() {
		// TODO Auto-generated method stub
		return true;
	} 
	
	
	

}
