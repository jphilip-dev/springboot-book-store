package com.jphilips.bookstore.service;

import org.springframework.security.core.userdetails.UserDetailsService;

import com.jphilips.bookstore.dto.RegisterDTO;
import com.jphilips.bookstore.entity.AppUser;

public interface AppUserService extends UserDetailsService{
	AppUser findAppUserByEmail(String email);
	AppUser addAppUser(RegisterDTO registerDTO);
}
