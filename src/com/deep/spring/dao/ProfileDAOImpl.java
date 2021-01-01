package com.deep.spring.dao;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.deep.spring.entity.Instructor;
import com.deep.spring.entity.Profile;

@Repository
public class ProfileDAOImpl implements ProfileDAO{

	@Autowired
	private SessionFactory sessionFactory;
	
	public void saveProfile(Profile profile) {

		Session currentsession = sessionFactory.getCurrentSession();
		currentsession.save(profile);
	}

}
