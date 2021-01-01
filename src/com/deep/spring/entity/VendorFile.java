package com.deep.spring.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "vendor_files")
public class VendorFile {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	private int id;
	
	@Column(name = "file_name")
	private String vendorfilename;

	public VendorFile() {

	}

	public VendorFile(String vendorfilename) {
		super();
		this.vendorfilename = vendorfilename;
	}

	

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getVendorfilename() {
		return vendorfilename;
	}

	public void setVendorfilename(String vendorfilename) {
		this.vendorfilename = vendorfilename;
	}

	@Override
	public String toString() {
		return "VendorFile [id=" + id + ", vendorfilename=" + vendorfilename + "]";
	}
	
	

}
