package com.deep.spring.dao;

import java.util.List;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Path;
import javax.persistence.criteria.Root;
import javax.transaction.Transactional;

import org.hibernate.Criteria;
import org.hibernate.FetchMode;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.deep.spring.entity.Customer;
import com.deep.spring.entity.Vendor;

@Repository
public class VendorDAOImpl implements VendorDAO {

	@Autowired
	private SessionFactory sessionFactory;

	public List<Vendor> loadAllVendors() {
		return null;
	}

	public void saveVendor(Vendor vendor) {
		Session session = sessionFactory.getCurrentSession();
		session.save(vendor);
		System.out.println("Vendor saved");
	}

	public List<Vendor> getVendorDetails() {
		Session currentSession = sessionFactory.getCurrentSession();

//		Query<Vendor> theQuery = currentSession.createQuery("from Vendor order by id asc", Vendor.class);
//
//		List<Vendor> vendors = theQuery.getResultList();
		
//		Criteria criteria = currentSession.createCriteria(Vendor.class);
//		List vendors = criteria.list();
		/*
		 * CriteriaBuilder builder = currentSession.getCriteriaBuilder();
		 * CriteriaQuery<Vendor> criteriaQuery = builder.createQuery(Vendor.class);
		 * Root<Vendor> root = criteriaQuery.from(Vendor.class); Path<Object> venname =
		 * root.get("sgdfg"); Path<Object> venemail = root.get("email");
		 * 
		 * criteriaQuery.select(builder.construct(Vendor.class, ));
		 */
		
		
		Criteria criteria = currentSession.createCriteria(Vendor.class)
							   .setFetchMode("vendorFiles", FetchMode.LAZY);
		criteria.setFirstResult(0);
		criteria.setMaxResults(5);
		List vendors = criteria.list();
		return vendors;
	}
	
	public List<Vendor> getVendorDetails(int start) {
		Session currentSession = sessionFactory.getCurrentSession();
	
		System.out.println("overloaded repo vendors");
		Criteria criteria = currentSession.createCriteria(Vendor.class)
							   .setFetchMode("vendorFiles", FetchMode.LAZY);
		criteria.setFirstResult(start+1);
		criteria.setMaxResults(5);
		List vendors = criteria.list();
		return vendors;
	}

}
