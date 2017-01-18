package com.apress.prospring3.service;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.apress.prospring3.domain.Contact;

@Service("contactService")
@Repository
@Transactional
public class ContactServiceImpl implements ContactService {

	private Log log = LogFactory.getLog(ContactServiceImpl.class);

	@PersistenceContext
	private EntityManager em;

	@Override
	public List<Contact> findAllWithDetail() {

		return em.createNamedQuery("Contact.findAllWithDetail", Contact.class).getResultList();
	}

	@Override
	public Contact findByFirstName(String firstName) {

		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Contact findByFirstNameAndLastName(String firstName, String lastName) {

		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Contact save(Contact contact) {

		if (contact.getId() == null) {

			em.persist(contact);
		} else {
			em.persist(contact);
		}
		return contact;
	}

}
