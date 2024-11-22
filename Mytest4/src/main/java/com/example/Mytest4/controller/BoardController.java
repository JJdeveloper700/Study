package com.example.Mytest4.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.example.Mytest4.entity.Board;
import com.example.Mytest4.repository.BoardRepository;

@Controller
public class BoardController {
	
	@Autowired
	BoardRepository boardRepository; 
	
	@RequestMapping("/")
	public String regform() { 
		return "regform"; 
	}
	@RequestMapping("/regist2")
	public String regist2(@RequestParam("title")String title, @RequestParam("content")String content,@RequestParam("writer")String writer) {
		
		Board board = new Board(0L,title,content,writer); 
		
		boardRepository.save(board); 
		
		return "p1";
	}
	@RequestMapping("/list")
	public String list(Model model) {
		List<Board> listValue = boardRepository.findAll();
		
		model.addAttribute("boardlist",listValue); 
		
		return "list";
	}
	@RequestMapping("/detailboard")
	public String detailboard(@RequestParam("mno")Long mno,Model model) {
		Optional<Board> result = boardRepository.findById(mno);
		Board board = result.get();
		model.addAttribute("board",board);
		return "detailboard";
		
	}
	@RequestMapping("/update")
	public String update(@RequestParam("mno")Long mno,@RequestParam("title")String title, @RequestParam("content")String content, @RequestParam("writer")String writer) {
		System.out.println("+++++++++++++++++++++++++++++++++++"+title);
		//long mno = Long.parseLong(_mno);
		Board board = Board.builder()
				.mno(mno)
				.title(title)
				.content(content)
				.writer(writer)
				.build();
		
		boardRepository.save(board);
		
		return "redirect:/list"; 
	}
}
