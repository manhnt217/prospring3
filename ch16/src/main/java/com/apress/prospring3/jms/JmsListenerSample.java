package com.apress.prospring3.jms;

import org.springframework.context.support.GenericXmlApplicationContext;

public class JmsListenerSample {

	public static void main(String[] args) {

		try(GenericXmlApplicationContext context = new GenericXmlApplicationContext()){
			
			context.load("classpath:jms-listener-app-context.xml");
			context.refresh();
			
			while(true) {
				
			}
		}
	}
}
