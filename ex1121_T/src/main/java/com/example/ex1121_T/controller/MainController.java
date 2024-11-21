package com.example.ex1121_T.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class MainController {
	
	@RequestMapping("/")
	public String root(Model model) { 
		
		model.addAttribute("title","Main Page");
		
		return "main";
	}
}
