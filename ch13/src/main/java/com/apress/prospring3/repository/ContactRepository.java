package com.apress.prospring3.repository;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import com.apress.prospring3.domain.Contact;


public interface ContactRepository extends CrudRepository<Contact, Long> {
	@Query("select count(c) from Contact c")
	public long countAllContacts();
}