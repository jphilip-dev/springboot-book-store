package com.jphilips.bookstore.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.jphilips.bookstore.entity.Book;
import com.jphilips.bookstore.repository.BookRepository;
@Service
public class BookServiceImpl implements BookService{
	
	@Autowired
	BookRepository bookRepository;
	
	
	@Override
	public List<Book> getAllBooks() {
		return bookRepository.findAll();
	}


	@Override
	public Book getBookById(int id) {
		return bookRepository.findById(id).get();
	}

}
