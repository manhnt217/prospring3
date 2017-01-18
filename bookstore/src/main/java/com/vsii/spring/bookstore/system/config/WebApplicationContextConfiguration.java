package com.vsii.spring.bookstore.system.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.format.support.FormattingConversionService;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;
import org.springframework.web.servlet.mvc.method.annotation.RequestMappingHandlerAdapter;
import org.springframework.web.servlet.mvc.method.annotation.RequestMappingHandlerMapping;
import org.springframework.web.servlet.view.InternalResourceViewResolver;

import com.vsii.spring.bookstore.controller.HomeController;
import com.vsii.spring.bookstore.model.conversion.CategoryFormatter;
import com.vsii.spring.bookstore.service.AccountService;

@Configuration
@EnableWebMvc
@ComponentScan(basePackageClasses = { AccountService.class, HomeController.class })
public class WebApplicationContextConfiguration extends WebMvcConfigurerAdapter {

	/* ======================== Handler ======================== */

	/*@Bean(name="/VAADIN/*")
	public ServletForwardingController vaadinServletForwardingController() {

		//Forward vaadin request
		ServletForwardingController servletForwardingController = new ServletForwardingController();
		servletForwardingController.setServletName("vaadinServlet");
		return servletForwardingController;
	}

	@Bean(name= "/hello/*")
	public ServletForwardingController helloWorldServletForwardingController() {

		//Forward vaadin request
		ServletForwardingController servletForwardingController = new ServletForwardingController();
		servletForwardingController.setServletName("helloWorldServlet");
		return servletForwardingController;
	}*/

	/* ======================== Handler Mapping ======================== */
	@Bean
	public RequestMappingHandlerMapping requestMappingHandlerMapping() {

		RequestMappingHandlerMapping requestMappingHandlerMapping = new RequestMappingHandlerMapping();
		/*requestMappingHandlerMapping.setOrder(1);*/
		return requestMappingHandlerMapping;
	}

	/* Handler Adapter */

	@Bean
	public RequestMappingHandlerAdapter requestMappingHandlerAdapter() {

		RequestMappingHandlerAdapter adapter = new RequestMappingHandlerAdapter();
//		ConfigurableWebBindingInitializer webBindingInitializer = new ConfigurableWebBindingInitializer();
//		webBindingInitializer.setDirectFieldAccess(true);
//		adapter.setWebBindingInitializer(webBindingInitializer);
		return adapter;
	}

	/* ======================== View Resolver ======================== */

	@Bean
	public InternalResourceViewResolver internalResourceViewResolver() {

		InternalResourceViewResolver viewResolver = new InternalResourceViewResolver();
		viewResolver.setPrefix("/WEB-INF/views/");
		viewResolver.setSuffix(".jsp");
		return viewResolver;
	}

	/* ======================== Conversion Service ======================== */

	@Bean(name = "conversionService")
	public FormattingConversionService formattingConversionService() {

		FormattingConversionService conversionService = new FormattingConversionService();
		conversionService.addFormatter(new CategoryFormatter());
		return conversionService;
	}
}
