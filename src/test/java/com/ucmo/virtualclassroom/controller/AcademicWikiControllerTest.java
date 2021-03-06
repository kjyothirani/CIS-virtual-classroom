package com.ucmo.virtualclassroom.controller;

import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import java.net.URI;
import java.util.ArrayList;
import java.util.List;

import org.junit.Before;
import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import com.ucmo.virtualclassroom.model.AcademicWikiModel;
import com.ucmo.virtualclassroom.model.RegistrationModel;
import com.ucmo.virtualclassroom.service.RegistrationService;
import com.ucmo.virtualclassroom.service.WikiService;
import com.ucmo.virtualclassroom.utils.TestUtils;

public class AcademicWikiControllerTest {
	 private MockMvc mockMvc;
	
		@Mock
		private WikiService service;
		
		@Mock
		private Environment env;	
	 @InjectMocks
	private AcademicWikiController registrationController;
	
	 @Before
	    public void setup() {

	        // Process mock annotations
	        MockitoAnnotations.initMocks(this);

	        // Setup Spring test in standalone mode
	        this.mockMvc = MockMvcBuilders.standaloneSetup(registrationController).build();
	    }
	 
	 
	 @Test
	    public void test_getDocuments() throws Exception {
		  this.mockMvc.perform(get(new URI("/classroom/upload"))
	                .contentType(MediaType.APPLICATION_JSON))
	                .andExpect(status().is2xxSuccessful());
	    }
	 
	 @Test
	    public void test_validatelogin() throws Exception {
		 List<AcademicWikiModel> list = new ArrayList();
		 when(service.getWikiList()).thenReturn(list);

		   this.mockMvc.perform(get(new URI("/classroom/academicWiki/"))
	                .contentType(MediaType.APPLICATION_JSON))
	                .andExpect(status().is2xxSuccessful());
	    
	 }
	 
	 @Test
	    public void test_getWikiListTest() throws Exception {
		 List<AcademicWikiModel> list = new ArrayList();
		 when(service.getWikiList()).thenReturn(list);

		   this.mockMvc.perform(get(new URI("/classroom/getWikiList/"))
	                .contentType(MediaType.APPLICATION_JSON))
	                .andExpect(status().is2xxSuccessful());
	    
	 }
	 
	 @Test
	    public void test_submitRegistration() throws Exception {
		 AcademicWikiModel request = new AcademicWikiModel();
		 when(service.saveWiki(request)).thenReturn(Boolean.TRUE);

		   this.mockMvc.perform(post("/classroom/submitUpload").content(TestUtils.asJsonString(request))
	                .contentType(MediaType.APPLICATION_JSON))
	                .andExpect(status().is2xxSuccessful());
	    }
	 
	
}
