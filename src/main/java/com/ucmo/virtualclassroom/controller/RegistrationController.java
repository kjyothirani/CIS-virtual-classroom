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
	
	@RequestMapping(value = "/classroom/login", method = RequestMethod.POST)
	public ModelAndView  validatelogin(@ModelAttribute("loginform") LoginModel request) {
		LoginSuccess response = new LoginSuccess();
		RegistrationModel model = new RegistrationModel();
		model.setStudentID(request.getStudentID());
		model.setPassword(request.getPassword());
		ModelAndView mv;
		boolean isSuccess =false;
		try {
			isSuccess=registrationService.validateLogin(model);
			if(isSuccess){
			mv=new ModelAndView("academicWikiPage");
			response.setSuccess(isSuccess);
			mv.addObject("academicList", getUploadDetails());
			return mv;
			}
		} catch (Exception e) {
		}
		mv=new ModelAndView("loginPage");
		mv.addObject("loginform", new LoginModel());
		mv.addObject("loginFailure", "yes");
		
		return  mv;
	}
	public List<AcademicWikiModel> getUploadDetails(){
		List<AcademicWikiModel> academicWikiList = new ArrayList<AcademicWikiModel>();
		
		AcademicWikiModel ac = new AcademicWikiModel();
		ac.setResource("w3schools");
		ac.setLink("www.w3schools.com");
		ac.setPdf("xxx");
		ac.setArticleName("Learn Jquery");
		ac.setDate("10/24/2017");
		ac.setStudentName("Jyothi Rani");
		academicWikiList.add(ac);
		
		return academicWikiList;
		
	}

}
