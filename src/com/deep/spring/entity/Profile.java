package com.deep.spring.entity;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "user_profile")
public class Profile {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	private int id;
	
	@Column(name = "name")
	private String personname;
	
	@Column(name = "dob")
	private String dob;
	
	@Column(name = "phoneNo")
	private String phoneNo;
	
	
	
	public Profile() {
		
	}
	
	

	public Profile(String personname, String dob, String phoneNo) {
		super();
		this.personname = personname;
		this.dob = dob;
		this.phoneNo = phoneNo;
	}



	@OneToMany(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
	@JoinColumn(name = "profileid")
	private List<CompanyName> companies;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getPersonname() {
		return personname;
	}

	public void setPersonname(String personname) {
		this.personname = personname;
	}

	public String getDob() {
		return dob;
	}

	public void setDob(String dob) {
		this.dob = dob;
	}

	public String getPhoneNo() {
		return phoneNo;
	}

	public void setPhoneNo(String phoneNo) {
		this.phoneNo = phoneNo;
	}
	

	public List<CompanyName> getCompanies() {
		return companies;
	}

	public void setCompanies(List<CompanyName> companies) {
		this.companies = companies;
	}

	
	public void addCompany(CompanyName companyName) {
		if(companies == null) {
			companies = new ArrayList<CompanyName>();
		}
		
		companies.add(companyName);
	}
	
	@Override
	public String toString() {
		return "Profile [id=" + id + ", personname=" + personname + ", dob=" + dob + ", phoneNo=" + phoneNo + "]";
	}
	
	
	
	
}
