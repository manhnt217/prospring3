package com.apress.prospring3.ch6;

import org.springframework.aop.framework.ProxyFactory;

public class HelloAOP {

	public static void main(String[] args) {
		MessageWriter messageWriter = new MessageWriter();
		ProxyFactory proxyFactory = new ProxyFactory();
		proxyFactory.setTarget(messageWriter);
		proxyFactory.addAdvice(new MessageDecorator());
		MessageWriter proxy = (MessageWriter) proxyFactory.getProxy();
		proxy.writeMessage();
	}
}
