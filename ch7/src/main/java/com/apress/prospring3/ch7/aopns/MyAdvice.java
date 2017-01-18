package com.apress.prospring3.ch7.aopns;

import org.aspectj.lang.JoinPoint;

public class MyAdvice {

	public void fooBefore(JoinPoint joinPoint, int intValue) {

		if (intValue != 100) {
			System.out.println("Executing: " + joinPoint.getSignature().getDeclaringTypeName() + " "
					+ joinPoint.getSignature().getName() + " with agrument(s): " + intValue);
		}
	}
}
