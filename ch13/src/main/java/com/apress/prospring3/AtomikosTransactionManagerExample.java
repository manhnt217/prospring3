package com.apress.prospring3;

import java.util.Date;

import org.springframework.context.support.GenericXmlApplicationContext;

import com.apress.prospring3.domain.Contact;
import com.apress.prospring3.service.jta.ContactService;

public class AtomikosTransactionManagerExample {

	public static void main(String[] args) {

		GenericXmlApplicationContext context = new GenericXmlApplicationContext();
		context.load("classpath:META-INF/spring/tx-jta-app-context.xml");
		context.refresh();
		
		ContactService contactService = context.getBean("contactService", ContactService.class);
		Contact contact = new Contact();
		contact.setFirstName("Adam");
		contact.setLastName("Johnson");
		contact.setBirthDate(new Date());
		contact.setVersion(1);
		Contact returnedContact = contactService.save(contact);
		
		System.out.println("Done! " + returnedContact.getId());
		context.close();
	}
}
