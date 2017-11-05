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

import com.ucmo.virtualclassroom.model.PlatformForm;
import com.ucmo.virtualclassroom.model.PlatformModel;
import com.ucmo.virtualclassroom.model.Platformdiscussion;
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
	
	@RequestMapping(value = "/classroom/platformDiscussion", method = RequestMethod.GET)
	public ModelAndView  platformDiscussion(@RequestParam("id") Long id) {
	
		ModelAndView mv =null;
		try {
			List<Platformdiscussion> model =platformService.getPlatformDiscussion(id);
			PlatformModel platformModel =platformService.getPlatformModel(id);
			mv=new ModelAndView("platformDiscussion");
			mv.addObject("platformDiscussionList", model);
			mv.addObject("platformForm", new PlatformForm());
			mv.addObject( platformModel);
			return mv;
		} catch (Exception e) {
		}
		return mv;
	}
	

	@RequestMapping(value = "/classroom/submitDiscussion", method = RequestMethod.POST)
	public Success  submitQuestion(@ModelAttribute("platformForm") PlatformForm request) {
		Success response = new Success();
		PlatformModel model = new PlatformModel();
		model.setDiscussionName(request.getDiscussionName());
		model.setFirstName(request.getFirstName());
		model.setLastName(request.getLastName());
		model.setTags(request.getTags());
		List<Platformdiscussion> list = new ArrayList<>();
		Platformdiscussion discussion = new Platformdiscussion();
		discussion.setOrdervalue(1);
	discussion.setValue(request.getDiscussion());
		list.add(discussion);
		//model.setPlatformDiscussion(list);
		try {
		
			model=platformService.saveDiscussion(model);
		discussion.setPlatformid(model.getId());
			platformService.savePlatformDiscussion(discussion);
			if(model!=null)
			response.setSuccess(true);
		} catch (Exception e) {
			response.setSuccess(false);
		}
		response.setSuccess(false);
		return response;
		
	}
	
	@RequestMapping(value = "/classroom/replyDiscussion", method = RequestMethod.POST)
	public ModelAndView  replyQuestion(@ModelAttribute("platformForm") PlatformForm request) {
		List<Platformdiscussion> model =platformService.getPlatformDiscussion(request.getId());
		Platformdiscussion discussion = new Platformdiscussion();
		discussion.setOrdervalue(model.size()+1);
		discussion.setPlatformid(request.getId());
		discussion.setValue(request.getDiscussion());
		discussion =platformService.savePlatformDiscussion(discussion);
ModelAndView mv =null;
model =platformService.getPlatformDiscussion(request.getId());
		PlatformModel platformModel =platformService.getPlatformModel(request.getId());
		mv=new ModelAndView("platformDiscussion");
		mv.addObject("platformDiscussionList", model);
		mv.addObject("platformForm", new PlatformForm());
		mv.addObject( platformModel);
		return mv;
	}

}
