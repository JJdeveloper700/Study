package com.example.sec02.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import com.example.sec02.entity.Member;
import com.example.sec02.service.MemberService;

@Controller
public class MainController {
	@Autowired
	MemberService memberService; 
	
	@GetMapping("/")
	public String main() {
		return "main";
	}
	
	@GetMapping("/registForm")
	public String registForm() {
		return "registForm";
	}
	
	@PostMapping("/registProc")
	public String registProc(Member member) {
		memberService.regist(member);
		return "redirect:/login";
	}
	
	@GetMapping("/loginForm")
	public String loginForm() {
		return "loginForm";
	}
	
		
	
}
