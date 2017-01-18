package com.apress.prospring3.ch7.aspectjannotiation;

import org.springframework.context.support.GenericXmlApplicationContext;

public class UsingAspectJAnnotation {
	public static void main(String[] args) {

		GenericXmlApplicationContext context = new GenericXmlApplicationContext();

		context.load("classpath:META-INF/spring/aspectjannotation.xml");
		context.refresh();
		
		MyBean bean = (MyBean) context.getBean("bean");
		bean.execute();
		context.close();
	}
}
