package com.apress.prospring3;

import org.springframework.context.support.GenericXmlApplicationContext;
import org.springframework.core.convert.ConversionService;
import org.springframework.format.support.FormattingConversionServiceFactoryBean;

import com.apress.prospring3.domain.Contact;

public class Main {

	public static void main(String[] args) {

		GenericXmlApplicationContext context = new GenericXmlApplicationContext();
		context.load("classpath:META-INF/spring/app-context.xml");
		context.refresh();
		
		Contact contact = context.getBean("contact", Contact.class);
		
		displayContactDetail(contact);
		
		ConversionService formattingService = context.getBean("formattingService", ConversionService.class);
		System.out.println("Date of birth: " + formattingService.convert(contact.getBirthDate(), String.class));
		
		context.close();
	}

	private static void displayContactDetail(Contact contact) {

		System.out.println("===============================================");
		System.out.println(contact.getFirstName());
		System.out.println(contact.getLastName());
		System.out.println(contact.getBirthDate());
		System.out.println(contact.getUrl());
		System.out.println("===============================================");
	}
}
