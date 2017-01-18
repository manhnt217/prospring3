package com.apress.prospring3.ch7.aspectjannotiation;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component("bean")
public class MyBean {

	@Autowired
	private MyDependency myDep;

	public void setMyDependency(MyDependency myDependency) {

		this.myDep = myDependency;
	}

	public void execute() {

		myDep.foo(100);
		myDep.foo(101);
		myDep.bar();
	}
}
