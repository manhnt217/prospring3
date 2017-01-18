package com.apress.prospring3.ch8.jdbc.annotation;

import java.util.List;

import org.springframework.context.support.GenericXmlApplicationContext;

import com.apress.prospring3.ch8.dao.Contact;
import com.apress.prospring3.ch8.dao.ContactDao;
import com.apress.prospring3.ch8.dao.ContactTelDetail;

public class JdbcAnnotationTest {
	public static void main(String[] args) {

		try (GenericXmlApplicationContext context = new GenericXmlApplicationContext()) {
			context.load("classpath:jdbc-annotation-beans.xml");
			context.refresh();

			ContactDao contactDao = context.getBean("contactDao", ContactDao.class);
			List<Contact> contacts = contactDao.findAll();
			listContacts(contacts);
		}
	}

	private static void listContacts(List<Contact> contacts) {

		for (Contact contact : contacts) {
			System.out.println(contact.getFirstName());
			if (contact.getContactTelDetails() != null) {
				for (ContactTelDetail contactTelDetail : contact.getContactTelDetails()) {
					System.out.println("---" + contactTelDetail);
				}
			}
			System.out.println();
		}
	}
}
