package com.vsii.spring.bookstore.service.impl.test;

import java.util.LinkedList;
import java.util.List;

import org.springframework.stereotype.Service;

import com.vsii.spring.bookstore.model.Book;
import com.vsii.spring.bookstore.model.BookSearchCriteria;
import com.vsii.spring.bookstore.model.Category;
import com.vsii.spring.bookstore.service.BookService;

@Service("bookService")
public class BookServiceImpl implements BookService {

	static List<Book> bookList;

	static {
		Category javaCategory = new Category();
		javaCategory.setName("java");
		
		Book book1 = new Book();
		book1.setTitle("Beginning Java EE");
		book1.setCategory(javaCategory);

		Book book2 = new Book();
		book2.setTitle("Spring 3 WebMVC");
		book2.setCategory(javaCategory);

		bookList = new LinkedList<Book>();
		bookList.add(book1);
		bookList.add(book2);
	}

	@Override
	public List<Book> search(BookSearchCriteria criteria) {

		return bookList;
	}

}
