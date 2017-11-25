package com.ucmo.virtualclassroom.controller;

import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import java.net.URI;
import java.util.ArrayList;
import java.util.List;

import org.junit.Before;
import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import com.ucmo.virtualclassroom.model.PlatformModel;
import com.ucmo.virtualclassroom.model.Platformdiscussion;
import com.ucmo.virtualclassroom.service.PlatformService;
public class PlatformControllerTest {
	
	 private MockMvc mockMvc;
		
		@Mock
		private PlatformService platformService;
		
	 @InjectMocks
	private PlatformController platformController;
	
	 @Before
	    public void setup() {

	        // Process mock annotations
	        MockitoAnnotations.initMocks(this);

	        // Setup Spring test in standalone mode
	        this.mockMvc = MockMvcBuilders.standaloneSetup(platformController).build();
	    }
	 
	 
	 @Test
	    public void test_getDocuments() throws Exception {
		 List<PlatformModel> list = new ArrayList();
		 when(platformService.getAll()).thenReturn(list);
		  this.mockMvc.perform(get(new URI("/classroom/platformdata"))
	                .contentType(MediaType.APPLICATION_JSON))
	                .andExpect(status().is2xxSuccessful());
	    }
	 
	 @Test
	    public void test_newDiscussion() throws Exception {
		 this.mockMvc.perform(get(new URI("/classroom/newDiscussion/"))
	                .contentType(MediaType.APPLICATION_JSON))
	                .andExpect(status().is2xxSuccessful());
	    }
	 @Test
	    public void test_platformDiscussion() throws Exception {
		 List<Platformdiscussion> list = new ArrayList();
		 when(platformService.getPlatformDiscussion(Long.parseLong("1"))).thenReturn(list);
		 this.mockMvc.perform(get(new URI("/classroom/platformDiscussion/")).param("id", "1")
	                .contentType(MediaType.APPLICATION_JSON))
	                .andExpect(status().is2xxSuccessful());
	    }

}
