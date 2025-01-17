package com.jphilips.bookstore.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.jphilips.bookstore.entity.Book;

public interface BookRepository extends JpaRepository<Book, Integer>{

}
