package com.service_student.services;

import org.springframework.stereotype.Service;

import com.service_student.proxies.EducationDetails_Dto;

@Service
public interface EducationDetails_service {
	public String addEducationDetails(EducationDetails_Dto education);
	public String updateEducationDetails(Long id, EducationDetails_Dto education);
	public EducationDetails_Dto GetEducationDetails(Long id);
}
