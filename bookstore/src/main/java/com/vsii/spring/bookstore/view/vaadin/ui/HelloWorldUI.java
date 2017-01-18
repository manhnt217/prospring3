package com.vsii.spring.bookstore.view.vaadin.ui;

import com.vaadin.annotations.Theme;
import com.vaadin.server.VaadinRequest;
import com.vaadin.ui.UI;

@Theme("mytheme")
public class HelloWorldUI extends UI {

	private static final long serialVersionUID = 1761069648017027654L;

	@Override
	protected void init(VaadinRequest request) {

		HelloWorldComponent helloWorldComponent = new HelloWorldComponent();
		setContent(helloWorldComponent);
		setSizeFull();

	}
}
