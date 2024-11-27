package com.example.ex00.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.example.ex00.dao.IBoardDao;
import com.example.ex00.dto.BoardDto;

@Controller
public class Mycontroller {
		@Autowired
		IBoardDao boardDao; 
	
	@RequestMapping({"/","/main"}) // 서블릿 역할을 할수 있는 어노테이션 -- 요청과 응답을 할 수있다. 
	public String main() {
		System.out.println("**** 컨트롤러 메서드 동작함");
		return "main"; //문자열 데이터와 페이지를 구분하기 
	}
	@RequestMapping("/p1")
	public String p1() {
		System.out.println("**** p1 페이지 여는 메서드 동작함*****");
		return "p1";
	}
	@RequestMapping("/p2")
	public String p2(@RequestParam("title")String title,@RequestParam("content")String content, @RequestParam("writer") String writer, Model model) {
		System.out.println("*****p2 페이지 여는 매서드 동작함 *****" + title+","+ content+","+writer+",");
		model.addAttribute("x",title);
		model.addAttribute("y",content);
		model.addAttribute("z",writer);
		return "p2";
	}
	@RequestMapping("/p3")
	public String p3(BoardDto boardDto) {
		System.out.println("*****p3 페이지 여는 매서드 동작함 *****" +boardDto.getTitle()+","+ boardDto.getContent()+","+boardDto.getWriter());
		boardDao.regist(boardDto);

		
		return "p3";
	}
	@RequestMapping("/list")
	public String list(Model model) {
		List<BoardDto>list= boardDao.getList();
		model.addAttribute("list",list);
		return "list"; 
	}
	@RequestMapping("/findBoard")
	public String findBoard(@RequestParam("search-bno")int bno ,Model model) {
		
		BoardDto board = boardDao.getBoard(bno);
		
		model.addAttribute("board",board);
		
		return "result";
	}
	
	@RequestMapping("/updateBoard")
	public String updateBoard(BoardDto boardDto) {
		
		boardDao.updateBoard(boardDto);
		
		return "redirect:/list";
	}
	
	
	
	@RequestMapping("/deleteBoard")
	public String deleteBoard(@RequestParam("delete-bno")int bno) {
		
		boardDao.deleteBoard(bno);
		
		
		
		return "redirect:/list";
	}
}
