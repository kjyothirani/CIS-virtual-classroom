package com.ucmo.virtualclassroom.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import com.ucmo.virtualclassroom.model.LoginModel;
import com.ucmo.virtualclassroom.model.RegistrationModel;
import com.ucmo.virtualclassroom.model.Subscribe;
import com.ucmo.virtualclassroom.model.Success;
import com.ucmo.virtualclassroom.model.VirtualHuddleModel;
import com.ucmo.virtualclassroom.service.RegistrationService;
import com.ucmo.virtualclassroom.service.VirtualHuddleService;
import com.ucmo.virtualclassroom.utils.UCMUtils;

@RestController
public class VirtualHuddleController {

	@Autowired
	VirtualHuddleService service;
	
	@Autowired
	private RegistrationService registrationService;

	@RequestMapping(value = "/classroom/virtualhuddle", method = RequestMethod.GET)
	public ModelAndView getVirtualHuddle() {
		return new ModelAndView("virtualHuddle");
	}

	@RequestMapping(value = "/classroom/submithuddle", method = RequestMethod.POST)
	public Success submitHuddle(@ModelAttribute("virtualhuddleform") VirtualHuddleModel request) {
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

	@RequestMapping(value = "/classroom/listhuddles", method = RequestMethod.GET)
	public ModelAndView listhuddle() {
		ModelAndView mv = new ModelAndView("huddlelist");
		List<VirtualHuddleModel> huddleList = service.getAll();
		List<Subscribe> subscribeList = service.getSubscribedHuddles(UCMUtils.getUser().getId());
		if (subscribeList.size() >= 0)
			for (Subscribe subscribe : subscribeList) {
				for (VirtualHuddleModel huddle : huddleList) {
					if (subscribe.getHuddleid() == huddle.getId()) {
						huddle.setSubscribed(true);
					}
				}
			}
		mv.addObject("huddlelist", huddleList);
		return mv;

	}

	@RequestMapping(value = "/classroom/subscribehuddle", method = RequestMethod.POST)
	public Success subscribe(@RequestParam("id") String id) {
		Subscribe subscribe = new Subscribe();
		subscribe.setHuddleid(Long.parseLong(id));
		subscribe.setUserid(UCMUtils.getUser().getId());
		Success response = new Success();
		try {
			boolean success = service.subscribeHuddle(subscribe);
			response.setSuccess(success);
		} catch (Exception e) {
			response.setSuccess(false);
		}
		return response;
	}


	@RequestMapping(value = "/classroom/deletehuddle", method = RequestMethod.POST)
	public Success deletehuddle(@RequestParam("id") String id){
		Success response = new Success();
		try {
			List<Subscribe> huddle	=service.findByHuddle(Long.parseLong(id));
			for(Subscribe subscribe: huddle)
			{
			if(UCMUtils.getUser().getId() == subscribe.getUserid())	
			{
				service.deletesubscribe(subscribe.getId());
			}
			}
			
			response.setSuccess(true);
		} catch (Exception e) {
			response.setSuccess(false);
		}
		return response;
	}
	
	@RequestMapping(value = "/classroom/getsubscription", method = RequestMethod.GET)
	public List<RegistrationModel>  getsubscription(@RequestParam("id") String id) {
	
		List<Subscribe> huddle	=service.findByHuddle(Long.parseLong(id));
		List<RegistrationModel> modelList = new ArrayList<RegistrationModel>();
		for(Subscribe subscribe: huddle)
		{
			
			modelList.add(registrationService.getUser(subscribe.getUserid()));
		}
		return modelList;
	}
	
	@RequestMapping(value = "/classroom/huddleusers", method = RequestMethod.GET)
	public ModelAndView  validatelogin(@RequestParam("id") Long id) {
	
		ModelAndView mv =null;
		try {
			mv=new ModelAndView("huddleusers");
			mv.addObject("id", id);
			mv.addObject("huddlename",service.getHuddle(id).getHuddlename());
			return mv;
		} catch (Exception e) {
		}
		return mv;
	}
	}
