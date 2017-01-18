package com.apress.prospring3.ch6.pointcut;

import org.aopalliance.intercept.MethodInterceptor;
import org.aopalliance.intercept.MethodInvocation;

public class SimpleAdvice implements MethodInterceptor {

	public Object invoke(MethodInvocation methodInvocation) throws Throwable {
		System.out.println("+++++++");
		Object returnValue = methodInvocation.proceed();
		System.out.println("=======");
		return returnValue;
	}

}
