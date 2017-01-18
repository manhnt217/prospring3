package com.apress.prospring3.ch7.aspectjintegration;

import org.springframework.context.support.GenericXmlApplicationContext;

public class UsingAspectJ {
	public static void main(String[] args) {

		GenericXmlApplicationContext context = new GenericXmlApplicationContext();
		context.load("classpath:META-INF/spring/aspectj-integration.xml");
		context.refresh();
		
		MessageWriter bean = new MessageWriter();
		bean.writeMessage();
		bean.foo();
	}
}
