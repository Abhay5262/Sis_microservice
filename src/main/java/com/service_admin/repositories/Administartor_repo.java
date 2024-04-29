package com.service_admin.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.service_admin.entities.Administartor_Entity;

@Repository
public interface Administartor_repo extends JpaRepository<Administartor_Entity, String>  {

	
	
}
