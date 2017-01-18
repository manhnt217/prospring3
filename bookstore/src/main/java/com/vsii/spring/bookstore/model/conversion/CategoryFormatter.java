package com.vsii.spring.bookstore.model.conversion;

import java.text.ParseException;
import java.util.Locale;

import org.springframework.format.Formatter;

import com.vsii.spring.bookstore.model.Category;


public class CategoryFormatter implements Formatter<Category> {

	@Override
	public String print(Category category, Locale locale) {

		System.out.println("Printing...");
		return category.getName();
	}

	@Override
	public Category parse(String name, Locale locale) throws ParseException {

		System.out.println("Parsing...");
		Category category = new Category();
		category.setName(name);
		return category;
	}

}
