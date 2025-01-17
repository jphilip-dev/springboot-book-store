package com.jphilips.bookstore.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.jphilips.bookstore.entity.AppUser;


public interface AppUserRepository extends JpaRepository<AppUser, Integer>{
	public AppUser findByEmail(String email);
}
