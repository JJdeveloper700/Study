package com.example.sec02.secu;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;

@Configuration //컨피그 클래스입니다. <--한번더 물어보기 //스프링에서 관리하는 것으로 하자.
@EnableWebSecurity // 시큐리티 하는 것입니다. <-- 한번더 물어보기 
public class SecurityConfig {
	
	@Bean
	BCryptPasswordEncoder bCryptPasswordEncorder() {
		return new BCryptPasswordEncoder();
	}
	
	
	
	@Bean //리턴하는 객체에 대해서 빈이 관리해주는 것으로 등록하는것. 
	SecurityFilterChain filterChain(HttpSecurity http) throws Exception{

		http
		.formLogin((auth) ->auth
				.loginPage("/loginForm") //내가 만든 로그인 폼을 만들고 싶을 때는 꼭 지정해줘야 한다
				.loginProcessingUrl("/loginProc")
				.defaultSuccessUrl("/members/mypage")
				.permitAll()
				
				);
		
		http
				.authorizeHttpRequests((auth) -> auth
						.requestMatchers("/","/registForm","/registProc","/loginForm","/loginProc").permitAll()
						.requestMatchers("/members/**").hasAnyRole("MEMBER","ADMIN")
						.requestMatchers("/admin/**").hasRole("ADMIN")
						.anyRequest().authenticated()
						);
		

		
		http
				.logout(auth -> auth
					.logoutSuccessUrl("/")
		
				);
		/*http
				.csrf(auth->auth.disable());
		*/
		return http.build(); //-- 필터 체인 타입으로 반환.... 
	}

}
