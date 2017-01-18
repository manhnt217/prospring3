package com.apress.prospring3.jms;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.support.GenericXmlApplicationContext;

import com.apress.prospring3.jms.sender.MessageSender;

public class JmsSenderSimple {

	@Autowired
	public static void main(String[] args) {

		try (GenericXmlApplicationContext context = new GenericXmlApplicationContext()) {
			context.load("classpath:jms-sender-app-context.xml");
			context.refresh();
			
			MessageSender messageSender = context.getBean("messageSender", MessageSender.class);
			messageSender.sendMessage("Hi there!");
		}
	}
}
