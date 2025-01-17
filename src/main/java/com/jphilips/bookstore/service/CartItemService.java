package com.jphilips.bookstore.service;

import java.util.List;

import com.jphilips.bookstore.entity.CartItem;

public interface CartItemService {
	List<CartItem> getAllItems();
	CartItem getCartItemById(int id);
	CartItem addToCart(String username, int bookId,int qty);
	void deleteItem(int id);
	
	List<CartItem> getAllItemsOfUser(String username);
}
