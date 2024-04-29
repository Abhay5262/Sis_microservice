package com.service_admin.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.service_admin.proxies.Administartor_Dto;
import com.service_admin.proxies.EducationDetails_Dto;
import com.service_admin.proxies.FeeDetails_Dto;
import com.service_admin.proxies.Student_Dto;

@Service
public interface Administartor_service {
	public String registerWithDetails( Administartor_Dto administartor_Dto);
	public String updateUserDetails(String id, Student_Dto student_Dto);
	public String updateAdminDetails(String id, Administartor_Dto administartor_Dto);
	public String deleteUser(String enrollmentno);
	public List<Student_Dto> getUsers();
	public Student_Dto getUser(String id);
	public Administartor_Dto getAdmin(String id);
	public String addFeeDetails(FeeDetails_Dto feeDetails);
	public FeeDetails_Dto getFeeDetails(String student_enrollmentNo);
	public  EducationDetails_Dto GetEducationDetails(String id);

	
}
