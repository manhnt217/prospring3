package com.apress.prospring.ch9;

import java.util.List;

import org.apache.commons.logging.LogFactory;
import org.springframework.context.support.GenericXmlApplicationContext;

import com.apress.prospring.ch9.dao.ContactDao;
import com.apress.prospring.ch9.hibernate.Contact;
import com.apress.prospring.ch9.hibernate.ContactTelDetail;
import com.apress.prospring.ch9.hibernate.Hobby;

public class SpringHibernateSample {
	public static void main(String[] args) {

		GenericXmlApplicationContext ctx = new GenericXmlApplicationContext();
		ctx.load("classpath:META-INF/spring/app-context.xml");
		ctx.refresh();
		
		ContactDao contactDao = ctx.getBean("contactDao", ContactDao.class);
		/*Contact contact = new Contact();
		contact.setFirstName("Michael");
		contact.setLastName("Jackson");
		contact.setBirthDate(new Date());
		ContactTelDetail contactTelDetail = new ContactTelDetail("Home", "1111111111");
		contact.addContactTelDetail(contactTelDetail);
		contactTelDetail = new ContactTelDetail("Mobile", "2222222222");
		contact.addContactTelDetail(contactTelDetail);
		contactDao.save(contact);
		List<Contact> contacts = contactDao.findAllWithDetail();
		listContactsWithDetail(contacts);*/
		List<Contact> contacts = contactDao.findAll();
		LogFactory.getLog(SpringHibernateSample.class).info("Blah");
		listContactsWithDetail(contacts);
	}

	@SuppressWarnings("unused")
	private static void listContacts(List<Contact> contacts) {

		System.out.println("");
		System.out.println("Listing contacts without details:");
		for (Contact contact : contacts) {
			System.out.println(contact);
			System.out.println();
		}
	}

	private static void listContactsWithDetail(List<Contact> contacts) {

		System.out.println("");
		System.out.println("Listing contacts with details:");
		for (Contact contact : contacts) {
			System.out.println(contact);
			if (contact.getContactTelDetails() != null) {
				for (ContactTelDetail contactTelDetail : contact.getContactTelDetails()) {
					System.out.println(contactTelDetail);
				}
			}
			if (contact.getHobbies() != null) {
				for (Hobby hobby : contact.getHobbies()) {
					System.out.println(hobby);
				}
			}
			System.out.println();
		}
	}
}