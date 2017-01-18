package com.apress.prospring3.ch7.introductions;

public class SomeBean {

	private String foo;
	private int bar;

	public SomeBean() {

		this.foo = "18 and life";
		this.bar = 18;
	}

	public String getFoo() {

		return foo;
	}

	public void setFoo(String foo) {

		this.foo = foo;
	}

	public int getBar() {

		return bar;
	}

	public void setBar(int bar) {

		this.bar = bar;
	}

}
