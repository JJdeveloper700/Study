package com.example.mytest3.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.example.mytest3.entity.Memo;
import com.example.mytest3.repository.MemoRepository;

@Controller
public class MemoController {
	
	@Autowired
	private MemoRepository memoRepository;
	
	@RequestMapping("/")
	public String registForm() {
		
		return "registForm";
	}
	
	
	@RequestMapping("/regist")
	public String regist(@RequestParam("content")String content,@RequestParam("title")String title, @RequestParam("writer")String writer) {
		
		Memo memo= new Memo(0L,content,title,writer);
		
		memoRepository.save(memo);
		
		
		return "p1";

	}
	@RequestMapping("/list")
	public String list(Model model) {
		List<Memo> listValue = memoRepository.findAll();
		
		model.addAttribute("memolist",listValue); 
		
		return "list";
		
	}
}
