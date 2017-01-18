package com.apress.prospring3.ch7.aopns;

public class MyBean {
	private MyDependency myDependency;

	public void setMyDependency(MyDependency myDependency) {
	
		this.myDependency = myDependency;
	}
	
	public void execute() {
		myDependency.foo(100);
		myDependency.foo(101);
		myDependency.bar();
	}
}
