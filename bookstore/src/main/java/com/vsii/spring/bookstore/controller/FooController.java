package com.vsii.spring.bookstore.controller;

import java.io.PrintWriter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class FooController {

	@RequestMapping(value = "/foo", method = RequestMethod.GET, params= {"p=123"})
	public ModelAndView handleRequest(HttpServletRequest request, HttpServletResponse response) throws Exception {

		PrintWriter writer = response.getWriter();
		writer.println("Hello World! You fool");
		writer.close();
		return null;
	}

}
