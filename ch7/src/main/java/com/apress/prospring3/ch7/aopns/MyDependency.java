package com.apress.prospring3.ch7.aopns;

public class MyDependency {

	public void foo(int param) {
		System.out.println("foo(int): " + param);
	}
	
	public void bar() {
		System.out.println("bar()");
	}
}
