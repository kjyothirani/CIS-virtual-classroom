package com.ucmo.virtualclassroom.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import com.ucmo.virtualclassroom.config.MyUserPrincipal;
import com.ucmo.virtualclassroom.model.AcademicWikiModel;
import com.ucmo.virtualclassroom.model.LoginModel;
import com.ucmo.virtualclassroom.model.LoginSuccess;
import com.ucmo.virtualclassroom.model.RegistrationModel;
import com.ucmo.virtualclassroom.model.RegistrationSuccess;
import com.ucmo.virtualclassroom.service.RegistrationService;
import com.ucmo.virtualclassroom.service.WikiService;

@RestController
public class RegistrationController {
	
	@Autowired
	private RegistrationService registrationService;
	
	@Autowired
	private WikiService service;
	
	@RequestMapping(value = "/classroom/register", method = RequestMethod.GET)
	public ModelAndView getDocuments(@ModelAttribute("registrationform") RegistrationModel request) {
		return new ModelAndView("registration", "registrationform", new RegistrationModel());
	}
	
	@RequestMapping(value = "/classroom/submitRegistration", method = RequestMethod.POST)
	public RegistrationSuccess submitRegistration(@ModelAttribute("registrationform") RegistrationModel request) {
		ModelAndView mav =new ModelAndView("loginPage", "registrationform", new RegistrationModel());
		RegistrationSuccess response = new RegistrationSuccess();
		try {
		boolean isSuccess=	registrationService.createStudent(request);
			response.setSuccess(isSuccess);
		} catch (Exception e) {
			response.setSuccess(false);
		}
		mav.addObject("response", response);
		return response;
	}
	
	
	
	
}
