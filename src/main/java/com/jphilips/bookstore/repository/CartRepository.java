package com.jphilips.bookstore.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.jphilips.bookstore.entity.CartItem;
@Repository
public interface CartRepository extends JpaRepository<CartItem, Integer>{
	
	@Query("SELECT c FROM CartItem c WHERE c.appUser.id = :userId and c.book.id = :bookId")
	CartItem findItemwithUser(@Param("userId") int id, @Param("bookId") int bookId);
	
	List<CartItem> findByAppUserId(int id);

}
