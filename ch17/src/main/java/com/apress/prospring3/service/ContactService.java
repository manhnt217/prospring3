package com.apress.prospring3.service;

import java.util.List;

import com.apress.prospring3.domain.Contact;

public interface ContactService {

	List<Contact> findAll();

	Contact findById(Long id);

	Contact save(Contact contact);
}
