package com.deep.spring.dao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.authority.AuthorityUtils;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Component;

import com.deep.spring.entity.AuthUser;

@Component("userdetailservice")
public class CustomUserDetailService implements UserDetailsService {

	@Autowired
	private UserDAO userDAO;

	public UserDetails loadUserByUsername(String useremail) throws UsernameNotFoundException {
		System.out.println("loadUserByUsername method");
		AuthUser authuser = userDAO.loadByEmail(useremail);
		System.out.println("saved pass: "+authuser.getPassword());
		if (authuser != null) {
			return new User(authuser.getEmail(), authuser.getPassword(),
					AuthorityUtils.createAuthorityList(authuser.getRole()));
		}
		else {
			return null;
		}
	}

}
