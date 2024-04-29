package com.sis_auth_service.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.sis_auth_service.entity.Auth_entity;
import com.sis_auth_service.reqrep.Request;
import com.sis_auth_service.reqrep.Response;
import com.sis_auth_service.services.Auth_service;
import com.sis_auth_service.userdetail.ProjectUserDetail;
import com.sis_auth_service.utils.Jwtutil;

@RestController
@RequestMapping("/auth")
public class AuthController {
	
	
	@Autowired
	private AuthenticationManager authenticationManager;
	
	@Autowired
	private ProjectUserDetail projectUserDetails;
	
	@Autowired
	private Jwtutil jwtUtils;
	
	@Autowired
	private Auth_service auth_service;
	
	@PostMapping("/login")
	public ResponseEntity<Response> loginWithCredentials(@RequestBody Request loginRequest)
	{

		try {
			authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(loginRequest.getUsername(), loginRequest.getPassword()));
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		projectUserDetails.setRole(loginRequest.getRole());
		
		UserDetails userDetails = projectUserDetails.loadUserByUsername(loginRequest.getUsername());
		
		String token = jwtUtils.generateToken(userDetails);
		
		return new ResponseEntity<Response>(new Response(token),HttpStatus.OK);
		
		
	}
	
	
	@PostMapping("/validate")
	public ResponseEntity<Boolean> ValidateToken()
	{
		return new ResponseEntity<Boolean> (Boolean.TRUE,HttpStatus.ACCEPTED);
	}
	
	@PostMapping("/register")
	public ResponseEntity<String> register(@RequestBody Auth_entity auth_entity){
		return new ResponseEntity<String>(auth_service.register(auth_entity), HttpStatus.ACCEPTED);
	}
}
