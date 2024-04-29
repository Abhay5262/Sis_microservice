package com.service_admin.service;

import org.springframework.stereotype.Service;

import com.service_admin.proxies.FeeDetails_Dto;
@Service
public interface FeeDetails_service {


	public FeeDetails_Dto getFeeDetails(String student_enrollmentNo);
}
