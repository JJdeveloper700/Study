package com.example.ex04.controller;

import java.util.List;

import org.apache.ibatis.annotations.Param;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.example.ex04.dao.IMemberDao;
import com.example.ex04.dto.MemberDTO;

@Controller
public class MemberController {
	@Autowired
	IMemberDao dao;

	@RequestMapping("/")
	public String root() {
		return "main";
	}

	@RequestMapping("/list")
	public String list(Model model) {
		List<MemberDTO> list = dao.getList();
		model.addAttribute("x", list);
		return "list";
	}

	@RequestMapping("/Member")
	public String Member(@RequestParam String id,@RequestParam String pw,@RequestParam String name) {
		MemberDTO m = new MemberDTO();
		m.setId("aaa");
		m.setPw("a1234");
		m.setName("Bobby");

		return "m";
	
	}
	








}
