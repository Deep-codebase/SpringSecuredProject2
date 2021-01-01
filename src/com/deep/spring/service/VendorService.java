package com.deep.spring.service;

import java.util.List;

import javax.transaction.Transactional;

import org.hibernate.Query;
import org.hibernate.Session;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.deep.spring.dao.VendorDAO;
import com.deep.spring.entity.Customer;
import com.deep.spring.entity.Vendor;

@Service
public class VendorService {

	@Autowired
	private VendorDAO vendorDAO;

	@Transactional
	public void saveVendor(Vendor vendor) {
		vendorDAO.saveVendor(vendor);
	}

	
	@Transactional
	public List<Vendor> getVendorDetails() {
		List<Vendor> vendors = vendorDAO.getVendorDetails();
		return vendors;
	}
	
	@Transactional
	public List<Vendor> getVendorDetails(int start) {
		
		List<Vendor> vendors = vendorDAO.getVendorDetails(start);
		return vendors;
	}
}
