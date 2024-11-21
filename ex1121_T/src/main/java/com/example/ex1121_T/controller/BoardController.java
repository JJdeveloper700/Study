package com.example.ex1121_T.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.example.ex1121_T.dto.BoardDto;

@Controller
public class BoardController {
	@RequestMapping("/regForm")
	public String regForm() {
		
		return "/board/regForm"; 
		
	}
	
	@RequestMapping("regist")
	public String regist(BoardDto boardDto) {
		
		return "redirect:/board/list"; 
		
	}
	@RequestMapping("list")
	public String list(Model model) {
		
		return "board/list";
			
	}
}
