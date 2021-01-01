package com.deep.spring.service;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.deep.spring.dao.UserDAO;
import com.deep.spring.entity.AuthUser;

@Service
public class RegisterServiceImpl implements RegisterService{

	@Autowired
	private UserDAO userDAO;
	
	@Transactional
	public void saveUser(AuthUser authuser) {
		userDAO.saveAuthUser(authuser);
	}

}
