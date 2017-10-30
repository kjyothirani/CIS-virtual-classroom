package com.ucmo.virtualclassroom.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import com.ucmo.virtualclassroom.model.AcademicWikiModel;
import com.ucmo.virtualclassroom.model.PlatformModel;
import com.ucmo.virtualclassroom.model.Success;
import com.ucmo.virtualclassroom.service.PlatformService;

@RestController
public class PlatformController {
	@Autowired
	private PlatformService platformService;
	
	@RequestMapping(value = "/classroom/platform", method = RequestMethod.GET)
	public ModelAndView  displayPlatform() {
	
		ModelAndView mv =null;
		try {
			mv=new ModelAndView("platform");
			mv.addObject("platformList", platformService.getAll());
			return mv;
		} catch (Exception e) {
		}
		return mv;
	}
	
	@RequestMapping(value = "/classroom/newDiscussion", method = RequestMethod.GET)
	public ModelAndView  newDiscussion() {
	
		ModelAndView mv =null;
		try {
			mv=new ModelAndView("newDiscussion");
			mv.addObject("platformForm", new PlatformModel());
			return mv;
		} catch (Exception e) {
		}
		return mv;
	}
	

	@RequestMapping(value = "/classroom/submitDiscussion", method = RequestMethod.POST)
	public Success  submitQuestion(@ModelAttribute("platformForm") PlatformModel request) {
		Success response = new Success();
		try {
			boolean success =false;
			success=platformService.saveDiscussion(request);
			response.setSuccess(success);
		} catch (Exception e) {
			response.setSuccess(false);
		}
		return response;
		
	}

}
