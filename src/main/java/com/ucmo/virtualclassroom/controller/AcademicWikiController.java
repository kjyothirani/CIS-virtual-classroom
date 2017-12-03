package com.ucmo.virtualclassroom.controller;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.core.io.InputStreamResource;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import com.ucmo.virtualclassroom.config.MyUserPrincipal;
import com.ucmo.virtualclassroom.model.AcademicWikiForm;
import com.ucmo.virtualclassroom.model.AcademicWikiModel;
import com.ucmo.virtualclassroom.model.LoginModel;
import com.ucmo.virtualclassroom.model.Success;
import com.ucmo.virtualclassroom.service.WikiService;
import com.ucmo.virtualclassroom.utils.UCMUtils;
@RestController
public class AcademicWikiController {
	
	@Autowired
	private WikiService service;
	
	@Autowired
	private Environment env;
	
	
	@RequestMapping(value = "/classroom/upload", method = RequestMethod.GET)
	public ModelAndView  upload() {
		ModelAndView mav = new ModelAndView("uploadFile");
		MyUserPrincipal principal = UCMUtils.getUser();
		AcademicWikiModel model = new AcademicWikiModel();
		model.setStudentName(principal.getFirstname() +" "+principal.getLastname());
		mav.addObject("uploadform",model);
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
			Date date = new Date();

			SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss"); //Or whatever format fits best your needs.
			String dateStr = sdf.format(date);
			AcademicWikiModel model = new AcademicWikiModel();
			File f = new File(env.getProperty("temp.file.location")+request.getPdf().getOriginalFilename());
			request.getPdf().transferTo(f);
			MyUserPrincipal principal = UCMUtils.getUser();
			model.setArticleName(request.getArticleName());
			model.setPdf(request.getPdf().getOriginalFilename());
			model.setResource(request.getResource());
			model.setStudentName(principal.getFirstname() +" "+principal.getLastname());
			model.setDate(dateStr);
			model.setSubject(request.getSubject());
			boolean success =service.saveWiki(model);
			response.setSuccess(success);
		} catch (Exception e) {
			response.setSuccess(false);
		}
		ModelAndView mav =null;
		mav=new ModelAndView("academicWikiPage");
		mav.addObject("academicList", service.getWikiList());
		
		mav.addObject("message", "yes");
		return mav;
	}
	
	@RequestMapping(value = "/classroom/download", method = RequestMethod.GET)
	public ResponseEntity<InputStreamResource>  download(@RequestParam("file") String file) throws FileNotFoundException {
		File f = new File(env.getProperty("temp.file.location")+file);
		HttpHeaders header = new HttpHeaders();
	    header.setContentType(MediaType.APPLICATION_PDF);
	    header.set(HttpHeaders.CONTENT_DISPOSITION,
	                   "attachment; filename=" + file.replace(" ", "_"));
	    header.setContentLength(f.length());
	    InputStreamResource isr = new InputStreamResource(new FileInputStream(f));
	    return new ResponseEntity<InputStreamResource>(isr, header, HttpStatus.OK);
		
	}

}
