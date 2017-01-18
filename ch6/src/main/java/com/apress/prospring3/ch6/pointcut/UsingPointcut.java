package com.apress.prospring3.ch6.pointcut;

import org.aopalliance.aop.Advice;
import org.springframework.aop.Pointcut;
import org.springframework.aop.framework.ProxyFactory;
import org.springframework.aop.support.DefaultPointcutAdvisor;

public class UsingPointcut {

	public static void main(String[] args) {
		SampleBean messageWriter = new SampleBean();
		Pointcut pointcut = new SimpleDynamicPointcut();
		Advice advice = new SimpleAdvice();
		DefaultPointcutAdvisor advisor = new DefaultPointcutAdvisor(pointcut, advice);
		ProxyFactory proxyFactory = new ProxyFactory();
		proxyFactory.addAdvisors(advisor);
		proxyFactory.setTarget(messageWriter);
		
		SampleBean proxy = (SampleBean) proxyFactory.getProxy();
		
		proxy.foo(1);
		proxy.foo(10);
		proxy.foo(100);
		proxy.foo(100);
		proxy.foo(101);
		proxy.bar(1);
		proxy.bar(2);
		proxy.bar(3);
	}
}
