package com.deep.spring.service;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.deep.spring.dao.CustomerDAO;
import com.deep.spring.entity.Customer;

@Service
public class CustomerService {

	@Autowired
	private CustomerDAO customerDAO;
	
	@Transactional
	public void saveCustomer(Customer theCustomer) {
		customerDAO.saveCustomer(theCustomer);
	}
}
