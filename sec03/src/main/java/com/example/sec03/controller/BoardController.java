package com.example.sec03.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/board")
public class BoardController {
	@GetMapping("/")
	public String root() {

		return "board/main";

	}
	@GetMapping("/boardForm")
	public String boardForm() {
		return "/board/boardForm";
	}
	@PostMapping("/boardProc")
	public String boardProc() {
		return "/board/boardlist";
	}
	
}
