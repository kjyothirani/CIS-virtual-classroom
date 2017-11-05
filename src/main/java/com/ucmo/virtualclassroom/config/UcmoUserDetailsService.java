package com.ucmo.virtualclassroom.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.ucmo.virtualclassroom.model.RegistrationModel;
import com.ucmo.virtualclassroom.repository.RegistrationRepository;
@Service("userDetailsService")
public class UcmoUserDetailsService implements UserDetailsService{
	
	@Autowired
	private RegistrationRepository registrationRepository; 

	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		RegistrationModel model =registrationRepository.findByStudentID(username);
		return new MyUserPrincipal(model);
	}

}
