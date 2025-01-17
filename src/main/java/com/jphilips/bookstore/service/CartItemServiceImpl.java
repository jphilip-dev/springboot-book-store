package com.jphilips.bookstore.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.jphilips.bookstore.entity.AppUser;
import com.jphilips.bookstore.entity.Book;
import com.jphilips.bookstore.entity.CartItem;
import com.jphilips.bookstore.repository.AppUserRepository;
import com.jphilips.bookstore.repository.BookRepository;
import com.jphilips.bookstore.repository.CartRepository;
@Service
public class CartItemServiceImpl implements CartItemService{
	
	@Autowired
	private CartRepository cartRepository;
	
	@Autowired
	private BookRepository bookRepository;
	
	@Autowired
	private AppUserRepository appUserRepository;
	
	@Override
	public List<CartItem> getAllItems() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public CartItem getCartItemById(int id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<CartItem> getAllItemsOfUser(String username) {
		AppUser appUser = appUserRepository.findByEmail(username);
		
		return cartRepository.findByAppUserId(appUser.getId());
	}

	@Override
	public CartItem addToCart(String username,int bookId, int qty) {
		Book book = bookRepository.findById(bookId).get();
		AppUser appUser = appUserRepository.findByEmail(username);
		
		// check if exist
		CartItem oldCartItem = cartRepository.findItemwithUser(appUser.getId(),bookId );
		
		if (oldCartItem != null) {
			oldCartItem.setQty(qty);
			return cartRepository.save(oldCartItem);
		}else {
			CartItem cartItem = new CartItem();
			
			cartItem.setAppUser(appUser);
			cartItem.setBook(book);
			cartItem.setQty(qty);
			cartItem.setPrice(book.getPrice());
			cartItem.setImagePath(book.getImagePath());
			
			cartItem.setBookName(book.getTitle());
			cartItem.setAuthor(book.getAuthor());
			double total = book.getPrice() * qty;
			
			cartItem.setTotal(total);
			
			return cartRepository.save(cartItem);
		}
		
	}

	@Override
	public void deleteItem(int id) {
		CartItem cartItem = cartRepository.findById(id).get();
		cartRepository.delete(cartItem);
	}

}
