package com.example.mytest2.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.example.mytest2.entity.Board;
import com.example.mytest2.repository.Boardrepository;

@Controller
public class BoardController {
	
	@Autowired
	Boardrepository boardRepository;
	
	@RequestMapping("/")
	public String registForm() {
		return "registForm"; 
	}
	
	@RequestMapping("/regist")
	public String regist(@RequestParam("title")String title, @RequestParam("content")String content, @RequestParam("writer")String writer) {
		
		Board board = new Board(0L,title,content,writer);
		
		boardRepository.save(board);
		
		
		return "p1"; 
	}
	@RequestMapping("/list")
	public String list(Model model) {
		List<Board> listValue =boardRepository.findAll();
		
		
		model.addAttribute("boardlist",listValue); 
		
		return "list";
		
	}
}	