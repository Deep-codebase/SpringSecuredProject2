package com.deep.spring.dao;

import javax.transaction.Transactional;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.deep.spring.entity.AuthUser;

@Repository
public class UserDaoImpl implements UserDAO {

	@Autowired
	private SessionFactory sessionFactory;

	@Transactional
	public AuthUser loadByEmail(String email) {
		Session session = sessionFactory.getCurrentSession();
		Query query = session.createQuery("from AuthUser where email = :email");
		query.setParameter("email", email);
		AuthUser authuser = null;
		if (query.list().size() > 0) {
			authuser = (AuthUser) query.list().get(0);
		}
		return authuser;
	}

	public void saveAuthUser(AuthUser authuser) {
		Session session = sessionFactory.getCurrentSession();
		session.save(authuser);
	}

}
