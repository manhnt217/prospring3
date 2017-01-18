package com.vsii.spring.bookstore.view.vaadin.ui;

import com.vaadin.annotations.VaadinServletConfiguration;
import com.vaadin.server.VaadinServlet;

@VaadinServletConfiguration(productionMode = false, ui = HelloWorldUI.class, widgetset = "com.vsii.spring.bookstore.view.vaadin.AppWidgetSet")
public class HelloWorldServlet extends VaadinServlet {

	private static final long serialVersionUID = 3408490956686245079L;

}