package com.jphilips.bookstore.controller;

import java.security.Principal;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.jphilips.bookstore.service.CartItemService;

@Controller
public class CartController {
	
	@Autowired
	private CartItemService cartItemService;
	
	@PostMapping("/add-to-cart")
    public String addToCart(Model model,
    		@RequestParam("bookId") int bookId, 
                            @RequestParam("quantity") int quantity, 
                            Principal principal) {
        // Get the current user (for user-specific carts)
		String username = principal.getName();
        //cartService.addItemToCart(username, bookId, quantity);
        System.out.println(username + " added to cart "+  bookId);
        // Redirect to the cart page or wherever you want after adding
        cartItemService.addToCart(username,bookId, quantity);
        
        return "redirect:/books/book?id=" + bookId + "&addedToCart=true";
    }
	
	@GetMapping("/cart")
	public String showCart(Model model,Principal principal) {
		String username = principal.getName();
		
		model.addAttribute("cart", cartItemService.getAllItemsOfUser(username));
		
		return "cart";
	}
	
	@GetMapping("/cart/delete")
	public String deleteItem(@RequestParam int id) {
		cartItemService.deleteItem(id);
		
		return "redirect:/cart";
	}
	
	@GetMapping("/cart/edit")
	public String editItem(@RequestParam int id) {
		
		return "redirect:/books/book?id=" + id ;
	}
}
