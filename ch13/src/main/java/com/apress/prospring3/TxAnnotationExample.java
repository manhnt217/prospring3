package com.apress.prospring3;

import java.util.List;

import org.springframework.context.support.GenericXmlApplicationContext;

import com.apress.prospring3.domain.Contact;
import com.apress.prospring3.service.annotation.ContactService;

public class TxAnnotationExample {

	/**
	 * @param args
	 */
	public static void main(String[] args) {

		GenericXmlApplicationContext context = new GenericXmlApplicationContext();
		context.load("classpath:META-INF/spring/app-context.xml");
		context.refresh();

		ContactService contactService = (ContactService) context.getBean("contactService");
		/*List<Contact> contacts = contactService.findAll();
		listContact(contacts);
		*/
		long numberOfContact = contactService.countAll();
		System.out.println("Total number of contact is: " + numberOfContact);
		
		context.close();
	}

	private static void listContact(List<Contact> contacts) {

		for (Contact contact : contacts) {
			System.out.println(contact);
		}
	}
}
