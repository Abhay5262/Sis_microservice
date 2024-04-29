package com.service_admin.utils;

import org.springframework.stereotype.Component;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.service_admin.entities.Administartor_Entity;
import com.service_admin.entities.FeeDetails_Entity;
import com.service_admin.proxies.Administartor_Dto;
import com.service_admin.proxies.FeeDetails_Dto;


@Component
public class Helper {
	
	

//Converstion of Administartor Class//
	public static Administartor_Dto entitytoAdministartor_Dto(Administartor_Entity ae) {
		ObjectMapper mapper =new ObjectMapper();
		return mapper.convertValue(ae, Administartor_Dto.class);
	}
	
	public static Administartor_Entity dtotoAdministartor_Entity(Administartor_Dto ad) {
		ObjectMapper mapper =new ObjectMapper();
		return mapper.convertValue(ad, Administartor_Entity.class);
	}
	
	//Converstion of Fee Datial class//
	
	public static FeeDetails_Dto entitytoFeeDetails_Dto(FeeDetails_Entity fe) {
		ObjectMapper mapper =new ObjectMapper();
		return mapper.convertValue(fe, FeeDetails_Dto.class);
	}
	
	public static FeeDetails_Entity dtotoFeeDetails_Entity(FeeDetails_Dto fd) {
		ObjectMapper mapper =new ObjectMapper();
		return mapper.convertValue(fd, FeeDetails_Entity.class);
	}
	
	
	
}
