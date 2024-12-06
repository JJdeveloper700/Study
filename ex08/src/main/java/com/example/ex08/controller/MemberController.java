package com.example.ex08.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.example.ex08.dao.IMemberDao;
import com.example.ex08.dto.MemberDto;

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
		
		return "loginMain";
	}
	@RequestMapping("/idCheck")
	public @ResponseBody String idCheck(@RequestParam("id")String id) {
		
		String msg; 
	
		int result = memberDao.idCheck(id);
		if(result==1) {
			msg="이미 사용중인 아이디입니다."; 
		}else if(result==0) {
			msg="사용 가능한 아이디 입니다.";
		}else {
			msg="아이디를 입력해주세요";
		}
		
			return msg;	
	}
	
	
	@RequestMapping("/loginForm")
	public String loginForm() {
		return "loginForm";
	}
	@RequestMapping("/login")
	public String login(@RequestParam("id")String id, @RequestParam("pw")String pw, HttpServletRequest request) {
		System.out.println(id+","+ pw);
		String view=""; 
		
		HttpSession session = request.getSession();
		
		MemberDto member = memberDao.LoginCheck(id, pw); 
		
		if(member!=null) {
			view="/success";
			session.setAttribute("member", member);
		}else
			view="/loginForm";
		
		return view;  //이거 왜 이렇게 되는지 알아야한다.
	}
}
