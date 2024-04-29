package com.service_student.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import com.service_student.proxies.EducationDetails_Dto;
import com.service_student.proxies.Student_Dto;
import com.service_student.services.EducationDetails_service;
import com.service_student.services.Student_service;

@RestController
@RequestMapping("/user")
public class Usercontroller {
	@Autowired
	private Student_service student_service;
	
	@Autowired
	private RestTemplate restTemplate;
	
	@Autowired
	private EducationDetails_service educationDetails_service;
	
	@PostMapping("/register")
	public ResponseEntity<String>registerWithDetails(@RequestBody Student_Dto student){
		
		return new ResponseEntity<String>(student_service.registerWithDetails(student),HttpStatus.ACCEPTED);
	}
	
	@PostMapping("/updateUser/{id}")
	public ResponseEntity<String>updateUserDetails(@PathVariable String id, @RequestBody Student_Dto student){
		return new ResponseEntity<>(student_service.updateUserDetails(id, student),HttpStatus.ACCEPTED);
	}
	
	@GetMapping("/getUser/{id}")
	public ResponseEntity<Student_Dto>getUser(@PathVariable String id){
		return new ResponseEntity<Student_Dto>(student_service.getUser(id),HttpStatus.ACCEPTED);
	}
	
	@GetMapping("/getFeeDetails/{student_enrollmentNo}")
	public ResponseEntity<Object>getFeeDetails(@PathVariable String student_enrollmentNo){
		Object forObject = restTemplate.getForObject("http://ADMIN-SERVICE/admin/admin/getFeeDetails/"+student_enrollmentNo, Object.class);
//		return new ResponseEntity<FeeDetails_Dto>(feeDetails_service.getFeeDetails(student_enrollmentNo),HttpStatus.ACCEPTED);
		return new ResponseEntity<Object>(forObject,HttpStatus.ACCEPTED);
	}
	
	@PostMapping("/addEducationDetails")
	public ResponseEntity<String>addEducationDetails(@RequestBody EducationDetails_Dto education){
		return new ResponseEntity<String>(educationDetails_service.addEducationDetails(education),HttpStatus.OK);
	}
	
	@PostMapping("/updateEducationDetails/{id}")
	public ResponseEntity<String>updateEducationDetails(@PathVariable Long id,@RequestBody EducationDetails_Dto education){
		return new ResponseEntity<String>(educationDetails_service.updateEducationDetails(id, education),HttpStatus.ACCEPTED);
	}
	
	@GetMapping("/GetEducationDetails/{id}")
	public ResponseEntity<EducationDetails_Dto> GetEducationDetails(@PathVariable Long id) {
		return new ResponseEntity<>(educationDetails_service.GetEducationDetails(id),HttpStatus.OK);
	}
	
	@GetMapping("/Getallusers")
	public ResponseEntity<List<Student_Dto>> Getalluser(){
		return new ResponseEntity<List<Student_Dto>>(student_service.Getalluser(),HttpStatus.ACCEPTED);
	}
	
	@PostMapping("/Deleteuserbyid/{id}")
	public ResponseEntity<String> deleteuserbyid(@PathVariable String enrollmentNo){
		return new ResponseEntity<String>(student_service.deleteuserbyid(enrollmentNo), HttpStatus.ACCEPTED);
	}
}
