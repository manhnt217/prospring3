package com.apress.prospring3.ch7.introductions;

import org.springframework.context.support.GenericXmlApplicationContext;

public class UsingIntroductionWithProxyFactoryBean {

	/**
	 * @param args
	 */
	public static void main(String[] args) {

		GenericXmlApplicationContext context = new GenericXmlApplicationContext("classpath:META-INF/spring/app-context.xml");
		SomeBean someBean = (SomeBean) context.getBean("pfBean");
		IsModified isModifiedBean = (IsModified) someBean;

		someBean.setBar(18);
		System.out.println(isModifiedBean.isModified());
		someBean.setBar(100);
		System.out.println(isModifiedBean.isModified());
		
		context.close();
	}
}
