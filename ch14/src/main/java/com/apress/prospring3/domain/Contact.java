package com.apress.prospring3.domain;

import java.net.URL;

import org.joda.time.DateTime;


public class Contact {
	private String firstName;
	private String lastName;
	private DateTime birthDate;
	private URL url;
	
	public String getFirstName() {
	
		return firstName;
	}
	
	public void setFirstName(String firstName) {
	
		this.firstName = firstName;
	}
	
	public String getLastName() {
	
		return lastName;
	}
	
	public void setLastName(String lastName) {
	
		this.lastName = lastName;
	}
	
	public DateTime getBirthDate() {
	
		return birthDate;
	}
	
	public void setBirthDate(DateTime birthDate) {
	
		this.birthDate = birthDate;
	}
	
	public URL getUrl() {
	
		return url;
	}
	
	public void setUrl(URL url) {
	
		this.url = url;
	}
	
}
