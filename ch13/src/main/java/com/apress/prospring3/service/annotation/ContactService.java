package com.apress.prospring3.service.annotation;

import java.util.List;

import com.apress.prospring3.domain.Contact;

public interface ContactService {

	public List<Contact> findAll();

	public Contact findById(Long id);

	public Contact save(Contact contact);

	public long countAll();
}
