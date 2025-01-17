package com.jphilips.bookstore.service;

import java.util.List;

import com.jphilips.bookstore.entity.Book;

public interface BookService {
	List<Book> getAllBooks();
	Book getBookById(int id);
	
}
