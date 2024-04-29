package com.sis_auth_service.proxies;

import javax.persistence.Id;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
@NoArgsConstructor
@AllArgsConstructor
@Data
public class Auth_dto {
	@Id
	private String id;
	private String user_id;
	private String password;
	private String role;
}
