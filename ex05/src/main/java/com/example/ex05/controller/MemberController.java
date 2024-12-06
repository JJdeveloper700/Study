package com.example.ex05.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.example.ex05.dao.IMemberDao;
import com.example.ex05.dto.MemberDto;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpSession;

@Controller
public class MemberController {
	@Autowired
	IMemberDao memberDao; 
	
	
	@RequestMapping("/")
	public String root() {
		return "main";
	}
	@RequestMapping("/registForm")
	public String registForm() {
		return "registForm";
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
	@RequestMapping("/idCheck")
	public @ResponseBody String idCheck(@RequestParam("id")String id) {
		String msg=""; 
		
		int result = memberDao.idCheck(id);
		
		if(result==1) {
			msg="이미 사용중인 아이디 입니다.";
		}else {
			msg="사용가능한 아이디입니다.";
		}
		
		return msg;
	}
	
	
	
	@RequestMapping("/Login")
	public String Login(@RequestParam("id")String id, @RequestParam("pw")String pw, HttpServletRequest request){
		System.out.println(id+","+ pw);
		String view= ""; 
		HttpSession session= request.getSession();
		MemberDto member = memberDao.LoginCheck(id, pw);
		System.out.println(member != null);
		if(member!=null) {
			session.setAttribute("member", member);
			view="/success";
		}else {
			System.out.println("실패");
			view="/LoginForm";
		}
		
		return view;
	}
	
	
	
	
	
	

	

}
