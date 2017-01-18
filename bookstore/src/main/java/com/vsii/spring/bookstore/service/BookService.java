package com.vsii.spring.bookstore.service;

import java.util.List;

import com.vsii.spring.bookstore.model.Book;
import com.vsii.spring.bookstore.model.BookSearchCriteria;

public interface BookService {

	public List<Book> search(BookSearchCriteria criteria);
}
