package com.example.sec03.secu;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;
@Configuration
@EnableWebSecurity
public class SecurityConfig {
	
	@Bean
	BCryptPasswordEncoder bCryptPasswordEncoder() {
		return new BCryptPasswordEncoder();
	
	}
	
	
	@Bean
	SecurityFilterChain filterChain(HttpSecurity http) throws Exception{
		
		
		http
			.formLogin((auth) ->auth
				.loginPage("/loginForm")
				.loginProcessingUrl("/loginProc")
				.defaultSuccessUrl("/members/mypage")
				.permitAll()
			
			);
			
		http 
			.authorizeHttpRequests((auth) -> auth 
					.requestMatchers("/","/registForm","/registProc").permitAll()
					.requestMatchers("/members/**").hasAnyRole("MEMBER","ADMIN")
					.requestMatchers("/admin/**").hasRole("ADMIN")
					.anyRequest().authenticated()
					);
		
		http
			.logout(auth -> auth
					.logoutSuccessUrl("/")
					);
	
		
		
		
		return http.build();
	}
}
