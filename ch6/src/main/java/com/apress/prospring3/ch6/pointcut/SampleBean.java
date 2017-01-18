package com.apress.prospring3.ch6.pointcut;

public class SampleBean {
	public void foo(int x) {

		System.out.println("Invoked foo() with: " + x);
	}

	public void bar(int y) {

		System.out.println("Invoked bar()");
	}
}