package com.ucmo.virtualclassroom.controller;

import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import com.ucmo.virtualclassroom.model.LoginModel;
import com.ucmo.virtualclassroom.model.LoginSuccess;
import com.ucmo.virtualclassroom.model.RegistrationModel;
import com.ucmo.virtualclassroom.model.RegistrationSuccess;

@RestController
public class RegistrationController {
	
	
	@RequestMapping(value = "/classroom/register", method = RequestMethod.POST)
	public ModelAndView getDocuments(@ModelAttribute("registrationform") RegistrationModel request) {
		String resp = null;
		RegistrationSuccess response = new RegistrationSuccess();
		try {
			//Save the Request
		} catch (Exception e) {
		}
		response.setSuccess(true);
		return new ModelAndView("loginPage", "registrationform", new RegistrationModel());
	}
	
	
	
	@RequestMapping(value = "/classroom/loginPage", method = RequestMethod.POST)
	public ModelAndView  login(@ModelAttribute("loginform") LoginModel request) {
		String resp = null;
		LoginSuccess response = new LoginSuccess();
		try {
			//Save the Request
		} catch (Exception e) {
		}
		response.setSuccess(true);
		return new ModelAndView("loginPage", "loginform", new LoginModel());
	}
	
	@RequestMapping(value = "/classroom/login", method = RequestMethod.POST)
	public ModelAndView  validatelogin(@ModelAttribute("loginform") LoginModel request) {
		String resp = null;
		LoginSuccess response = new LoginSuccess();
		try {
			//Save the Request
		} catch (Exception e) {
		}
		response.setSuccess(true);
		return new ModelAndView("homePage", "loginform", new LoginModel());
	}

}
