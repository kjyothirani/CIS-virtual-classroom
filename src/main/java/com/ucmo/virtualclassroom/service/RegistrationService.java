package com.ucmo.virtualclassroom.service;

import com.ucmo.virtualclassroom.model.RegistrationModel;

public interface RegistrationService {
	
	public boolean  createStudent(RegistrationModel model);
	
	public boolean  validateLogin(RegistrationModel model);
	
	public RegistrationModel  getUser(Long id);

}
