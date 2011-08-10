package com.hdm.guestbook.model;

import java.io.Serializable;
import java.sql.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class Overview implements Serializable {
	private static final long serialVersionUID = 1L;

	// Persistent Fields:
	@Id
	@GeneratedValue
	Long id;
	private String user;
	private Date timetamp;
	private String text;
	
	// Constructors:
	public Overview() {
	}

	public Overview(String user, Date timetamp, String text) {
		this.user = user;
		this.timetamp = timetamp;
		this.text = text;
	}

	// String Representation:
	@Override
	public String toString() {
		return user + ", " + timetamp + ", " + text;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Date getTimetamp() {
		return timetamp;
	}

	public void setTimetamp(Date timetamp) {
		this.timetamp = timetamp;
	}

	public String getText() {
		return text;
	}

	public void setText(String text) {
		this.text = text;
	}

	public void setUser(String user) {
		this.user= user;
	}
	
	public String getUser() {
		return this.user;
	}
}