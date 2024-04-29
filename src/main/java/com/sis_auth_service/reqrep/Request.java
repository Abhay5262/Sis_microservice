package com.sis_auth_service.reqrep;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Request {
	private String username;
	private String password;
	private String role;
}
