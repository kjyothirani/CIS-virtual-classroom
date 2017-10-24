package com.ucmo.virtualclassroom.controller;

import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.ucmo.virtualclassroom.model.LoginSuccess;
import com.ucmo.virtualclassroom.model.RegistrationModel;
import com.ucmo.virtualclassroom.model.RegistrationSuccess;

@RestController
public class RegistrationController {
	
	@RequestMapping(value = "/classroom/register", method = RequestMethod.POST)
	public RegistrationSuccess getDocuments(@RequestBody RegistrationModel request) {
		String resp = null;
		RegistrationSuccess response = new RegistrationSuccess();
		try {
			//Save the Request
		} catch (Exception e) {
		}
		response.setSuccess(true);
		return response;
	}
	
	@RequestMapping(value = "/classroom/login", method = RequestMethod.POST)
	public LoginSuccess login(@RequestBody RegistrationModel request) {
		String resp = null;
		LoginSuccess response = new LoginSuccess();
		try {
			//Save the Request
		} catch (Exception e) {
		}
		response.setSuccess(true);
		return response;
	}

}
