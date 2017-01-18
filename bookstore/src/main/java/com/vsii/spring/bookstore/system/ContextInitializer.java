package com.vsii.spring.bookstore.system;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.ServletRegistration.Dynamic;

import org.springframework.web.WebApplicationInitializer;
import org.springframework.web.context.support.AnnotationConfigWebApplicationContext;
import org.springframework.web.servlet.DispatcherServlet;

import com.vsii.spring.bookstore.system.config.WebApplicationContextConfiguration;

/**
 * Used to replace web.xml
 * 
 * @author wazi
 *
 */
public class ContextInitializer implements WebApplicationInitializer {

	@Override
	public void onStartup(ServletContext servletContext) throws ServletException {
		/*
		// Create the 'root' Spring application context
		AnnotationConfigWebApplicationContext rootContext =
		new AnnotationConfigWebApplicationContext();
		rootContext.register(AppConfig.class);
		// Manage the lifecycle of the root application context
		container.addListener(new ContextLoaderListener(rootContext));
		 */
		
		AnnotationConfigWebApplicationContext webApplicationContext = new AnnotationConfigWebApplicationContext();
		webApplicationContext.register(WebApplicationContextConfiguration.class);
		DispatcherServlet dispatcherServlet = new DispatcherServlet(webApplicationContext);
		Dynamic dispatcher = servletContext.addServlet("dispatcher", dispatcherServlet);
		dispatcher.setLoadOnStartup(1);
		dispatcher.addMapping("/");
		
		//Register VaadinServlet(s)
//		servletContext.addServlet("vaadinServlet", VaadinServlet.class);
//		servletContext.addServlet("helloWorldServlet", HelloWorldServlet.class);
		
		
		System.out.println("Initialization done!");
	}
}
