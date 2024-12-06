package com.example.ex05.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.example.ex05.dao.IBoardDao;
import com.example.ex05.dao.IReplyDao;
import com.example.ex05.dto.BoardDto;
import com.example.ex05.dto.ReplyDto;

@Controller
@RequestMapping("/board")
public class BoardController {
	@Autowired
	IBoardDao boardDao; 
	@Autowired
	IReplyDao replyDao;
	
	@RequestMapping("/main")
	public String root() {
		return "/board/main";
		
	}
	@RequestMapping("/RegistForm") //여러 테이블을 쓸때는 url 패턴을 잘 써줘야 한다. 
	public String RegistForm() {
		return "/board/RegistForm"; // board 가 일반 템플릿의 하위 템플릿이면 앞에 템플릿 이름 ex) board/registForm 붙이고 만약 어노테이션이 미리 "/템플릿 명"으로 설정되어 있으면 생략이 가능하다. 
	}
	@RequestMapping("/regist")
	public String regist(BoardDto boardDto ,Model model) {
		boardDao.regist(boardDto); //이 부분 다시 고민해보기.
	
		return "redirect:/board/list";
	}
	@RequestMapping("/list")
	public String list(Model model) {
		List<BoardDto> list=boardDao.getList();
		model.addAttribute("list",list);
		return "/board/list";
	}
	@RequestMapping("/list2")
	public String list2(Model model) {
		List<BoardDto> list=boardDao.getList2();
		model.addAttribute("list",list);
		return "/board/list2";
	}
	
	@RequestMapping("/list3")
	public String list3(Model model) {
		List<BoardDto> list=boardDao.getList3(0);
		model.addAttribute("list",list);
		return "/board/list3";
	}
	
	@RequestMapping("/getBoard")
	public String getBoard(@RequestParam("search-bno")int bno,Model model) {
		BoardDto board = boardDao.getBoard(bno);
		List<ReplyDto> replyList = replyDao.getList(bno);
		model.addAttribute("board",board);
		model.addAttribute("replyList",replyList);
		return "/board/result";
	}
	@RequestMapping("/update")
	public String update(BoardDto boardDto) {
		boardDao.update(boardDto);
		return "redirect:/board/list";
	}
	@RequestMapping("/delete")
	public String delete(@RequestParam("delete-bno")int bno) {
		boardDao.delete(bno);
		return "redirect:/board/list";
	}
	
	
		
	
}
