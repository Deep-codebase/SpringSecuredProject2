package com.deep.spring.dao;

import com.deep.spring.entity.AuthUser;

public interface UserDAO {

	public AuthUser loadByEmail(String email);
	
	public void saveAuthUser(AuthUser authuser);
}
