package com.ucmo.virtualclassroom.controller;

import static org.mockito.Matchers.any;
import static org.mockito.Mockito.doNothing;
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
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.springframework.http.MediaType;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContext;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import com.ucmo.virtualclassroom.config.MyUserPrincipal;
import com.ucmo.virtualclassroom.model.PlatformForm;
import com.ucmo.virtualclassroom.model.PlatformModel;
import com.ucmo.virtualclassroom.model.Platformdiscussion;
import com.ucmo.virtualclassroom.model.RegistrationModel;
import com.ucmo.virtualclassroom.service.PlatformService;
import com.ucmo.virtualclassroom.utils.TestUtils;
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
	        RegistrationModel model = new RegistrationModel();
	        model.setFirstname("");
	        model.setLastname("");
	        MyUserPrincipal principal = new MyUserPrincipal(model);
	    	Authentication authentication = Mockito.mock(Authentication.class);
			SecurityContext securityContext = Mockito.mock(SecurityContext.class);
			Mockito.when(securityContext.getAuthentication()).thenReturn(authentication);
			Mockito.when(authentication.getPrincipal()).thenReturn(principal);
			SecurityContextHolder.setContext(securityContext);
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
	 
	 @Test
	    public void test_submitRegistration() throws Exception {
		 PlatformForm request = new PlatformForm();
		 PlatformModel model = new PlatformModel();
		 Platformdiscussion discussion = new Platformdiscussion();
		 when(platformService.saveDiscussion(any(PlatformModel.class))).thenReturn(model);
		 when(platformService.savePlatformDiscussion(any(Platformdiscussion.class))).thenReturn(discussion);

		   this.mockMvc.perform(post("/classroom/submitDiscussion").content(TestUtils.asJsonString(request))
	                .contentType(MediaType.APPLICATION_JSON))
	                .andExpect(status().is2xxSuccessful());
	    }
	 
	 @Test
	    public void test_replyDiscussion() throws Exception {
		 PlatformForm request = new PlatformForm();
		 PlatformModel model = new PlatformModel();
		 Platformdiscussion discussion = new Platformdiscussion();
		 when(platformService.saveDiscussion(any(PlatformModel.class))).thenReturn(model);
		 when(platformService.savePlatformDiscussion(any(Platformdiscussion.class))).thenReturn(discussion);
		 when(platformService.getPlatformModel(any(Long.class))).thenReturn(model);
		   this.mockMvc.perform(post("/classroom/replyDiscussion").content(TestUtils.asJsonString(request))
	                .contentType(MediaType.APPLICATION_JSON))
	                .andExpect(status().is2xxSuccessful());
	    }
	 
	 @Test
	    public void test_deleteDiscussion() throws Exception {
		 PlatformModel model = new PlatformModel();
		 doNothing().when(platformService).deleteDiscussion(any(Long.class));
		 when(platformService.getPlatformModel(any(Long.class))).thenReturn(model);
		   this.mockMvc.perform(post("/classroom/deleteDiscussion").param("id", "1")
	                .contentType(MediaType.APPLICATION_JSON))
	                .andExpect(status().is2xxSuccessful());
	    }

}
