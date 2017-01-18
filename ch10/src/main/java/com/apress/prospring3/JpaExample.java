package com.apress.prospring3;

import java.util.Date;
import java.util.List;
import java.util.Set;

import org.springframework.context.support.GenericXmlApplicationContext;

import com.apress.prospring3.domain.Contact;
import com.apress.prospring3.domain.ContactTelDetail;
import com.apress.prospring3.domain.Hobby;
import com.apress.prospring3.service.ContactService;


public class JpaExample {

	public static void main(String[] args) {

		GenericXmlApplicationContext context = new GenericXmlApplicationContext();
		context.load("classpath:META-INF/spring/app-context.xml");
		context.refresh();
		
		ContactService contactService = (ContactService) context.getBean("contactService");
		
		Contact contact = new Contact(); 
		contact.setFirstName("Michael"); 
		contact.setLastName("Jackson"); 
		contact.setBirthDate(new Date()); 
		ContactTelDetail contactTelDetail = 
		new ContactTelDetail("Home", "1111111111"); 
		contact.addContactTelDetail(contactTelDetail); 
		contactTelDetail = new ContactTelDetail("Mobile", "2222222222"); 
		contact.addContactTelDetail(contactTelDetail); 
		
		contactService.save(contact);
		
		List<Contact> contacts = contactService.findAllWithDetail();
		listContact(contacts);
	}

	private static void listContact(List<Contact> contacts) {

		for (Contact contact : contacts) {
			System.out.println(contact);
			Set<Hobby> hobbies = contact.getHobbies();
			for (Hobby hobby : hobbies) {
				System.out.println("\tHobby: " + hobby.toString());
			}
		}
	}
}
