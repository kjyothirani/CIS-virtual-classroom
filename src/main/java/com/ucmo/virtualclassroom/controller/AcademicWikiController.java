package com.ucmo.virtualclassroom.controller;

import java.io.File;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import com.ucmo.virtualclassroom.model.AcademicWikiForm;
import com.ucmo.virtualclassroom.model.AcademicWikiModel;
import com.ucmo.virtualclassroom.model.LoginModel;
import com.ucmo.virtualclassroom.model.Success;
import com.ucmo.virtualclassroom.service.WikiService;
@RestController
public class AcademicWikiController {
	
	@Autowired
	private WikiService service;
	
	@Autowired
	private Environment env;
	
	
	@RequestMapping(value = "/classroom/upload", method = RequestMethod.GET)
	public ModelAndView  upload() {
		ModelAndView mav = new ModelAndView("uploadFile");
		mav.addObject("uploadform", new AcademicWikiModel());
		return mav;
	}
	@RequestMapping(value = "/classroom/academicWiki", method = RequestMethod.GET)
	public ModelAndView  validatelogin(@ModelAttribute("loginform") LoginModel request) {
	
		ModelAndView mv =null;
		try {
			mv=new ModelAndView("academicWikiPage");
			mv.addObject("academicList", service.getWikiList());
			return mv;
		} catch (Exception e) {
		}
		return mv;
	}
	
	@RequestMapping(value = "/classroom/getWikiList", method = RequestMethod.GET)
	public List<AcademicWikiModel>  getWikiList() {
	
	
		return service.getWikiList();
	}
	
	@RequestMapping(value = "/classroom/submitUpload", method = RequestMethod.POST)
	public ModelAndView  submitUpload(@ModelAttribute AcademicWikiForm request) {
		Success response = new Success();
		try {
			AcademicWikiModel model = new AcademicWikiModel();
			File f = new File(env.getProperty("temp.file.location")+request.getPdf().getOriginalFilename());
			request.getPdf().transferTo(f);
			model.setArticleName(request.getArticleName());
			model.setPdf(f.getAbsolutePath());
			model.setResource(request.getResource());
			model.setStudentName(request.getStudentName());
			boolean success =service.saveWiki(model);
			response.setSuccess(success);
		} catch (Exception e) {
			response.setSuccess(false);
		}
		ModelAndView mav = new ModelAndView("uploadFile");
		mav.addObject("uploadform", new AcademicWikiModel());
		return mav;
	}
	
	

}
