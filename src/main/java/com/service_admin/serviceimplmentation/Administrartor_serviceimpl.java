package com.service_admin.serviceimplmentation;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Component;

import com.service_admin.entities.Administartor_Entity;
import com.service_admin.entities.FeeDetails_Entity;
import com.service_admin.proxies.Administartor_Dto;
import com.service_admin.proxies.EducationDetails_Dto;
import com.service_admin.proxies.FeeDetails_Dto;
import com.service_admin.proxies.Student_Dto;
import com.service_admin.repositories.Administartor_repo;
import com.service_admin.repositories.FeeDetails_repo;
import com.service_admin.service.Administartor_service;
import com.service_admin.utils.Helper;


@Component
@Primary
public class Administrartor_serviceimpl implements Administartor_service {
	
	@Autowired
	private Administartor_repo administartor_repo;
	
	@Autowired
	private FeeDetails_repo feeDetails_repo;
	
	
	@Override
	public String registerWithDetails(Administartor_Dto administartor_Dto) {
		Administartor_Entity dtotoAdministartor_Entity = Helper.dtotoAdministartor_Entity(administartor_Dto);
		administartor_repo.save(dtotoAdministartor_Entity);
		return "Data Has Been Saved";
	}

	@Override
	public String updateAdminDetails(String id, Administartor_Dto administartor_Dto) {
		Administartor_Entity administartor_Entity = administartor_repo.findById(id).get();
		administartor_Entity.setName(administartor_Dto.getName());
		administartor_Entity.setGender(administartor_Dto.getGender());
		administartor_Entity.setContact(administartor_Dto.getContact());
		administartor_Entity.setAddress(administartor_Dto.getAddress());
		administartor_Entity.setPassword(administartor_Dto.getPassword());
		administartor_Entity.setSecuritykey(administartor_Dto.getSecuritykey());
		administartor_Entity.setRole(administartor_Dto.getRole());
		administartor_repo.save(administartor_Entity);
		return "Dats Has Been Upated";
	}

	@Override
	public String deleteUser(String enrollmentno) {
//			student_repo.deleteById(enrollmentno);
		return "Student Has Been Deleted";
	}

	@Override
	public List<Student_Dto> getUsers() {
		return null;
		
//		List<Student_Entity> e=student_repo.findAll();
//		List<Student_Dto> dto=new ArrayList<>();
//		
//		for (Student_Entity se : e) {
//			Student_Dto dto1=(Student_Dto) Helper.entitytoStudent_Dto(se);
//			dto.add(dto1);
//		}
//	return dto;	
	}

	@Override
	public String addFeeDetails(FeeDetails_Dto feeDetails) {
		FeeDetails_Entity FeeDetails_Entity = Helper.dtotoFeeDetails_Entity(feeDetails);
		feeDetails_repo.save(FeeDetails_Entity);
		return "Fee Detail Has Been Added";
	}

	@Override
	public EducationDetails_Dto GetEducationDetails(String id) {
//		EducationDetails_Entity educationDetails_Entity = educationDetails_repo.findById(id).get();
//		EducationDetails_Dto entitytoEducationDetails_Dto = Helper.entitytoEducationDetails_Dto(educationDetails_Entity);
//		return entitytoEducationDetails_Dto;
		return null;
	}

	@Override
	public Administartor_Dto getAdmin(String id) {
		Administartor_Entity administartor_Entity = administartor_repo.findById(id).get();
		Administartor_Dto entitytoAdministartor_Dto = Helper.entitytoAdministartor_Dto(administartor_Entity);
		return entitytoAdministartor_Dto;
	}

	@Override
	public String updateUserDetails(String id, Student_Dto student_Dto) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Student_Dto getUser(String id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public FeeDetails_Dto getFeeDetails(String student_enrollmentNo) {
		// TODO Auto-generated method stub
		FeeDetails_Entity byStudent_enrollmentNo = feeDetails_repo.findByEnrollmentNo(student_enrollmentNo);
		
		FeeDetails_Dto entitytoFeeDetails_Dto = Helper.entitytoFeeDetails_Dto(byStudent_enrollmentNo);
		return entitytoFeeDetails_Dto;
	}



	

	


}
