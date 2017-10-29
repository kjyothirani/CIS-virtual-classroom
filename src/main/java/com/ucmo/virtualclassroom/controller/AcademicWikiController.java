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
import com.ucmo.virtualclassroom.model.Success;
import com.ucmo.virtualclassroom.service.WikiService;
@RestController
public class AcademicWikiController {
	
	@Autowired
	private WikiService service;
	
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
	
	@RequestMapping(value = "/classroom/upload", method = RequestMethod.GET)
	public ModelAndView  upload() {
		ModelAndView mav = new ModelAndView("uploadFile");
		mav.addObject("uploadform", new AcademicWikiModel());
		return mav;
	}
	
	@RequestMapping(value = "/classroom/submitUpload", method = RequestMethod.POST)
	public Success  submitUpload(@ModelAttribute("uploadform") AcademicWikiModel request) {
		Success response = new Success();
		try {
			boolean success =service.saveWiki(request);
			response.setSuccess(success);
		} catch (Exception e) {
			response.setSuccess(false);
		}
		response.setSuccess(true);
		return response;
	}
	
	

}
