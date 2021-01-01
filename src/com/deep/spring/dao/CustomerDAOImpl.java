package com.deep.spring.dao;

import java.util.List;

import javax.transaction.Transactional;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.deep.spring.entity.Customer;

@Repository
public class CustomerDAOImpl implements CustomerDAO {

	@Autowired
    private SessionFactory sessionFactory;
    
    @Transactional
    public List<Customer> getCustomers() {
        Session currentSession = sessionFactory.getCurrentSession();
        
        Query<Customer> theQuery
                = currentSession.createQuery("from Customer order by id asc", Customer.class);
        
        List<Customer> customers = theQuery.getResultList();
        
        return customers;
    }

    
    public void saveCustomer(Customer theCustomer) {
        Session currentSession = sessionFactory.getCurrentSession();
        
        currentSession.saveOrUpdate(theCustomer);
    }

    @Transactional
    public Customer getCustomer(int theId) {
        Session currentSession = sessionFactory.getCurrentSession();
        
        Customer theCustomer = currentSession.get(Customer.class, theId);
        
        return theCustomer;
    }

}
