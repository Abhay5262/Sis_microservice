package com.sis_auth_service.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.sis_auth_service.entity.Auth_entity;
@Repository
public interface Auth_repo extends JpaRepository<Auth_entity, String> {
	
}
