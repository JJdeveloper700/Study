package com.example.ex03.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.example.ex03.dao.IBoardDao;
import com.example.ex03.dto.BoardDto;

@Controller
@RequestMapping("/board")
public class BoardController {
	@Autowired
	IBoardDao boardDao; 
	@RequestMapping("/boardregist")
	public String boardregist(BoardDto boardDto) {
		System.out.println(boardDto);
		boardDao.regist(boardDto);
		
		return "/board/p2";
	}
	@RequestMapping("/list")
	public String list(Model model) {
		
		List <BoardDto> list =boardDao.getList();
		model.addAttribute("list",list);
		System.out.println(list);
		return "/board/list";
	}
}
