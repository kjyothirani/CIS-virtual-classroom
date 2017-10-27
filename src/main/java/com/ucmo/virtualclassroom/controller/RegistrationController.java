package com.ucmo.virtualclassroom.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import com.ucmo.virtualclassroom.model.LoginModel;
import com.ucmo.virtualclassroom.model.LoginSuccess;
import com.ucmo.virtualclassroom.model.RegistrationModel;
import com.ucmo.virtualclassroom.model.RegistrationSuccess;
import com.ucmo.virtualclassroom.service.RegistrationService;

@RestController
public class RegistrationController {
	
	@Autowired
	private RegistrationService registrationService;
	
	@RequestMapping(value = "/classroom/register", method = RequestMethod.POST)
	public ModelAndView getDocuments(@ModelAttribute("registrationform") RegistrationModel request) {
		return new ModelAndView("loginPage", "registrationform", new RegistrationModel());
	}
	
	@RequestMapping(value = "/classroom/submitRegistration", method = RequestMethod.POST)
	public ModelAndView submitRegistration(@ModelAttribute("registrationform") RegistrationModel request) {
		ModelAndView mav =new ModelAndView("loginPage", "registrationform", new RegistrationModel());
		RegistrationSuccess response = new RegistrationSuccess();
		try {
		boolean isSuccess=	registrationService.createStudent(request);
			response.setSuccess(isSuccess);
		} catch (Exception e) {
			response.setSuccess(false);
		}
		mav.addObject("response", response);
		return mav;
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
