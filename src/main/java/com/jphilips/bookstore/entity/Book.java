package com.jphilips.bookstore.entity;

import java.time.LocalDate;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;

@Data
@Entity
@Table(name = "books")
public class Book {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	
	@Column(nullable = false, unique = true)
	private String title;
	
	@Column(nullable = false)
	private String author;
	
	@Column(columnDefinition = "TEXT")
	private String description;
	
	@Column(nullable = false)
	private LocalDate publishedDate;
	
	@Column(nullable = false)
	private double price;
	
	private int rating;
	
	@Column(nullable = false)
	private int copies;
	
	private String imagePath;
	
	
}
