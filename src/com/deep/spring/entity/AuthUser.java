package com.deep.spring.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "auth_user")
public class AuthUser {

	@Id
	@Column(name = "auth_user_id")
	private int authuserId;
	
	@Column(name = "first_name")
	private String name;
	
	@Column(name = "last_name")
	private String lastname;
	
	@Column(name = "email")
	private String email;
	
	@Column(name = "password")
	private String password;
	
	@Column(name = "role")
	private String role;

	public int getAuthuserId() {
		return authuserId;
	}

	public void setAuthuserId(int authuserId) {
		this.authuserId = authuserId;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getLastname() {
		return lastname;
	}

	public void setLastname(String lastname) {
		this.lastname = lastname;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getRole() {
		return role;
	}

	public void setRole(String role) {
		this.role = role;
	}

	@Override
	public String toString() {
		return "AuthUser [authuserId=" + authuserId + ", name=" + name + ", lastname=" + lastname + ", email=" + email
				+ ", password=" + password + ", role=" + role + "]";
	}
	
	
	
}
