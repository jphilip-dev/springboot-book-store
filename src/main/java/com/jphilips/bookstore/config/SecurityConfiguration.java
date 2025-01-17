package com.jphilips.bookstore.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
@EnableWebSecurity
public class SecurityConfiguration {
	
	@Bean
	public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
		return http
				.authorizeHttpRequests(auth -> auth
						.requestMatchers("/images/**", "/css/**", "/js/**").permitAll()
						.requestMatchers("/").permitAll()
						.requestMatchers("/books/**").permitAll()
						.requestMatchers("/contact").permitAll()
						.requestMatchers("/store/**").permitAll()
						.requestMatchers("/register").permitAll()
						.requestMatchers("/login").permitAll()
						.requestMatchers("/logout").permitAll()
						.anyRequest().authenticated()
				)
				.formLogin(form -> form
						.defaultSuccessUrl("/",true)
				)
				.logout(config -> config.logoutSuccessUrl("/"))
				.build();
	}
	
	@Bean
	public PasswordEncoder passwordEncoder() {
		return new BCryptPasswordEncoder();
	}
}
