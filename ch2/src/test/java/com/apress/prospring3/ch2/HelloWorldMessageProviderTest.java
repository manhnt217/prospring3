package com.apress.prospring3.ch2;

import static org.junit.Assert.assertEquals;

import org.junit.Test;
import org.springframework.context.support.GenericXmlApplicationContext;

public class HelloWorldMessageProviderTest {

	@Test
	public void testGetMessage() {

		GenericXmlApplicationContext applicationContext = new GenericXmlApplicationContext("META-INF/spring/app-context-anotation.xml");
		MessageProvider provider = (MessageProvider) applicationContext.getBean("messageProvider");
		assertEquals("Hello Spring!!!", provider.getMessage());
	}
}
