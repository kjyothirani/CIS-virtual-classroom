package com.ucmo.virtualclassroom.controller;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.ucmo.virtualclassroom.model.AcademicWikiModel;

@Controller
public class HomeController {
	
	@RequestMapping(value = "/classroom/login", method = RequestMethod.GET)
	public String login(HttpServletRequest request, HttpServletResponse response) {
	
		return "login";
	}
	
	@RequestMapping(value = "/classroom/register", method = RequestMethod.GET)
	public String registration(HttpServletRequest request, HttpServletResponse response) {
	
		return "registration";
	}
	
	@RequestMapping(value = "/classroom/loginPage", method = RequestMethod.GET)
	public String loginPage(HttpServletRequest request, HttpServletResponse response) {
	
		return "loginPage";
	}
	
	@RequestMapping(value = "/classroom/academicWiki", method = RequestMethod.GET)
	public ModelAndView academicWiki(HttpServletRequest request, HttpServletResponse response) {
	
		ModelAndView mv=new ModelAndView("academicWikiPage");
		
		mv.addObject("academicList", getUploadDetails());
		return mv;
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
