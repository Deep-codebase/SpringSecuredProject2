package com.deep.spring.entity;

import javax.persistence.Column;

public class VendorModel {

	private String vendorname;

	private String vendorproduct;

	public VendorModel() {
		
	}

	public String getVendorname() {
		return vendorname;
	}

	public void setVendorname(String vendorname) {
		this.vendorname = vendorname;
	}

	public String getVendorproduct() {
		return vendorproduct;
	}

	public void setVendorproduct(String vendorproduct) {
		this.vendorproduct = vendorproduct;
	}

	@Override
	public String toString() {
		return "VendorModel [vendorname=" + vendorname + ", vendorproduct=" + vendorproduct + "]";
	}
	
	
	
}
