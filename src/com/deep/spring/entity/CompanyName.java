package com.deep.spring.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "companynames")
public class CompanyName {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name = "id")
	private int id;
	
	@Column(name = "company")
	private String companyname;

	public CompanyName() {
		
	}
	
	public CompanyName(String companyname) {
		super();
		this.companyname = companyname;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getCompanyname() {
		return companyname;
	}

	public void setCompanyname(String companyname) {
		this.companyname = companyname;
	}



	@Override
	public String toString() {
		return "CompanyName [id=" + id + ", companyname=" + companyname + "]";
	}

	
	
}
