package com.jphilips.bookstore.service;

import java.time.LocalDate;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import com.jphilips.bookstore.dto.RegisterDTO;
import com.jphilips.bookstore.entity.AppUser;
import com.jphilips.bookstore.repository.AppUserRepository;

@Service
public class AppUserServiceImpl implements AppUserService {

	@Autowired
	AppUserRepository appUserRepository;
	
	BCryptPasswordEncoder bcryptEncoder = new BCryptPasswordEncoder();

	@Override
	public AppUser findAppUserByEmail(String email) {
		return appUserRepository.findByEmail(email);
	}

	@Override
	public AppUser addAppUser(RegisterDTO registerDTO) {
		AppUser appUser = RegisterDTO.toEntity(registerDTO);
		
		appUser.setPassword(bcryptEncoder.encode(appUser.getPassword()));
		
		appUser.setCreatedAt(LocalDate.now());
		appUser.setRole("CLIENT");
		
		return appUserRepository.save(appUser);
	}

	@Override
	public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
		AppUser appUser = appUserRepository.findByEmail(email);

		if (appUser != null) {

			UserDetails userDetails = User.withUsername(appUser.getEmail()).password(appUser.getPassword())
					.roles(appUser.getRole()).build();

			return userDetails;
		}

		return null;
	}
}
