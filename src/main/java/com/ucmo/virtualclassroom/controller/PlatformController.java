package com.ucmo.virtualclassroom.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

@RestController
public class PlatformController {
	
	@RequestMapping(value = "/classroom/platform", method = RequestMethod.GET)
	public ModelAndView  displayPlatform() {
	
		ModelAndView mv =null;
		try {
			mv=new ModelAndView("ucmoPlatform");
			return mv;
		} catch (Exception e) {
		}
		return mv;
	}

}
