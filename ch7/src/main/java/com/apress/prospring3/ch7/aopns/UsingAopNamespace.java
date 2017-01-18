package com.apress.prospring3.ch7.aopns;

import org.springframework.context.support.GenericXmlApplicationContext;

public class UsingAopNamespace {
	
	public static void main(String[] args) {

		GenericXmlApplicationContext ctx = new GenericXmlApplicationContext();
		ctx.load("classpath:META-INF/spring/aopns.xml");
		ctx.refresh();
		MyBean myBean = (MyBean) ctx.getBean("bean");
		myBean.execute();
		
		ctx.close();
	}
}
