package com.jphilips.bookstore.entity;

import org.hibernate.annotations.Columns;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import jakarta.persistence.UniqueConstraint;
import lombok.Data;

@Data
@Entity
@Table(name = "cart", uniqueConstraints = @UniqueConstraint(columnNames = {"user_id", "book_id"}))
public class CartItem {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	
	@ManyToOne
	@JoinColumn(name = "book_id", nullable = false ) 
	private Book book;
	
	@ManyToOne
	@JoinColumn(name = "user_id", nullable = false)
	private AppUser appUser;
	
	private String bookName;
	private String author;
	
	@Column( nullable = false)
	private int qty;
	@Column( nullable = false)
	private double price;
	@Column( nullable = false)
	private double total;
	
	private String imagePath;
}
