package com.apress.prospring3.ch7.introductions;

import org.springframework.aop.framework.ProxyFactory;

public class UsingIntroduction {

	/**
	 * @param args
	 */
	public static void main(String[] args) {

		SomeBean someBean = new SomeBean();

		ProxyFactory proxyFactory = new ProxyFactory();
		proxyFactory.setTarget(someBean);
		proxyFactory.addAdvisor(new IsModifiedAdvisor());
		proxyFactory.setOptimize(true);//Using CGLIB proxy

		SomeBean proxy = (SomeBean) proxyFactory.getProxy();
		IsModified proxyInterface = (IsModified) proxy;

		proxy.setBar(18);
		System.out.println(proxyInterface.isModified());
		proxy.setBar(108);
		System.out.println(proxyInterface.isModified());
	}

}
