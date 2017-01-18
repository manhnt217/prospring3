package com.apress.prospring3.ch9;

import java.util.List;
import org.springframework.context.support.GenericXmlApplicationContext;
import com.apress.prospring3.ch9.dao.ContactDao;
import com.apress.prospring3.ch9.domain.Contact;

public class SpringHibernateSample {
	public static void main(String[] args) {

		GenericXmlApplicationContext ctx = new GenericXmlApplicationContext();
		ctx.load("classpath:app-context.xml");
		ctx.refresh();
		ContactDao contactDao = ctx.getBean("contactDao", ContactDao.class);
		List<Contact> contacts = contactDao.findAll();
		listContacts(contacts);
	}

	private static void listContacts(List<Contact> contacts) {

		System.out.println("");
		System.out.println("Listing contacts without details:");
		for (Contact contact : contacts) {
			System.out.println(contact);
			System.out.println();
		}
	}
}