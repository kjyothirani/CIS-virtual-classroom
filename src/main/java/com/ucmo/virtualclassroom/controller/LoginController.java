package com.ucmo.virtualclassroom.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import com.ucmo.virtualclassroom.config.MyUserPrincipal;
import com.ucmo.virtualclassroom.model.LoginModel;
import com.ucmo.virtualclassroom.model.LoginSuccess;
import com.ucmo.virtualclassroom.model.RegistrationModel;
import com.ucmo.virtualclassroom.service.WikiService;

@RestController
public class LoginController {
	
	@Autowired
	private WikiService service;
	
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
	@RequestMapping(value = "/classroom/userservice", method = RequestMethod.GET)
	public MyUserPrincipal getuser() {
		Object principal = SecurityContextHolder.getContext().getAuthentication().getPrincipal();
		MyUserPrincipal userData = null;
		if (principal instanceof MyUserPrincipal)
		{
			userData =(MyUserPrincipal) principal;
		}
		return userData;
	}
	

	@RequestMapping(value = "/classroom/errorpage", method = RequestMethod.GET)
	public ModelAndView errorPage(@ModelAttribute("registrationform") RegistrationModel request) {
		ModelAndView mav =new ModelAndView("loginPage");
		mav.addObject("loginfailure", "yes");
		return mav;
	}

}
