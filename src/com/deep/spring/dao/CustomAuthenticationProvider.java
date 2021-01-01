package com.deep.spring.dao;

import java.util.Collection;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Component;

//@Component("customAuthenticationProvider")
public class CustomAuthenticationProvider implements AuthenticationProvider{
	
	@Autowired
	private CustomUserDetailService userService;

	public Authentication authenticate(Authentication authentication) throws AuthenticationException {
		
		System.out.println("Entered authenticate method in CustomAuthenticationProvider");
		String passedusername = authentication.getName();
		String passedpassword = (String) authentication.getCredentials();
		
		System.out.println(" passedusername and password: " + passedusername + " " + passedpassword);
		
		UserDetails originaluser = userService.loadUserByUsername(passedusername);
		
		if(originaluser == null || !originaluser.getUsername().equalsIgnoreCase(passedusername)) {
			System.out.println("BadCredentialsException occurred");
			throw new BadCredentialsException("User not found");
		}
		
		if(!passedpassword.equalsIgnoreCase(originaluser.getPassword())) {
			System.out.println("BadCredentialsException occurred");
			throw new BadCredentialsException("Username or Password Invalid");
		}
		
		Collection<? extends GrantedAuthority> authorities = originaluser.getAuthorities();
		
		return new UsernamePasswordAuthenticationToken(originaluser, originaluser.getPassword(), authorities);
	}

	public boolean supports(Class<?> arg0) {
		return true;
	}
	
	/*
	 * public void setUserinSession(HttpSession session, String username) {
	 * session.setAttribute("useremail", username); }
	 */

}
