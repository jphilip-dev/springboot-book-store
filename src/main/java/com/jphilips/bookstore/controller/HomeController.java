package com.jphilips.bookstore.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.jphilips.bookstore.service.BookService;

@Controller
public class HomeController {

	@Autowired
	BookService bookService;

	@GetMapping({ "", "/" })
	public String home(Model model) {
		model.addAttribute("books", bookService.getAllBooks());

		return "index";
	}

	@GetMapping("/contact")
	public String contact() {
		return "contact";
	}

	@GetMapping("/books/book")
	public String showBook(Model model, @RequestParam int id,
			@RequestParam(name = "addedToCart", required = false) Boolean addedToCart) {
		model.addAttribute("book", bookService.getBookById(id));
		model.addAttribute("addToCart", true);

		if (addedToCart != null && addedToCart) {
			model.addAttribute("addToCart", true);
		}else {
			model.addAttribute("addToCart", false);
		}
		return "bookdetail";
	}
}
