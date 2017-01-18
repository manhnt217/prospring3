package com.apress.prospring3.service.jpa;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.apress.prospring3.domain.Contact;
import com.apress.prospring3.repository.ContactRepository;
import com.apress.prospring3.service.ContactService;
import com.google.common.collect.Lists;

@Service("contactService")
@Repository
@Transactional
public class ContactServiceImpl implements ContactService {

	@Autowired
	private ContactRepository contactRepository;

	@Override
	@Transactional(readOnly = true)
	public List<Contact> findAll() {

		return Lists.newLinkedList(contactRepository.findAll());
	}

	@Override
	@Transactional(readOnly = true)
	public List<Contact> findByFirstName(String firstName) {

		return contactRepository.findByFirstName(firstName);
	}

	@Override
	@Transactional(readOnly = true)
	public Contact findById(Long id) {

		return contactRepository.findOne(id);
	}

	@Override
	public Contact save(Contact contact) {

		return contactRepository.save(contact);
	}

	@Override
	public void delete(Contact contact) {

		contactRepository.delete(contact);
	}

}