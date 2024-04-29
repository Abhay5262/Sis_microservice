package com.sis_auth_service.userdetail;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.sis_auth_service.entity.Auth_custom;
import com.sis_auth_service.entity.Auth_entity;
import com.sis_auth_service.repositories.Auth_repo;



@Service
public class ProjectUserDetail implements UserDetailsService  {
	@Autowired
	private PasswordEncoder passwordEncoder;
	
	@Autowired
	private Auth_repo auth_repo;

	
	public String role;
	
	public void setRole(String role){
		this.role=role;
	}
	
	public UserDetails loadUserByUsername(String name)
	{

		 
				if (role.equals(Role.ROLE_ADMIN)) {
		 
					Auth_entity administrator = auth_repo.findById(name).get();
		 
					if (administrator != null) {
//						return new User(administrator.getId(), administrator.getPassword(), new ArrayList<>());
						return new Auth_custom(administrator);
					} else {
						throw new UsernameNotFoundException("Admin name is invalid");
					}
		 
				}
		 
				else if (role.equals(Role.ROLE_USER.toString())) {
//				else if (true) {
					
		 
					Auth_entity student_Entity =auth_repo.findById(name).get();
		 
					if (student_Entity != null) {
//						return new User(student.getEnrollmentNo(), student.getPassword(), new ArrayList<>());
						
						return new  Auth_custom(student_Entity);
					} else {
						throw new UsernameNotFoundException("User name is invalid");
					}
		 
				}
		 
				else {
					System.out.println("Select Your Role Properly..!!");
					return null;
				}
		 
			}
		 
}
