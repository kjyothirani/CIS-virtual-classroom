package com.ucmo.virtualclassroom.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

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
	
	
	
	@RequestMapping(value = "/classroom/loginPage", method = RequestMethod.GET)
	public ModelAndView  login() {
		String resp = null;
		LoginSuccess response = new LoginSuccess();
		try {
			//Save the Request
		} catch (Exception e) {
		}
		response.setSuccess(true);
		return new ModelAndView("loginPage", "loginform", new LoginModel());
	}
	
	@RequestMapping(value = "/classroom/home", method = RequestMethod.GET)
	public ModelAndView  validatelogin() {
		ModelAndView mv;
		try {
			mv=new ModelAndView("academicWikiPage");
			mv.addObject("academicList", service.getWikiList());
			return mv;
		} catch (Exception e) {
		}
		mv=new ModelAndView("loginPage");
		mv.addObject("loginform", new LoginModel());
		mv.addObject("loginFailure", "yes");
		
		return  mv;
	}


}
