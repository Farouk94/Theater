package com.model;

import java.io.Serializable;
import javax.persistence.*;


/**
 * The persistent class for the user_registration database table.
 * 
 */
@Entity
@Table(name="user_registration")
@NamedQuery(name="UserRegistration.findAll", query="SELECT u FROM UserRegistration u")
public class UserRegistration implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	private String name;

	private String email;

	private String password;

	public UserRegistration() {
	}

	public String getName() {
		return this.name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getEmail() {
		return this.email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPassword() {
		return this.password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

}