package com.example.sec03.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/members")
public class MemberController {
	@GetMapping("/mypage")
	public String mypage() {
		return "/members/mypage";
	}
	
}
