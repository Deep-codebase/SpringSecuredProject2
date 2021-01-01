package com.deep.spring.entity;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Table;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;

@Entity
@Table(name = "vendor_details")
public class Vendor {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	private int Id;
	
	@Column(name = "vendor_name")
	private String vendorname;
	
	@Column(name = "product_name")
	private String vendorproduct;
	
	@OneToMany(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
	@JoinColumn(name = "vend_details_Id")
	private List<VendorFile> vendorFiles;
	
	public Vendor() {

	}

	public Vendor(String vendorname, String vendorproduct) {
		super();
		this.vendorname = vendorname;
		this.vendorproduct = vendorproduct;
	}

	public int getId() {
		return Id;
	}

	public void setId(int id) {
		Id = id;
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

	public void addVendorFile(VendorFile vendorFile) {
		if(vendorFiles == null) {
			vendorFiles = new ArrayList<VendorFile>();
		}
		
		vendorFiles.add(vendorFile);
	}
	
	public List<VendorFile> getVendorFiles() {
		return vendorFiles;
	}

	public void setVendorFiles(List<VendorFile> vendorFiles) {
		this.vendorFiles = vendorFiles;
	}

	@Override
	public String toString() {
		return "Vendor [Id=" + Id + ", vendorname=" + vendorname + ", vendorproduct=" + vendorproduct +"]";
	}
	
	
}
