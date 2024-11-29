package com.example.ex03.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.example.ex03.dao.IMemberDao;
import com.example.ex03.dto.MemberDto;

import jakarta.servlet.http.HttpSession;

@Controller
public class MemberController {
	
	@Autowired
	private IMemberDao memberDao; 
	
	@RequestMapping("/")
	public String root() {
		
		return "main";
	}
	
	@RequestMapping("/RegistForm")
	public String RegistForm() {
		
		return "RegistForm";
	}
	@RequestMapping("/regist")
	public String regist(MemberDto memberDto) {
		memberDao.regist(memberDto);
		
		return "p1";
	}
	@RequestMapping("/LoginForm")
	public String LoginForm() {
		return "LoginForm";
	}
	@RequestMapping("/idcheck")
	public @ResponseBody String idcheck(@RequestParam("id")String id) {
		System.out.println("idcheck*******"+id);
		String msg = "";
		
		int result = memberDao.idCheck(id); 
		
		if(result==1) {
			msg="이미 사용중인 아이디입니다."; 
		}else {
			msg="사용 가능한 아이디입니다.";
		
		}
		 return msg;	
			
	}
	@RequestMapping("/Login")
	public String Login(@RequestParam("id")String id, @RequestParam("pw")String pw, HttpSession session) {
		String view ="";
		 MemberDto member= memberDao.LoginCheck(id, pw);
		
		 if(member != null) {
			 session.setAttribute("member", member);
			 view="/success";
		 }else {
			 view="/LoginForm";
		 }
		 return "success";
		 

	}
	@RequestMapping("/board/BoardRegist")
	public String BoardRegist() {
		return "board/BoardRegist";
	}
	


}
