package com.service_admin.controller;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import com.service_admin.proxies.Administartor_Dto;
import com.service_admin.proxies.FeeDetails_Dto;
import com.service_admin.proxies.Student_Dto;
import com.service_admin.service.Administartor_service;

@RestController
@RequestMapping("/admin")
public class AdministrativeController {
	
	@Autowired
	private Administartor_service administartor_service;
	
	@Autowired
	private RestTemplate restTemplate;
	
	@PostMapping("/register")	
	public ResponseEntity<String>registerWithDetails(@RequestBody Administartor_Dto administartor_Dto){
		return new ResponseEntity<String>(administartor_service.registerWithDetails(administartor_Dto),HttpStatus.ACCEPTED);
	}
	
	@PostMapping("/updateUser/{id}")
	public ResponseEntity<String>updateUserDetails(@RequestHeader Map<String, String> headerdata ,@PathVariable String id,@RequestBody Student_Dto student_Dto){
		
		HttpHeaders httpHeaders = new HttpHeaders();
		 
		httpHeaders.set("authorization", headerdata.get("token"));
		httpHeaders.setContentType(MediaType.APPLICATION_JSON);
 
		System.out.println(httpHeaders);
		HttpEntity<Object> httpEntity = new HttpEntity<Object>(null, httpHeaders);
 
		if (restTemplate.postForEntity("http://localhost:8091/Auth/auth/validate", httpEntity, Object.class).getBody().equals(true)) {
 
			return ResponseEntity.ok(restTemplate.postForObject("http://STUDENT-SERVICE/student/user/updateUser/", student_Dto, String.class));
		} else {
			return ResponseEntity.ok("You are not Authorized..!");
		}
//		return new ResponseEntity<String>(administartor_service.updateUserDetails(id, student_Dto),HttpStatus.OK);
	}
	
	@PostMapping("/updateAdmin/{id}")
	public ResponseEntity<String>updateAdminDetails(@PathVariable String id,@RequestBody Administartor_Dto administartor_Dto){
		return new ResponseEntity<String>(administartor_service.updateAdminDetails(id, administartor_Dto),HttpStatus.OK);
	}
	@PostMapping("/deleteUser/{enrollmentno}")
	public ResponseEntity<String>deleteUser(@PathVariable String enrollmentno){
		Object postForObject = restTemplate.getForObject("http://STUDENT-SERVICE/student/user/Deleteuserbyid/"+enrollmentno,String.class);
		return new ResponseEntity<String>((String) postForObject, HttpStatus.OK);
		
	}
	@GetMapping("/getallUsers")
	public ResponseEntity<Object> getUsers(){
		Student_Dto forObject = restTemplate.getForObject("http://STUDENT-SERVICE/student/user/Getallusers", Student_Dto.class);
		return new ResponseEntity<Object>(forObject,HttpStatus.ACCEPTED);
	}
	@GetMapping("/getUser/{id}")
	public ResponseEntity<Object>getUser(@PathVariable String id){
		Object forObject = restTemplate.getForObject("http://STUDENT-SERVICE/student/user/getUser/"+id, Object.class);
		return new ResponseEntity<Object>(forObject,HttpStatus.OK);
//		return new ResponseEntity<Student_Dto>(administartor_service.getUser(id),HttpStatus.OK);
	}
	@GetMapping("/getAdmin/{id}")
	public ResponseEntity<Administartor_Dto>getAdmin(@PathVariable String id){
		return new ResponseEntity<>(administartor_service.getAdmin(id),HttpStatus.ACCEPTED);
	}
	@PostMapping("/addFeeDetails")
	public ResponseEntity<String>addFeeDetails(@RequestBody FeeDetails_Dto feeDetails){
		return new ResponseEntity<String>(administartor_service.addFeeDetails(feeDetails),HttpStatus.ACCEPTED);
	}
	@GetMapping("/getFeeDetails/{id}")
	public ResponseEntity<FeeDetails_Dto>getFeeDetails(@PathVariable String id){
		return new ResponseEntity<>(administartor_service.getFeeDetails(id),HttpStatus.OK);
	}
	
	@GetMapping("/GetEducationDetails/{id}")
	public ResponseEntity<Object>GetEducationDetails(@PathVariable Long id){
			Object forEntity = restTemplate.getForEntity("http://STUDENT-SERVICE/student/user/GetEducationDetails/"+id, Object.class).getBody();
//			System.err.println();
		return new ResponseEntity<Object>(forEntity,HttpStatus.OK);
		
//		return new ResponseEntity<EducationDetails_Dto>(administartor_service.GetEducationDetails(id),HttpStatus.ACCEPTED);
	}
}
