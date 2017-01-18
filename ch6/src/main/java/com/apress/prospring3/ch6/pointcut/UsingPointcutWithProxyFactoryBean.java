package com.apress.prospring3.ch6.pointcut;

import org.springframework.context.support.GenericXmlApplicationContext;

public class UsingPointcutWithProxyFactoryBean {

	/**
	 * @param args
	 */
	public static void main(String[] args) {

		GenericXmlApplicationContext context = new GenericXmlApplicationContext("classpath:META-INF/spring/app-context.xml");
		SampleBean sampleBean = (SampleBean) context.getBean("pfBean");
		sampleBean.foo(100);
		sampleBean.foo(10);
		sampleBean.foo(100);
		sampleBean.foo(100);
		sampleBean.bar(10);
		sampleBean.bar(100);
		sampleBean.bar(10);
		sampleBean.bar(10);
		sampleBean.bar(10);
	}

}
