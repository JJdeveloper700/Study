package com.example.ex05.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.example.ex05.dao.IReplyDao;
import com.example.ex05.dto.MemberDto;
import com.example.ex05.dto.ReplyDto;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpSession;

@Controller
@RequestMapping("/reply")
public class ReplyController {
	@Autowired
	private IReplyDao replyDao; 
	
	
	
	
	@RequestMapping("/regist0")
	public String reply_regist(@RequestParam("comments")String comments,
			@RequestParam("bno")int bno, HttpServletRequest request,
			RedirectAttributes rttr){
		
		System.out.println("reply regist......");
		
	HttpSession session = request.getSession(); 
	MemberDto member = (MemberDto)session.getAttribute("member"); 
	String writer= member.getId(); 
	
	ReplyDto reply = new ReplyDto(); 
	reply.setComments(comments);
	reply.setWriter(writer); 
	reply.setBno(bno); 
	
	replyDao.regReply(reply); 

	return "redirect:/board/getBoard?search-bno="+bno;
	}
	
}
