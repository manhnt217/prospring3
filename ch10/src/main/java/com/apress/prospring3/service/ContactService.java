package com.apress.prospring3.service;

import java.util.List;

import com.apress.prospring3.domain.Contact;

public interface ContactService {

	public List<Contact> findAllWithDetail();
	
	public Contact findByFirstName(String firstName);
	
	public Contact findByFirstNameAndLastName(String firstName, String lastName);
	
	public Contact save(Contact contact);
}
