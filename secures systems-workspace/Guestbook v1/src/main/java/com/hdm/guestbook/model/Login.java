package com.hdm.guestbook.model;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Login implements Serializable {
	private static final long serialVersionUID = 1L;

	// Persistent Fields:
	@Id
	private String name;
	private String password;

	// Constructors:
	public Login() {
	}

	public Login(String name, String password) {
		this.name = name;
		this.password = password;
	}

	// String Representation:
	@Override
	public String toString() {
		return name + ", " + password;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

}
