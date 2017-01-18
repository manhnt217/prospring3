package com.apress.prospring3.ch2;


//@Service("messageProvider")
public class HelloWorldMessageProvider implements MessageProvider {

	public String getMessage() {
		return "Hello World!";
	}

}
