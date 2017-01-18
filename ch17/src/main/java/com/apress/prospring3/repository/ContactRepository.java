package com.apress.prospring3.repository;

import org.springframework.data.repository.CrudRepository;

import com.apress.prospring3.domain.Contact;

public interface ContactRepository extends CrudRepository<Contact, Long> {

}
