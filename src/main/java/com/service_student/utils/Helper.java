package com.service_student.utils;

import org.springframework.stereotype.Component;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.service_student.entities.EducationDetails_Entity;
import com.service_student.entities.Student_Entity;
import com.service_student.proxies.EducationDetails_Dto;
import com.service_student.proxies.Student_Dto;

@Component
public class Helper {
	
	// Converstion Of Education class//
	public static EducationDetails_Dto entitytoEducationDetails_Dto(EducationDetails_Entity ee) {
		ObjectMapper mapper =new ObjectMapper();
		return mapper.convertValue(ee, EducationDetails_Dto.class);
	}
	
	public static EducationDetails_Entity dtotoEducationDetails_Entity(EducationDetails_Dto ed) {
		ObjectMapper mapper =new ObjectMapper();
		return mapper.convertValue(ed, EducationDetails_Entity.class);
	}
	
	//Converstion Of Student Class//
	
	public static Student_Dto entitytoStudent_Dto(Student_Entity se) {
		ObjectMapper mapper =new ObjectMapper();
		return mapper.convertValue(se, Student_Dto.class);
	}
	
	public static Student_Entity dtotoStudent_Entity(Student_Dto sd) {
		ObjectMapper mapper =new ObjectMapper();
		return  mapper.convertValue(sd, Student_Entity.class);
	}
	
}
