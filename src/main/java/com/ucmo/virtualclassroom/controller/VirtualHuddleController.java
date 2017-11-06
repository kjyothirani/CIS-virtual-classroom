package com.ucmo.virtualclassroom.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import com.ucmo.virtualclassroom.model.Success;
import com.ucmo.virtualclassroom.model.VirtualHuddleModel;
import com.ucmo.virtualclassroom.service.VirtualHuddleService;



@RestController
public class VirtualHuddleController {
	
	@Autowired VirtualHuddleService service;

	@RequestMapping(value = "/classroom/virtualhuddle", method = RequestMethod.GET)
	public ModelAndView getVirtualHuddle() {
		return new ModelAndView("virtualHuddle");
	}
	
	@RequestMapping(value = "/classroom/submithuddle", method = RequestMethod.POST)
	public Success submitHuddle(@ModelAttribute("virtualhuddleform") VirtualHuddleModel request){
		Success response = new Success();
		try {
			boolean success = service.saveHuddle(request);
			response.setSuccess(success);
		} catch (Exception e) {
			response.setSuccess(false);
		}
		response.setSuccess(true);
		return response;
	}
}
