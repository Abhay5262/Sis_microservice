package com.service_admin.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.service_admin.entities.FeeDetails_Entity;

@Repository
public interface FeeDetails_repo extends JpaRepository<FeeDetails_Entity, Long> {

	FeeDetails_Entity findByEnrollmentNo(String enrollmentNo);

}
