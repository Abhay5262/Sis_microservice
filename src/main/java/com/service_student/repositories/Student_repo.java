package com.service_student.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.service_student.entities.Student_Entity;
@Repository
public interface Student_repo extends JpaRepository<Student_Entity, String> {

}
