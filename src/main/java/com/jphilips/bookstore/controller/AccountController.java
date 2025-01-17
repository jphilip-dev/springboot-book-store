package com.jphilips.bookstore.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;

import com.jphilips.bookstore.dto.RegisterDTO;
import com.jphilips.bookstore.entity.AppUser;
import com.jphilips.bookstore.service.AppUserService;

import jakarta.validation.Valid;

import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class AccountController {
	@Autowired
	private AppUserService appUserService;

	@GetMapping("/register")
	public String register(Model model) {
		RegisterDTO registerDTO = new RegisterDTO();
		model.addAttribute("registerDTO", registerDTO);
		model.addAttribute("success", false);
		return "register";
	}

	@PostMapping("/register")
	public String register(Model model, @Valid @ModelAttribute RegisterDTO registerDTO, BindingResult bindingResult) {

		if (!registerDTO.getPassword().equals(registerDTO.getConfirmPassword())) {
			bindingResult.addError(
					new FieldError("registerDTO", "confirmPassword", "Password and Confirm Password do not match"));
		}

		AppUser appUser = appUserService.findAppUserByEmail(registerDTO.getEmail());

		if (appUser != null) {
			bindingResult.addError(new FieldError("registerDTO", "email", "Email Address is already used"));
		}

		if (bindingResult.hasErrors()) {
			return "register";
		}

		try {
			appUserService.addAppUser(registerDTO);

			model.addAttribute("registerDTO", new RegisterDTO());
			model.addAttribute("success", true);
		} catch (Exception e) {
			System.err.println("Exception: " + e);
		}

		return "register";
	}

}
