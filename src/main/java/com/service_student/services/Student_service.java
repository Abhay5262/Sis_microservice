package com.service_student.services;

import java.util.List;

import org.springframework.stereotype.Service;

import com.service_student.proxies.Student_Dto;

@Service
public interface Student_service {
	public String registerWithDetails (Student_Dto student);
	public String updateUserDetails(String id, Student_Dto student);
	public Student_Dto getUser(String id);
	public List<Student_Dto> Getalluser();
	public String deleteuserbyid(String enrollmentNo);
}
