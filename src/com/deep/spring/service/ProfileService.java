package com.deep.spring.service;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.deep.spring.dao.ProfileDAO;
import com.deep.spring.entity.Instructor;
import com.deep.spring.entity.Profile;

@Service
public class ProfileService {

	@Autowired
	private ProfileDAO profileDAO;
	
	@Transactional
	public void saveProfile(Profile profile) {
		profileDAO.saveProfile(profile);
	}
}
