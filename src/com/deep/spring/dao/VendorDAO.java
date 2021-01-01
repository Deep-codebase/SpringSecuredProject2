package com.deep.spring.dao;

import java.util.List;

import com.deep.spring.entity.Vendor;

public interface VendorDAO {

	public List<Vendor> loadAllVendors();

	public void saveVendor(Vendor vendor);
	
	public List<Vendor> getVendorDetails();
	
	public List<Vendor> getVendorDetails(int start);
}
