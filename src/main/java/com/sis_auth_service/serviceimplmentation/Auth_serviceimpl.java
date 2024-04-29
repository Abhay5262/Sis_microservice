package com.sis_auth_service.serviceimplmentation;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.sis_auth_service.entity.Auth_entity;
import com.sis_auth_service.repositories.Auth_repo;
import com.sis_auth_service.services.Auth_service;

@Component
public class Auth_serviceimpl implements Auth_service {
	
	@Autowired
	private Auth_repo auth_repo;
		
	@Override
	public String register(Auth_entity auth_entity) {
		auth_repo.save(auth_entity);
		return "register Successfully";
	}

}
