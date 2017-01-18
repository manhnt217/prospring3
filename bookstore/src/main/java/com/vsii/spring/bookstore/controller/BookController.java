package com.vsii.spring.bookstore.controller;

import java.util.LinkedList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.convert.ConversionService;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.vsii.spring.bookstore.model.Book;
import com.vsii.spring.bookstore.model.BookSearchCriteria;
import com.vsii.spring.bookstore.model.Category;
import com.vsii.spring.bookstore.service.BookService;

@Controller
@RequestMapping("/book")
public class BookController {

	static List<Category> categoryList;
	
	@Autowired
	BookService bookService;
	@Autowired
	private ConversionService conversionService;

	static {
		categoryList = new LinkedList<Category>();
		Category javaCategory = new Category();
		javaCategory.setName("java");
		Category linuxCategory = new Category();
		linuxCategory.setName("linux");
		categoryList.add(javaCategory);
		categoryList.add(linuxCategory);
	}

	@InitBinder
	public void initBinding(WebDataBinder binder) {

		binder.setConversionService(conversionService);
	}

	/*@ModelAttribute("categories")
	public List<Category> getAllCategories() {

		return categoryList;
	}*/

	@RequestMapping(value = { "/search" }, method = RequestMethod.GET)
	public List<Book> searchBook(@ModelAttribute BookSearchCriteria criteria, BindingResult result) {
		System.out.println(criteria.getCategory().getName());
		System.out.println(criteria.getTitle());
		return bookService.search(criteria);
	}
}
