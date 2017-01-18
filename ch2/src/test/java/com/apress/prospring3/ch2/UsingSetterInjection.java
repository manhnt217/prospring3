package com.apress.prospring3.ch2;

import org.springframework.context.support.GenericXmlApplicationContext;

public class UsingSetterInjection {
	public static void main(String[] args) {

		GenericXmlApplicationContext context = new GenericXmlApplicationContext(
				"META-INF/spring/app-context-anotation.xml");
		MessageRenderer renderer = context.getBean("messageRenderer", MessageRenderer.class);
		renderer.render();
	}
}
