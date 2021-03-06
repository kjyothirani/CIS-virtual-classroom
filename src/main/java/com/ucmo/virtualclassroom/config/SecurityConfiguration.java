package com.ucmo.virtualclassroom.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.web.authentication.SimpleUrlAuthenticationFailureHandler;
import org.springframework.stereotype.Component;
@Configuration
@Component
@EnableWebSecurity
public class SecurityConfiguration extends WebSecurityConfigurerAdapter  {
	 
	 @Autowired
		@Qualifier("userDetailsService")
		UserDetailsService userDetailsService;

		@Autowired
		public void configureGlobal(AuthenticationManagerBuilder auth) throws Exception {
			auth.userDetailsService(userDetailsService);
			 auth.authenticationProvider(authenticationProvider());
		}
		
		@Bean
		public DaoAuthenticationProvider authenticationProvider() {
		    DaoAuthenticationProvider authProvider
		      = new DaoAuthenticationProvider();
		    authProvider.setUserDetailsService(userDetailsService);
		    return authProvider;
		}
		@Bean
		public SimpleUrlAuthenticationFailureHandler authenticationFailureHandler() {
			SimpleUrlAuthenticationFailureHandler failureHandler = new SimpleUrlAuthenticationFailureHandler();
			failureHandler.setDefaultFailureUrl("/classroom/errorpage");
			return failureHandler;
		}
   
    
    @Override
    protected void configure(HttpSecurity http) throws Exception {
    	String[] PERMITTED_URLS = { "/classroom/loginPage",  "/classroom/errorpage","/Images/**","/*css","/classroom/register","/classroom/submitRegistration","/js/**"};
        http.authorizeRequests().antMatchers(PERMITTED_URLS).permitAll().anyRequest().authenticated().and().formLogin().loginPage("/classroom/loginPage")
        .defaultSuccessUrl("/classroom/home").failureUrl("/clasroom/errorpage").failureHandler(authenticationFailureHandler())
        .usernameParameter("studentID").passwordParameter("password");
                  // it's indicate all request will be secure
        http.csrf().disable();
    }
    

}
