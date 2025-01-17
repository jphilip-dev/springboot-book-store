package com.jphilips.bookstore.dto;

import com.jphilips.bookstore.entity.AppUser;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Size;
import lombok.Data;

@Data
public class RegisterDTO {
	@NotEmpty(message = "must not be empty")
	private String firstName;
	@NotEmpty(message = "must not be empty")
	private String lastName;
	
	@NotEmpty(message = "must not be empty")
	@Email
	private String email;
	
	private String phone;
	
	private String address;
	
	@Size(min = 6, message = "Minimum Password length is 6 characters")
	private String password;
	
	private String confirmPassword;
	
	public static AppUser toEntity(RegisterDTO registerDTO) {
		AppUser appUser = new AppUser();
		
		appUser.setFirstName(registerDTO.getFirstName());
		appUser.setLastName(registerDTO.getLastName());
		appUser.setEmail(registerDTO.getEmail());
		appUser.setPhone(registerDTO.getPhone());
		appUser.setAddress(registerDTO.getAddress());
		appUser.setPassword(registerDTO.getPassword());
		
		return appUser;
	}
}
