package com.sis_auth_service.services;

import org.springframework.stereotype.Service;

import com.sis_auth_service.entity.Auth_entity;
@Service
public interface Auth_service {
	public String register(Auth_entity auth_entity);
}
