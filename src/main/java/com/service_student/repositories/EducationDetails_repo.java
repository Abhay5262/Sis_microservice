package com.service_student.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.stereotype.Repository;

import com.service_student.entities.EducationDetails_Entity;
@Repository
@EnableJpaRepositories
public interface EducationDetails_repo extends JpaRepository<EducationDetails_Entity, Long> {
	
	
}
