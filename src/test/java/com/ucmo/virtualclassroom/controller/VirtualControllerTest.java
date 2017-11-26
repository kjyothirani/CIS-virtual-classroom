package com.ucmo.virtualclassroom.controller;

import static org.mockito.Matchers.any;
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
import com.ucmo.virtualclassroom.model.Platformdiscussion;
import com.ucmo.virtualclassroom.model.RegistrationModel;
import com.ucmo.virtualclassroom.model.Subscribe;
import com.ucmo.virtualclassroom.model.VirtualHuddleModel;
import com.ucmo.virtualclassroom.service.VirtualHuddleService;
import com.ucmo.virtualclassroom.utils.TestUtils;

public class VirtualControllerTest {
	 private MockMvc mockMvc;
		
		@Mock
		private VirtualHuddleService platformService;
		
	 @InjectMocks
	private VirtualHuddleController platformController;
	
	 @Before
	    public void setup() {

	        // Process mock annotations
	        MockitoAnnotations.initMocks(this);

	        // Setup Spring test in standalone mode
	        this.mockMvc = MockMvcBuilders.standaloneSetup(platformController).build();
	        RegistrationModel model = new RegistrationModel();
	        model.setFirstname("");
	        model.setLastname("");
	        model.setId(Long.parseLong("1"));
	        MyUserPrincipal principal = new MyUserPrincipal(model);
	    	Authentication authentication = Mockito.mock(Authentication.class);
			SecurityContext securityContext = Mockito.mock(SecurityContext.class);
			Mockito.when(securityContext.getAuthentication()).thenReturn(authentication);
			Mockito.when(authentication.getPrincipal()).thenReturn(principal);
			SecurityContextHolder.setContext(securityContext);
	    }
	 
	 @Test
	    public void test_getDocuments() throws Exception {
		  this.mockMvc.perform(get(new URI("/classroom/virtualhuddle/"))
	                .contentType(MediaType.APPLICATION_JSON))
	                .andExpect(status().is2xxSuccessful());
	    }
	 
	 @Test
	    public void test_submitRegistration() throws Exception {
		 VirtualHuddleModel request = new VirtualHuddleModel();
		 Platformdiscussion discussion = new Platformdiscussion();
		 when(platformService.saveHuddle(any(VirtualHuddleModel.class))).thenReturn(true);

		   this.mockMvc.perform(post("/classroom/submithuddle").content(TestUtils.asJsonString(request))
	                .contentType(MediaType.APPLICATION_JSON))
	                .andExpect(status().is2xxSuccessful());
	    }
	 
	 @Test
	    public void test_listHuddles() throws Exception {
		 List<VirtualHuddleModel> list = new ArrayList<>();
		 List<Subscribe> subList = new ArrayList<>();
		 when(platformService.getAll()).thenReturn(list);
		 when(platformService.getSubscribedHuddles(Long.parseLong("1"))).thenReturn(subList);
		  this.mockMvc.perform(get(new URI("/classroom/listhuddles/"))
	                .contentType(MediaType.APPLICATION_JSON))
	                .andExpect(status().is2xxSuccessful());
	    }
	 
	 @Test
	    public void test_subscribeHuddles() throws Exception {
		 when(platformService.subscribeHuddle(any(Subscribe.class))).thenReturn(Boolean.TRUE);
		   this.mockMvc.perform(post("/classroom/submithuddle").param("id", "1")
	                .contentType(MediaType.APPLICATION_JSON))
	                .andExpect(status().is2xxSuccessful());
	    }

}
