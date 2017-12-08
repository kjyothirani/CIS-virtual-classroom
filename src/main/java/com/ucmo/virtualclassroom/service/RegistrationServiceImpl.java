package com.ucmo.virtualclassroom.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ucmo.virtualclassroom.model.RegistrationModel;
import com.ucmo.virtualclassroom.repository.RegistrationRepository;
@Service
public class RegistrationServiceImpl implements RegistrationService {
	
	@Autowired
	private RegistrationRepository registrationRepository; 

	@Override
	public boolean createStudent(RegistrationModel model) {
		model=registrationRepository.save(model);
		if(model!=null)
		return true;
		else
			return false;
	}

	@Override
	public boolean validateLogin(RegistrationModel model) {
		model=registrationRepository.findByStudentIDAndPassword(model.getStudentID(), model.getPassword());
		if(model!=null && model.getId() !=null)
		return true;
		else 
			return false;
	}

	@Override
	public RegistrationModel getUser(Long id) {
		// TODO Auto-generated method stub
		return registrationRepository.findById(id);
	}

}
